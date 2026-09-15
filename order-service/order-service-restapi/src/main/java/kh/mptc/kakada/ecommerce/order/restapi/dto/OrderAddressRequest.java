package kh.mptc.kakada.ecommerce.order.restapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderAddressRequest(

        @NotNull
        @Size(max = 20)
        String street,

        @NotNull
        @Size(max = 10)
        String postalCode,

        @NotNull
        @Size(max = 20)
        String city
) {
}
