package kh.mptc.kakada.ecommerce.order.domain.port.output;

import kh.mptc.kakada.ecommerce.order.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}
