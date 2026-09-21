package kh.mptc.kakada.ecommerce.order.domain.dto;

// nested command object
public record CommandOrderAddress(
        String street,
        String postalCode,
        String city
) {
}
