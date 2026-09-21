package kh.mptc.kakada.ecommerce.order.persistence.repository;

import kh.mptc.kakada.ecommerce.order.persistence.entity.BusinessEntity;
import kh.mptc.kakada.ecommerce.order.persistence.entity.BusinessIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BusinessJpaRepository extends JpaRepository<BusinessIdEntity, BusinessIdEntity> {

    List<BusinessEntity> findByBusinessIdAndProductIdIn(
            UUID businessId,
            List<UUID> products
    );

}
