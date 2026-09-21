package kh.mptc.kakada.ecommerce.order.persistence.repository;

import kh.mptc.kakada.ecommerce.order.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {



}
