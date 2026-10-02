package kh.mptc.kakada.ecommerce.payment.domain.port.output;

import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.payment.domain.entity.CreditEntry;

public interface CreditEntityRepository  {
    CreditEntry findByCustomerId(CustomerId customerId);

    CreditEntry save(CreditEntry creditEntry);
}
