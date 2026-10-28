package kh.mptc.kakada.ecommerce.user.mapper;

import kh.mptc.kakada.ecommerce.user.base.UserDetail;
import kh.mptc.kakada.ecommerce.user.dto.UserCreateRequest;
import kh.mptc.kakada.ecommerce.user.dto.UserResponse;
import kh.mptc.kakada.ecommerce.user.dto.UserUpdateRequest;
import kh.mptc.kakada.ecommerce.user.entity.UserEntity;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity fromUserDetailToUserEntity(UserDetail userDetail);

    @Mapping(source = "familyName", target = "lastName")
    @Mapping(source = "givenName", target = "firstName")
    UserRepresentation fromUserDetailToUserRepresentation(
            UserDetail userDetail
    );

    default UserResponse toResponse(
            UserEntity userEntity,
            UserRepresentation userRepresentation
    ) {
        return  UserResponse.builder()
                .id(userEntity.getId())
                .familyName(userRepresentation.getLastName())
                .givenName(userRepresentation.getFirstName())
                .gender(userEntity.getGender())
                .mobilePhone(userEntity.getMobilePhone())
                .address(userEntity.getAddress())
                .build();
    }

    UserResponse fromUserDetailToUserResponse(UserDetail userDetail);

    default UserDetail toUserDetail(
            UserEntity userEntity,
            UserRepresentation userRepresentation
    ) {
        return  UserDetail.builder()
                .id(userEntity.getId())
                .familyName(userRepresentation.getLastName())
                .givenName(userRepresentation.getFirstName())
                .username(userEntity.getUsername())
                .email(userRepresentation.getEmail())
                .gender(userEntity.getGender())
                .mobilePhone(userEntity.getMobilePhone())
                .address(userEntity.getAddress())
                .build();
    }


    // map only value != null
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(UserUpdateRequest request, @MappingTarget UserEntity entity);

    UserEntity toEntity(UserCreateRequest userCreateRequest);

    UserResponse toResponse(UserEntity userEntity);

    @Mapping(source = "familyName", target = "lastName")
    @Mapping(source = "givenName", target = "firstName")
    UserRepresentation toRepresentation(UserCreateRequest userCreateRequest);

}
