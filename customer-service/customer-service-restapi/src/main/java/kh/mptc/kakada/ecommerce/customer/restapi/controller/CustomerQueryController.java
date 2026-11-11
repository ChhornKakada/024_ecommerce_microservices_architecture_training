package kh.mptc.kakada.ecommerce.customer.restapi.controller;

import kh.mptc.kakada.ecommerce.customer.client.dto.UserResponse;
import kh.mptc.kakada.ecommerce.customer.client.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerQueryController {

    private final UserFeignClient userFeignClient;

    @GetMapping("/check-user/{userId}")
    public UserResponse checkUser(@PathVariable String userId) {
        return userFeignClient.getById(userId);
    }

}
