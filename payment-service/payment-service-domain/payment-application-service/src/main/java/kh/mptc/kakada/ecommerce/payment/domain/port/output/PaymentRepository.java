package kh.mptc.kakada.ecommerce.payment.domain.port.output;

import kh.mptc.kakada.ecommerce.payment.domain.entity.Payment;

public interface PaymentRepository {
  Payment savePayment(Payment payment);
}
