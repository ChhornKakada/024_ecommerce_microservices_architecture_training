package kh.mptc.kakada.ecommerce.persistence.repository;

import kh.mptc.kakada.ecommerce.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
}
