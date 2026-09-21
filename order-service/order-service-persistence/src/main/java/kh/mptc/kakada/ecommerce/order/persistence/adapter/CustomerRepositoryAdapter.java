package kh.mptc.kakada.ecommerce.order.persistence.adapter;

import kh.mptc.kakada.ecommerce.order.domain.entity.Customer;
import kh.mptc.kakada.ecommerce.order.domain.port.output.CustomerRepository;
import kh.mptc.kakada.ecommerce.order.persistence.mapper.CustomerPersistenceMapper;
import kh.mptc.kakada.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import kh.mptc.kakada.ecommerce.order.persistence.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerPersistenceMapper customerPersistenceMapper;

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository
                .findById(customerId)
                .map(customerPersistenceMapper::customerEntityToCustomer);
    }
}
