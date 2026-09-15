package kh.mptc.kakada.ecommerce.order.domain.dto;

import kh.mptc.kakada.ecommerce.domain.valueobject.BusinessId;
import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.domain.valueobject.Money;
import kh.mptc.kakada.ecommerce.domain.valueobject.StreetAddress;

public record CreateOrderRequest(
        CustomerId customerId,
        BusinessId businessId,
        StreetAddress deliveryAddress,
        Money price
) {
}
