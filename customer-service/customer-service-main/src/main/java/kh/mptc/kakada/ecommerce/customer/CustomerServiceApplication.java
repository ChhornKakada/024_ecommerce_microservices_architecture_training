package kh.mptc.kakada.ecommerce.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"kh.mptc.kakada.ecommerce.customer.persistence"})
@EnableJpaRepositories(basePackages = "kh.mptc.kakada.ecommerce.customer.persistence")
@SpringBootApplication
public class CustomerServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
