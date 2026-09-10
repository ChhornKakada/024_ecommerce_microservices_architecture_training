package kh.mptc.kakada.ecommerce.domain.port.input;

import kh.mptc.kakada.ecommerce.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {
    void execute(CreateOrderRequest createOrderRequest);
}
