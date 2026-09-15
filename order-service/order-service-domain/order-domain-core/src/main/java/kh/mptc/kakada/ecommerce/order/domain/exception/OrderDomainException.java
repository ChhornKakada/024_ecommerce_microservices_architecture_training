package kh.mptc.kakada.ecommerce.order.domain.exception;

import kh.mptc.kakada.ecommerce.domain.exception.DomainException;

public class OrderDomainException extends DomainException {
    public OrderDomainException(String message) {
        super(message);
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
