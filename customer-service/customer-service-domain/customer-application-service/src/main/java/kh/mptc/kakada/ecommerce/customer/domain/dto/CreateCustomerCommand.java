package kh.mptc.kakada.ecommerce.customer.domain.dto;

public record CreateCustomerCommand(
        String userId,
        String username,
        String familyName,
        String givenName,
        String email,
        String phoneNumber
) {
}
