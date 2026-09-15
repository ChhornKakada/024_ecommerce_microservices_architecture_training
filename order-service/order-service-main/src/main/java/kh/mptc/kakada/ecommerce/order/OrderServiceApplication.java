package kh.mptc.kakada.ecommerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
       "kh.mptc.kakada.ecommerce.order.persistence"
})
@EnableJpaRepositories(basePackages = {
        "kh.mptc.kakada.ecommerce.order.persistence"
})
@SpringBootApplication
public class OrderServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
