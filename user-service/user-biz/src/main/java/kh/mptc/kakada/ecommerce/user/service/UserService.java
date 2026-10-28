package kh.mptc.kakada.ecommerce.user.service;

import kh.mptc.kakada.ecommerce.user.dto.UserCreateRequest;
import kh.mptc.kakada.ecommerce.user.dto.UserResponse;
import kh.mptc.kakada.ecommerce.user.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {

    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);

    UserResponse getByUsername(String username);

    UserResponse delete(String id);

    List<UserResponse> getUsers();

    List<UserResponse> getUsersByRoleName(String roleName, Integer page, Integer limit);
}
