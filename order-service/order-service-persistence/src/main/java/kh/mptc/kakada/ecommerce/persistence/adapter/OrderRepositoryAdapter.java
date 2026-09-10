package kh.mptc.kakada.ecommerce.persistence.adapter;

import kh.mptc.kakada.ecommerce.domain.entity.Order;
import kh.mptc.kakada.ecommerce.domain.port.output.OrderRepository;
import kh.mptc.kakada.ecommerce.persistence.repository.OrderJpaRepository;

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
