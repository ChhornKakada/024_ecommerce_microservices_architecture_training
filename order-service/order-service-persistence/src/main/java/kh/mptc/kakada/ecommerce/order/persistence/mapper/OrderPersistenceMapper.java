package kh.mptc.kakada.ecommerce.order.persistence.mapper;

import kh.mptc.kakada.ecommerce.order.domain.entity.Order;
import kh.mptc.kakada.ecommerce.order.domain.entity.OrderItem;
import kh.mptc.kakada.ecommerce.order.persistence.entity.OrderEntity;
import kh.mptc.kakada.ecommerce.order.persistence.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "customerId.value", target = "customerId")
    @Mapping(source = "businessId.value", target = "businessId")
    @Mapping(source = "price.amount", target = "price")
    @Mapping(source = "trackingId.value", target = "trackingId")
    @Mapping(source = "failureMessages", target = "failureMessages", qualifiedByName = "mapFailureMessages")
    OrderEntity orderToOrderEntity(Order order);

    // return target type
    @Named("mapFailureMessages")
    default String mapFailureMessages(List<String> failureMessages) {
        return String.join(",", failureMessages);
    }

    @Mapping(source = "id.value", target = "id")
    @Mapping(source = "product.id.value", target = "productId")
    @Mapping(source = "price.amount", target = "price")
    @Mapping(source = "subTotal.amount", target = "subTotal")
    OrderItemEntity orderItemToOrderItemEntity(OrderItem orderItem);

    // OrderItemEntity to OrderItem

    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "customerId.value", source = "customerId")
    @Mapping(target = "businessId.value", source = "businessId")
    @Mapping(target = "price.amount", source = "price")
    @Mapping(target = "trackingId.value", source = "trackingId")
    @Mapping(target = "failureMessages", source = "failureMessages", qualifiedByName = "mapFailureMessagesToList")
    Order orderEntityToOrder(OrderEntity orderEntity);

    @Named("mapFailureMessagesToList")
    default List<String> mapFailureMessagesToList(String failureMessages) {
        return Arrays.stream(failureMessages.split(",")).toList();
    }

    // mapstruct defect types from source and target
    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "product.id.value", source = "productId")
    @Mapping(target = "price.amount", source = "price")
    @Mapping(target = "subTotal.amount", source = "subTotal")
    OrderItem orderItemEntityToOrderItem(OrderItemEntity orderItemEntity);




}
