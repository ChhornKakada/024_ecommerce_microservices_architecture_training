package kh.mptc.kakada.ecommerce.customer.client.feign;

import kh.mptc.kakada.ecommerce.customer.client.dto.UserResponse;
import kh.mptc.kakada.ecommerce.customer.client.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        // the same as in nacos
        name = "user-service",
        path = "/api/users",
        fallback = UserFeignClientFallback.class
)
public interface UserFeignClient {

    @GetMapping("/{id}")
    UserResponse getById(@PathVariable String id);
}
