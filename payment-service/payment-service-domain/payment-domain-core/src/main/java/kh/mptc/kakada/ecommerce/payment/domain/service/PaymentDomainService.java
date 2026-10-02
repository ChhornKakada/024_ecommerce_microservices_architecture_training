package kh.mptc.kakada.ecommerce.payment.domain.service;

import kh.mptc.kakada.ecommerce.domain.valueobject.PaymentStatus;
import kh.mptc.kakada.ecommerce.payment.domain.entity.CreditEntry;
import kh.mptc.kakada.ecommerce.payment.domain.entity.CreditHistory;
import kh.mptc.kakada.ecommerce.payment.domain.entity.Payment;

public interface PaymentDomainService {
  CreditHistory validateAndInitiatePayment(Payment payment, CreditEntry creditEntry);

  void updatePaymentStatus(Payment payment, PaymentStatus newPaymentStatus);
}
