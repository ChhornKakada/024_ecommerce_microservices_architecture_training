package kh.mptc.kakada.ecommerce.domain.entity;

import kh.mptc.kakada.ecommerce.domain.valueobject.Money;
import kh.mptc.kakada.ecommerce.domain.valueobject.OrderId;
import kh.mptc.kakada.ecommerce.domain.valueobject.OrderItemId;
import kh.mptc.kakada.ecommerce.domain.valueobject.ProductId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;

    private final Product product;
    private final Integer quantity;
    private final Money price;
    private final Money subTotal;

    boolean isPriceValid() {
        return price.isGreaterThanZero() &&
                price.equals(product.getPrice()) &&
                price.multiply(quantity).equals(subTotal);
    }

    public void initializeOrderItem(OrderId orderId, OrderItemId order) {

    }

    public OrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public Money getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    private OrderItem(Builder builder) {
        super.setId(builder.id);
        orderId = builder.orderId;
        product = builder.product;
        quantity = builder.quantity;
        price = builder.price;
        subTotal = builder.subTotal;
    }



    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private OrderItemId id;
        private OrderId orderId;
        private Product product;
        private Integer quantity;
        private Money price;
        private Money subTotal;

        private Builder() {
        }

        public Builder id(OrderItemId val) {
            id = val;
            return this;
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder product(Product val) {
            product = val;
            return this;
        }

        public Builder quantity(Integer val) {
            quantity = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder subTotal(Money val) {
            subTotal = val;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
