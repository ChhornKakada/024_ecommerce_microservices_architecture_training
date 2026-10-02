package kh.mptc.kakada.ecommerce.payment.persistence.adapter;

import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.payment.domain.entity.CreditEntry;
import kh.mptc.kakada.ecommerce.payment.domain.port.output.CreditEntityRepository;
import kh.mptc.kakada.ecommerce.payment.persistence.entity.CreditEntryEntity;
import kh.mptc.kakada.ecommerce.payment.persistence.mapper.CreditEntryPersistenceMapper;
import kh.mptc.kakada.ecommerce.payment.persistence.repository.CreditEntryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreditEntryRepositoryAdapter implements CreditEntityRepository {
  private final CreditEntryJpaRepository creditEntryJpaRepository;
  private final CreditEntryPersistenceMapper creditEntryPersistenceMapper;

  @Override
  public CreditEntry findByCustomerId(CustomerId customerId) {
    return creditEntryJpaRepository.findByCustomerId(customerId.value())
        .map(creditEntryPersistenceMapper::creditEntryEntityToCreditEntry)
        .orElse(null);
  }

  @Override
  public CreditEntry save(CreditEntry creditEntry) {
    CreditEntryEntity creditEntryEntity = creditEntryPersistenceMapper.creditEntryToCreditEntryEntity(creditEntry);
    CreditEntryEntity savedCreditEntryEntity = creditEntryJpaRepository.save(creditEntryEntity);
    return creditEntryPersistenceMapper.creditEntryEntityToCreditEntry(savedCreditEntryEntity);
  }
}
