package kh.mptc.kakada.ecommerce.order.domain.port.input;

import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {
    void execute(CreateOrderRequest createOrderRequest);
}
