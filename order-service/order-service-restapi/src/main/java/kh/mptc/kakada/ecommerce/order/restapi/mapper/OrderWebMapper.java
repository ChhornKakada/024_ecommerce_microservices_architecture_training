package kh.mptc.kakada.ecommerce.order.restapi.mapper;

import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderCommand;
import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderResult;
import kh.mptc.kakada.ecommerce.order.restapi.dto.OrderCreateRequest;
import kh.mptc.kakada.ecommerce.order.restapi.dto.OrderCreateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {

    // source: parameter
    // target: return type

    CreateOrderCommand orderCreateRequestToCreateOrderCommand(
            OrderCreateRequest orderCreateRequest
    );

    OrderCreateResponse createOrderResultToOrderCreateResponse(
            CreateOrderResult createOrderResult
    );
}
