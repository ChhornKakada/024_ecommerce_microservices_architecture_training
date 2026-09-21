package kh.mptc.kakada.ecommerce.order.domain.dto;

import kh.mptc.kakada.ecommerce.domain.valueobject.BusinessId;
import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.domain.valueobject.Money;
import kh.mptc.kakada.ecommerce.domain.valueobject.StreetAddress;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateOrderCommand(
        UUID customerId,
        UUID businessId,
        BigDecimal price,
        CommandOrderAddress deliveryAddress,
        List<CommandOrderItem> items
) {
}
