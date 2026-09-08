package kh.mptc.kakada.ecommerce.domain.valueobject;

import java.util.UUID;

public record StreetAddress(
        UUID value,
        String street,
        String postalCode,
        String city
) {
}
