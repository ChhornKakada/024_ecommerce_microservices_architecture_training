package kh.mptc.kakada.ecommerce.order.domain.port.input;

import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderCommand;

public interface CreateOrderUseCase {
    void execute(CreateOrderCommand createOrderCommand);
}
