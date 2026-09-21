package kh.mptc.kakada.ecommerce.order.restapi.controller;

import jakarta.validation.Valid;
import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderCommand;
import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderResult;
import kh.mptc.kakada.ecommerce.order.domain.usecase.CreateOrderUseCase;
import kh.mptc.kakada.ecommerce.order.restapi.dto.OrderCreateRequest;
import kh.mptc.kakada.ecommerce.order.restapi.dto.OrderCreateResponse;
import kh.mptc.kakada.ecommerce.order.restapi.mapper.OrderWebMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    // Declare dependency before calling it to use
    // final: mean required
    // use lombok to write constructor
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(
            @Valid @RequestBody OrderCreateRequest createOrderRequest
    ) {
        // call mapping logic
        CreateOrderCommand createOrderCommand = orderWebMapper
                .orderCreateRequestToCreateOrderCommand(createOrderRequest);
        // call UseCase logic
        CreateOrderResult createOrderResult = createOrderUseCase.execute(createOrderCommand);
        return orderWebMapper
                .createOrderResultToOrderCreateResponse(createOrderResult);
    }
}
