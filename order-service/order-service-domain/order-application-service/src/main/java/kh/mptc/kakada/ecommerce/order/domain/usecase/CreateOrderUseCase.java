package kh.mptc.kakada.ecommerce.order.domain.usecase;

import kh.mptc.kakada.ecommerce.domain.valueobject.BusinessId;
import kh.mptc.kakada.ecommerce.domain.valueobject.Money;
import kh.mptc.kakada.ecommerce.domain.valueobject.ProductId;
import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderCommand;
import kh.mptc.kakada.ecommerce.order.domain.dto.CreateOrderResult;
import kh.mptc.kakada.ecommerce.order.domain.entity.Business;
import kh.mptc.kakada.ecommerce.order.domain.entity.Product;
import kh.mptc.kakada.ecommerce.order.domain.exception.OrderDomainException;
import kh.mptc.kakada.ecommerce.order.domain.port.output.BusinessRepository;
import kh.mptc.kakada.ecommerce.order.domain.port.output.CustomerRepository;
import kh.mptc.kakada.ecommerce.order.domain.port.output.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
// bean: means object in spring
@Slf4j // logs
// create logs object when compile
@RequiredArgsConstructor
public class CreateOrderUseCase {

    // bean: means Injection
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase {}", createOrderCommand);

        // validate customer
        customerRepository.findCustomer(createOrderCommand.customerId())
                .orElseThrow(() -> new OrderDomainException("Customer not found."));

        // validate business
        List<Product> products = createOrderCommand.items().stream()
                .map(commandOrderItem -> Product.builder()
                        .id(new ProductId(commandOrderItem.productId()))
                        .price(new Money(commandOrderItem.price()))
                        .build())
                .toList();

        Business tmpBusiness = Business.builder()
                .id(new BusinessId(createOrderCommand.businessId()))
                .products(products)
                .build();
        Business business = businessRepository.findBusiness(tmpBusiness)
                .orElseThrow(() -> new OrderDomainException("Business not found."));

        log.info("Business Found: {}", business);

        return new CreateOrderResult(UUID.randomUUID());
    }

}

// Insert, Update, Delete -> Command -> Transaction
// Select -> read -> Query -> Transaction Read Only
// Pattern: CQRS = Command Query Responsibility Segregation

// we can separate the service into 2: one for transaction and other for Read Only.
// These help us to define the appropriate technology to have efficient need.