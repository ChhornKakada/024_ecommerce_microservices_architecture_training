package kh.mptc.kakada.ecommerce.persistence.entity;

import jakarta.persistence.*;
import kh.mptc.kakada.ecommerce.domain.entity.OrderItem;
import kh.mptc.kakada.ecommerce.domain.entity.Product;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private ProductEntity product;

    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

    @ManyToOne
    private OrderEntity order;
}
