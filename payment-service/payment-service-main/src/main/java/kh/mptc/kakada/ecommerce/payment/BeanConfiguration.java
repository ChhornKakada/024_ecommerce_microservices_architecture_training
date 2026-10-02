package kh.mptc.kakada.ecommerce.payment;

import kh.mptc.kakada.ecommerce.payment.domain.service.PaymentDomainService;
import kh.mptc.kakada.ecommerce.payment.domain.service.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  public PaymentDomainService paymentDomainService() {
    return new PaymentDomainServiceImpl();
  }
}
