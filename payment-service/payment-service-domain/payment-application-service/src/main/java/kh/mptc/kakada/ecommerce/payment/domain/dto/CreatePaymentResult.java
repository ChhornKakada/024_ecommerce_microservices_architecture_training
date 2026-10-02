package kh.mptc.kakada.ecommerce.payment.domain.dto;

import kh.mptc.kakada.ecommerce.domain.valueobject.PaymentStatus;

import java.util.UUID;

public record CreatePaymentResult(
    UUID paymentId,
    PaymentStatus paymentStatus
) {
}
