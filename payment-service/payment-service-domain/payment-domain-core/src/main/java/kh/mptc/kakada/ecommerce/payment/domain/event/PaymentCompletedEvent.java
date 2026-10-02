package kh.mptc.kakada.ecommerce.payment.domain.event;

import kh.mptc.kakada.ecommerce.payment.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.List;

public class PaymentCompletedEvent extends PaymentEvent{
    public PaymentCompletedEvent(Payment payment, ZonedDateTime createdAt, List<String> failureMessages) {
        super(payment, createdAt, failureMessages);
    }
}
