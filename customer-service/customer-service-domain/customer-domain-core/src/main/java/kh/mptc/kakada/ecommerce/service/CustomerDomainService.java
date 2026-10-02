package kh.mptc.kakada.ecommerce.customer.domain.service;

import kh.mptc.kakada.ecommerce.domain.valueobject.Email;
import kh.mptc.kakada.ecommerce.domain.valueobject.PhoneNumber;
import kh.mptc.kakada.ecommerce.customer.domain.entity.Customer;
import kh.mptc.kakada.ecommerce.customer.domain.event.CustomerCreatedEvent;
import kh.mptc.kakada.ecommerce.customer.domain.event.CustomerDeactivatedEvent;
import kh.mptc.kakada.ecommerce.customer.domain.event.CustomerUpdatedEvent;


public interface CustomerDomainService {
    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

    CustomerUpdatedEvent updateCustomer(Customer customer, String familyName, String givenName,
                                        Email email, PhoneNumber phoneNumber);

    CustomerDeactivatedEvent deactivateCustomer(Customer customer);
}
