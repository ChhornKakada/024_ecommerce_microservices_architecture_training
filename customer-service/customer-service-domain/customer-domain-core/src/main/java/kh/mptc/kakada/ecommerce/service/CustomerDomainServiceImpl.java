package kh.mptc.kakada.ecommerce.customer.domain.service;

import kh.mptc.kakada.ecommerce.domain.valueobject.Email;
import kh.mptc.kakada.ecommerce.domain.valueobject.PhoneNumber;
import kh.mptc.kakada.ecommerce.customer.domain.entity.Customer;
import kh.mptc.kakada.ecommerce.customer.domain.event.CustomerCreatedEvent;
import kh.mptc.kakada.ecommerce.customer.domain.event.CustomerDeactivatedEvent;
import kh.mptc.kakada.ecommerce.customer.domain.event.CustomerUpdatedEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomerDomainServiceImpl implements CustomerDomainService{

    @Override
    public CustomerCreatedEvent validateAndInitiateCustomer(Customer customer) {
        customer.validateCustomer();
        customer.initiateCustomer();
        return new CustomerCreatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public CustomerUpdatedEvent updateCustomer(Customer customer, String familyName, String givenName,
                                               Email email, PhoneNumber phoneNumber) {
        customer.updateCustomer(familyName, givenName, email, phoneNumber);
        return new CustomerUpdatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public CustomerDeactivatedEvent deactivateCustomer(Customer customer) {
        customer.deactivateCustomer();
        return new CustomerDeactivatedEvent(customer.getId(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

}
