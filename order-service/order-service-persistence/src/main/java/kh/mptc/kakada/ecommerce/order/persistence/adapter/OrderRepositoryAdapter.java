package kh.mptc.kakada.ecommerce.order.persistence.adapter;

import kh.mptc.kakada.ecommerce.order.domain.entity.Order;
import kh.mptc.kakada.ecommerce.order.domain.port.output.OrderRepository;
import kh.mptc.kakada.ecommerce.order.persistence.entity.OrderEntity;
import kh.mptc.kakada.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import kh.mptc.kakada.ecommerce.order.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);
        return orderPersistenceMapper
                .orderEntityToOrder(
                        orderJpaRepository.save(orderEntity)
                );
    }
}
