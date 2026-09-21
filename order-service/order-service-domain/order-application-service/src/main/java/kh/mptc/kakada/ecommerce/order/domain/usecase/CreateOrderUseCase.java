package kh.mptc.kakada.ecommerce.order.domain.usecase;

import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderCommand;
import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
// bean: means object in spring
@Slf4j
// create logs object when compile
public class CreateOrderUseCase {

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase {}", createOrderCommand);

        // validate customer

        // validate business

        return new CreateOrderResult(UUID.randomUUID());
    }

}

// Insert, Update, Delete -> Command -> Transaction
// Select -> read -> Query -> Transaction Read Only
// Pattern: CQRS = Command Query Responsibility Segregation

// we can separate the service into 2: one for transaction and other for Read Only.
// These help us to define the appropriate technology to have efficient need.