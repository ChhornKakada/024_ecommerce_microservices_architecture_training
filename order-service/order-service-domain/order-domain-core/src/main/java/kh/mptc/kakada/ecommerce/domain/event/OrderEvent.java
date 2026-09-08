package kh.mptc.kakada.ecommerce.domain.event;

import kh.mptc.kakada.ecommerce.domain.entity.Order;

import java.time.ZonedDateTime;

public abstract class OrderEvent implements DomainEvent<Order>{
    private Order order;

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public Order getOrder() {
        return order;
    }

    private ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }
}
