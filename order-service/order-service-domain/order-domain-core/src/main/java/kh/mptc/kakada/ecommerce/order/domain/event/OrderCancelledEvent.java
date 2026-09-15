package kh.mptc.kakada.ecommerce.order.domain.event;

import kh.mptc.kakada.ecommerce.order.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent {
    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
