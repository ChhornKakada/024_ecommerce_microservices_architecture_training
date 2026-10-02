package kh.mptc.kakada.ecommerce.customer.domain.exception;

import kh.mptc.kakada.ecommerce.customer.domain.exception.CustomerDomainException;

public class CustomerAlreadyExistsException extends CustomerDomainException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
