package kh.mptc.kakada.ecommerce.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jakarta.validation.Valid;
import kh.mptc.kakada.ecommerce.user.dto.UserCreateRequest;
import kh.mptc.kakada.ecommerce.user.dto.UserResponse;
import kh.mptc.kakada.ecommerce.user.dto.UserUpdateRequest;
import kh.mptc.kakada.ecommerce.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final JsonMapper.Builder builder;

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Sentinel";
    }

    @SentinelResource(
            value = "getUsers",
            fallback = "getUserFallback"
//            blockHandler = "getUsersBlocked"
    )
    @GetMapping
    public List<UserResponse> getUsers() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return userService.getUsers();
    }

    @GetMapping("/role/{roleName}")
    public List<UserResponse> getUsersByRoleName(
            @PathVariable String roleName,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer limit
    ) {
        return userService.getUsersByRoleName(roleName, page, limit);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse create(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public UserResponse update(
            @PathVariable String id,
            @RequestBody UserUpdateRequest userUpdateRequest
    ) {
        return userService.update(id, userUpdateRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public UserResponse delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable String id) {
        return this.userService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/username/{username}")
    public UserResponse getByUsername(@PathVariable String username) {
        return this.userService.getByUsername(username);
    }

//    public Map<String, Object> getUserFallback(Throwable t) {
//        return Map.of("message", "Fallback getUsers");
//    }
//
//    public List<UserResponse> getUsersBlocked(BlockException e) {
//        IO.println(e.getMessage());
//        return List.of();
//    }
}
