package kh.mptc.kakada.ecommerce.customer.domain.event;

import kh.mptc.kakada.ecommerce.domain.event.DomainEvent;
import kh.mptc.kakada.ecommerce.domain.valueobject.CustomerId;
import kh.mptc.kakada.ecommerce.customer.domain.entity.Customer;

import java.time.ZonedDateTime;

public class CustomerDeactivatedEvent implements DomainEvent<Customer> {
    private final CustomerId customerId;
    private final ZonedDateTime deactivatedAt;

    public CustomerDeactivatedEvent(CustomerId customerId, ZonedDateTime deactivatedAt){
        this.customerId = customerId;
        this.deactivatedAt = deactivatedAt;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public ZonedDateTime getDeactivatedAt() {
        return deactivatedAt;
    }
}
