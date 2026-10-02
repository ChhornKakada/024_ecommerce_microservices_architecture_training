package kh.mptc.kakada.ecommerce.customer.restapi.mapper;

import kh.mptc.kakada.ecommerce.customer.domain.dto.CreateCustomerCommand;
import kh.mptc.kakada.ecommerce.customer.domain.dto.CreateCustomerResult;
import kh.mptc.kakada.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import kh.mptc.kakada.ecommerce.customer.domain.dto.UpdateCustomerResult;
import kh.mptc.kakada.ecommerce.customer.restapi.dto.CustomerCreateRequest;
import kh.mptc.kakada.ecommerce.customer.restapi.dto.CustomerCreateResponse;
import kh.mptc.kakada.ecommerce.customer.restapi.dto.CustomerUpdateRequest;
import kh.mptc.kakada.ecommerce.customer.restapi.dto.CustomerUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CustomerWebMapper {
    CreateCustomerCommand customerCreateRequestToCreateCustomerCommand(CustomerCreateRequest customerCreateRequest);
    CustomerCreateResponse createCustomerResultToCustomerCreateResponse(CreateCustomerResult createCustomerResult);

    // customerId comes from the path, the rest from the request body
    @Mapping(source = "customerId", target = "customerId")
    UpdateCustomerCommand customerUpdateRequestToUpdateCustomerCommand(UUID customerId, CustomerUpdateRequest customerUpdateRequest);
    CustomerUpdateResponse updateCustomerResultToCustomerUpdateResponse(UpdateCustomerResult updateCustomerResult);
}
