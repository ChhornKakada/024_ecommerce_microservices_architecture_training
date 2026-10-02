package kh.mptc.kakada.ecommerce.business.persistence.adapter;

import kh.mptc.kakada.ecommerce.business.domain.entity.OrderApproval;
import kh.mptc.kakada.ecommerce.business.domain.port.output.OrderApprovalRepository;
import kh.mptc.kakada.ecommerce.business.persistence.entity.OrderApprovalEntity;
import kh.mptc.kakada.ecommerce.business.persistence.mapper.OrderApprovalPersistenceMapper;
import kh.mptc.kakada.ecommerce.business.persistence.repository.OrderApprovalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderApprovalRepositoryAdapter implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final OrderApprovalPersistenceMapper orderApprovalPersistenceMapper;

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        OrderApprovalEntity orderApprovalEntity = orderApprovalPersistenceMapper.orderApprovalToOrderApprovalEntity(orderApproval);

        return orderApprovalPersistenceMapper.orderApprovalEntityToOrderApproval(orderApprovalJpaRepository.save(orderApprovalEntity));
    }
}

