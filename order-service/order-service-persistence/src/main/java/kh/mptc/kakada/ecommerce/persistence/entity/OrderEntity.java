package kh.mptc.kakada.ecommerce.persistence.entity;

import jakarta.persistence.*;
import kh.mptc.kakada.ecommerce.domain.valueobject.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity // ORM - create table
@Table(name = "orders")
public class OrderEntity {
    @Id
    // this one will generate from PostgreSQL uuid algorithm
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID customerId;
    private UUID businessId;
    private BigDecimal price;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;

    @OneToOne
    private  StreetAddressEntity streetAddress;

    private UUID trackingId;
    private OrderStatus orderStatus;

    // message1;message2
    private String failureMessages;
}
