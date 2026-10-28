package kh.mptc.kakada.ecommerce.user;

import kh.mptc.kakada.ecommerce.restapi.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class UserServiceApplicationService {
  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplicationService.class, args);
  }
}
