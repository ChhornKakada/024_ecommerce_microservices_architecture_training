package kh.mptc.kakada.ecommerce.customer.domain.event;

import kh.mptc.kakada.ecommerce.domain.event.DomainEvent;
import kh.mptc.kakada.ecommerce.customer.domain.entity.Customer;

public abstract class CustomerEvent implements DomainEvent<Customer> {
    private final Customer customer;

    public CustomerEvent(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
