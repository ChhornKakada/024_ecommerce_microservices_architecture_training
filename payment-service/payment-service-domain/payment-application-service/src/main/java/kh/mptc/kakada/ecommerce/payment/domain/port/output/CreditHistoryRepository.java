package kh.mptc.kakada.ecommerce.payment.domain.port.output;

import kh.mptc.kakada.ecommerce.payment.domain.entity.CreditHistory;

public interface CreditHistoryRepository {
    CreditHistory save(CreditHistory creditHistory);
}
