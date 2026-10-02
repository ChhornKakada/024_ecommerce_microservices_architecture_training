package kh.mptc.kakada.ecommerce.business.config;

import kh.mptc.kakada.ecommerce.business.domain.service.BusinessDomainService;
import kh.mptc.kakada.ecommerce.business.domain.service.BusinessDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public BusinessDomainService businessDomainService() {
        return new BusinessDomainServiceImpl();
    }
}

