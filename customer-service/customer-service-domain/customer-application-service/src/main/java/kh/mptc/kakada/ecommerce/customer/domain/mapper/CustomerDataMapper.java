package kh.mptc.kakada.ecommerce.customer.domain.mapper;

import kh.mptc.kakada.ecommerce.customer.domain.dto.CreateCustomerCommand;
import kh.mptc.kakada.ecommerce.domain.valueobject.Email;
import kh.mptc.kakada.ecommerce.domain.valueobject.PhoneNumber;
import kh.mptc.kakada.ecommerce.customer.domain.entity.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerDataMapper {

    // id and status are not set here: the domain sets them in initiateCustomer()
    public Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand) {
        return Customer.builder()
                .username(createCustomerCommand.username())
                .familyName(createCustomerCommand.familyName())
                .givenName(createCustomerCommand.givenName())
                .email(new Email(createCustomerCommand.email()))
                .phoneNumber(toPhoneNumber(createCustomerCommand.phoneNumber()))
                .build();
    }

    public PhoneNumber toPhoneNumber(String phoneNumber) {
        return phoneNumber == null ? null : new PhoneNumber(phoneNumber);
    }

}
