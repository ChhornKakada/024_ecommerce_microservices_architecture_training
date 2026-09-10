package kh.mptc.kakada.ecommerce.domain.port.output;

import kh.mptc.kakada.ecommerce.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}
