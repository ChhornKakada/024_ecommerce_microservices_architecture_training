package kh.mptc.kakada.ecommerce.business.persistence.repository;

import kh.mptc.kakada.ecommerce.business.persistence.entity.OrderApprovalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderApprovalJpaRepository extends JpaRepository<OrderApprovalEntity, UUID> {
}

