package kh.mptc.kakada.ecommerce.payment.domain.entity;

import kh.mptc.kakada.ecommerce.domain.entity.BaseEntity;
import kh.mptc.kakada.ecommerce.domain.valueobject.CreditHistoryId;
import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.domain.valueobject.Money;
import kh.mptc.kakada.ecommerce.domain.valueobject.TransactionType;

public class CreditHistory extends BaseEntity<CreditHistoryId> {

    private final CustomerId customerId;
    private final Money amount;
    private final TransactionType transactionType;

    private CreditHistory(Builder builder) {
        super.setId(builder.id);
        customerId = builder.customerId;
        amount = builder.amount;
        transactionType = builder.transactionType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Money getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public static final class Builder {
        private CreditHistoryId id;
        private CustomerId customerId;
        private Money amount;
        private TransactionType transactionType;

        private Builder() {
        }


        public Builder id(CreditHistoryId val) {
            id = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder amount(Money val) {
            amount = val;
            return this;
        }

        public Builder transactionType(TransactionType val) {
            transactionType = val;
            return this;
        }

        public CreditHistory build() {
            return new CreditHistory(this);
        }
    }
}
