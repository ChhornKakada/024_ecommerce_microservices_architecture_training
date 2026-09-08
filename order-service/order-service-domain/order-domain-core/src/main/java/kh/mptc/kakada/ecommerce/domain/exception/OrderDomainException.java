package kh.mptc.kakada.ecommerce.domain.exception;

public class OrderDomainException extends DomainException{
    public OrderDomainException(String message) {
        super(message);
    }

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
