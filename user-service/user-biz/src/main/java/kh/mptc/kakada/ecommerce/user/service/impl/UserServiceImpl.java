package kh.mptc.kakada.ecommerce.user.service.impl;

import kh.mptc.kakada.ecommerce.user.base.UserDetail;
import kh.mptc.kakada.ecommerce.user.dto.UserCreateRequest;
import kh.mptc.kakada.ecommerce.user.dto.UserResponse;
import kh.mptc.kakada.ecommerce.user.dto.UserUpdateRequest;
import kh.mptc.kakada.ecommerce.user.entity.UserEntity;
import kh.mptc.kakada.ecommerce.user.exception.PasswordMismatchException;
import kh.mptc.kakada.ecommerce.user.exception.UserNotFoundException;
import kh.mptc.kakada.ecommerce.user.exception.UsernameConflictException;
import kh.mptc.kakada.ecommerce.user.mapper.UserMapper;
import kh.mptc.kakada.ecommerce.user.repository.UserRepository;
import kh.mptc.kakada.ecommerce.user.service.KeycloakRoleService;
import kh.mptc.kakada.ecommerce.user.service.KeycloakUserService;
import kh.mptc.kakada.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Marker;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeycloakUserService keycloakUserService;
    private final KeycloakRoleService keycloakRoleService;

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {

        // validate roles whether they are existed
        String[] roleNameList = userCreateRequest.roleName().split(",");
        List<RoleRepresentation> roleRepresentationList =
                Arrays.stream(roleNameList)
                        .map(String::trim)
                        .map(keycloakRoleService::getKeycloakRoleByName)
                        .toList();

        // validation username
        if (userRepository.existsByUsername(userCreateRequest.username())) {
            throw new UsernameConflictException(
                    HttpStatus.CONFLICT,
                    "Username already existed"
            );
        }

        // validate password
        if (!userCreateRequest.password().equals(userCreateRequest.confirmedPassword())) {
            throw new PasswordMismatchException(
                    HttpStatus.BAD_REQUEST,
                    "Passwords do not match"
            );
        }

        // save user info Keycloak
        UserRepresentation userRepresentation = userMapper.toRepresentation(userCreateRequest);
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(userCreateRequest.password());

        userRepresentation.setCredentials(List.of(credentialRepresentation));

        // create user in keycloak
        keycloakUserService.createKeycloakUser(userRepresentation);

        // find user in keycloak
        UserRepresentation createdUser = this.keycloakUserService.getKeycloakByUsername(
                userRepresentation.getUsername()
        );

        keycloakRoleService.assignRoles(createdUser.getId(), roleRepresentationList);

        // After saved user in keycloak, save user into DB
        UserEntity userEntity = userMapper.toEntity(userCreateRequest);
        userEntity.setId(createdUser.getId());
        userRepository.save(userEntity);

        return userMapper.toResponse(userEntity, createdUser);
    }

    @Override
    public UserResponse update(String id, UserUpdateRequest userUpdateRequest) {

        UserDetail userDetail = this.getDetailById(id);
        UserEntity userEntity = userMapper.fromUserDetailToUserEntity(userDetail);
        userMapper.toEntity(userUpdateRequest, userEntity);

        // save to database
        userRepository.save(userEntity);

        // format: user in keycloak
        UserRepresentation userRepresentation = this.userMapper.fromUserDetailToUserRepresentation(userDetail);

        if (userUpdateRequest.familyName() != null || userUpdateRequest.givenName() != null) {
            if (userUpdateRequest.familyName() != null) {
                userRepresentation.setLastName(userUpdateRequest.familyName());
            }
            if (userUpdateRequest.givenName() != null) {
                userRepresentation.setFirstName(userUpdateRequest.givenName());
            }
            keycloakUserService.updateKeycloakUser(id, userRepresentation);
        }

        // return new updated data
        return userMapper.toResponse(userEntity, userRepresentation);
    }

    @Override
    public UserResponse getById(String id) {
        UserDetail userDetail = this.getDetailById(id);
        return userMapper.fromUserDetailToUserResponse(userDetail);
    }

    @Override
    public UserResponse getByUsername(String username) {
        UserDetail userDetail = this.getDetailByUsername(username);
        return userMapper.fromUserDetailToUserResponse(userDetail);
    }

    @Override
    public UserResponse delete(String id) {
        UserResponse userResponse = this.getById(id);

        // Keep the database record if deletion from Keycloak fails.
        keycloakUserService.deleteKeycloakUser(id);
        userRepository.deleteById(id);

        return userResponse;
    }

    @Override
    public List<UserResponse> getUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream()
                .map(user -> userMapper.toResponse(user,
                        keycloakUserService.getKeycloakUserById(user.getId())))
                .toList();
    }

    @Override
    public List<UserResponse> getUsersByRoleName(String roleName, Integer page, Integer limit) {
        List<UserRepresentation> keycloakUsers = keycloakRoleService.getUsersByRoleName(roleName, page, limit);
        List<UserResponse> users = new ArrayList<>();
        for (UserRepresentation kUser : keycloakUsers) {
            UserEntity userEntity = userRepository
                    .findById(kUser.getId())
                    .orElseThrow(() -> new UserNotFoundException(
                            HttpStatus.NOT_FOUND,
                            "User " + kUser.getUsername() + " not found in database"
                    ));
            UserResponse userResponse = userMapper.toResponse(userEntity, kUser);
            users.addLast(userResponse);
        }
        return users;
    }

    private UserDetail getDetailById(String id) {

        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));

        UserRepresentation userRepresentation = keycloakUserService
                .getKeycloakByUsername(userEntity.getUsername());

        return userMapper.toUserDetail(userEntity, userRepresentation);
    }

    private UserDetail getDetailByUsername(String username) {

        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        HttpStatus.NOT_FOUND,
                        "User not found"
                ));

        UserRepresentation userRepresentation = keycloakUserService
                .getKeycloakByUsername(userEntity.getUsername());

        return userMapper.toUserDetail(userEntity, userRepresentation);
    }
}
