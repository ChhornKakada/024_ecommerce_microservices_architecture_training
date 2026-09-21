package kh.mptc.kakada.ecommerce.order.persistence.adapter;

import kh.mptc.kakada.ecommerce.order.domain.entity.Business;
import kh.mptc.kakada.ecommerce.order.domain.port.output.BusinessRepository;
import kh.mptc.kakada.ecommerce.order.persistence.entity.BusinessEntity;
import kh.mptc.kakada.ecommerce.order.persistence.mapper.BusinessPersistenceMapper;
import kh.mptc.kakada.ecommerce.order.persistence.repository.BusinessJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BusinessRepositoryAdapter implements BusinessRepository {

    private final BusinessJpaRepository businessJpaRepository;
    private final BusinessPersistenceMapper businessPersistenceMapper;

    @Override
    public Optional<Business> findBusiness(Business business) {
        List<UUID> businessProducts = businessPersistenceMapper.businessToBusinessProducts(business);
        List<BusinessEntity> businessEntities = businessJpaRepository.findByBusinessIdAndProductIdIn(
                business.getId().value(),
                businessProducts
        );
        return Optional.of(businessPersistenceMapper.businessEntityToBusiness(businessEntities));
    }
}
