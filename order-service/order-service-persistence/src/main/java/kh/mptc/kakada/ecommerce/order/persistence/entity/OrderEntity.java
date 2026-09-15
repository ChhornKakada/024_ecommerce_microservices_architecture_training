package kh.mptc.kakada.ecommerce.order.persistence.entity;

import jakarta.persistence.*;
import kh.mptc.kakada.ecommerce.domain.valueobject.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

// JPA Entity must be POJO (Plain Old Java Object) class
@Entity // ORM - create table
@Getter
@Setter
@NoArgsConstructor
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
    private OrderAddressEntity orderAddress;

    private UUID trackingId;
    private OrderStatus orderStatus;

    // message1;message2
    private String failureMessages;
}
