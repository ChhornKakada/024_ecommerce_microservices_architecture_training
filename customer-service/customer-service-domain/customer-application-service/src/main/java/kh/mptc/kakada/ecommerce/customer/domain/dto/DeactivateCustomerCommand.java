package kh.mptc.kakada.ecommerce.customer.domain.dto;

import java.util.UUID;

public record DeactivateCustomerCommand(
        UUID customerId
) {
}
