package kh.mptc.kakada.ecommerce.user.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UserCreateRequest(
        @NotBlank
        String username,
        @NotBlank
        String email,
        @NotBlank
        String familyName,
        @NotBlank
        String givenName,
        @NotBlank
        String password,
        @NotBlank
        String confirmedPassword,
        @NotBlank
        String roleName,

        Date birthday// use, as delimiter
) {
}
