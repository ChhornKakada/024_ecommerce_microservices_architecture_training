package kh.mptc.kakada.ecommerce.customer.domain.exception;

import kh.mptc.kakada.ecommerce.customer.domain.exception.CustomerDomainException;

public class CustomerNotFoundException extends CustomerDomainException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
