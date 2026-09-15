package kh.mptc.kakada.ecommerce.restapi.dto;

public record FieldErrorResponse(
        String field,
        String code,
        String reason
) {
}
