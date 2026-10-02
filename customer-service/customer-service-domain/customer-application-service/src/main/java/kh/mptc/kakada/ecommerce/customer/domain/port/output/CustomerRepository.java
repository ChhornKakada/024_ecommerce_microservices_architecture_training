package kh.mptc.kakada.ecommerce.customer.domain.port.output;


import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.customer.domain.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(CustomerId customerId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
