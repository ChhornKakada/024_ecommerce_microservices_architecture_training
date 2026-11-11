package kh.mptc.kakada.ecommerce.customer.client.fallback;

import kh.mptc.kakada.ecommerce.customer.client.dto.UserResponse;
import kh.mptc.kakada.ecommerce.customer.client.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFeignClientFallback implements UserFeignClient {

    // need to setup row
    @Override
    public UserResponse getById(String id) {
        log.info("userFeignClientFallback id", id);
        return null;
    }

}
