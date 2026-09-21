package kh.mptc.kakada.ecommerce.order.persistence.mapper;

import kh.mptc.kakada.ecommerce.order.domain.entity.Customer;
import kh.mptc.kakada.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    @Mapping(source = "id", target = "id.value")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);

}
