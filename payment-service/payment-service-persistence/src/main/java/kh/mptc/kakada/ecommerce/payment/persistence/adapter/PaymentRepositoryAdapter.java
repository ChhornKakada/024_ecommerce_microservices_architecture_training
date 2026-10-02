package kh.mptc.kakada.ecommerce.payment.persistence.adapter;

import kh.mptc.kakada.ecommerce.payment.domain.entity.Payment;
import kh.mptc.kakada.ecommerce.payment.domain.port.output.PaymentRepository;
import kh.mptc.kakada.ecommerce.payment.persistence.entity.PaymentEntity;
import kh.mptc.kakada.ecommerce.payment.persistence.mapper.PaymentPersistenceMapper;
import kh.mptc.kakada.ecommerce.payment.persistence.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {
  private final PaymentJpaRepository paymentJpaRepository;
  private final PaymentPersistenceMapper paymentPersistenceMapper;

  @Override
  public Payment savePayment(Payment payment) {
    PaymentEntity paymentEntity = paymentPersistenceMapper.paymentToPaymentEntity(payment);
    PaymentEntity savedPaymentEntity = paymentJpaRepository.save(paymentEntity);
    return paymentPersistenceMapper.paymentEntityToPayment(savedPaymentEntity);
  }
}
