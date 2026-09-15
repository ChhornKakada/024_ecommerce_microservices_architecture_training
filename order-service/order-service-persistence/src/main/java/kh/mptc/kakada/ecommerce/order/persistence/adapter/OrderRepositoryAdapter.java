package kh.mptc.kakada.ecommerce.order.persistence.adapter;

import kh.mptc.kakada.ecommerce.order.domain.entity.Order;
import kh.mptc.kakada.ecommerce.order.domain.port.output.OrderRepository;
import kh.mptc.kakada.ecommerce.order.persistence.repository.OrderJpaRepository;

public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }
}
