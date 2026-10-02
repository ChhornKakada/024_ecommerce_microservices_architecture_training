package kh.mptc.kakada.ecommerce.business.domain.event;

import kh.mptc.kakada.ecommerce.business.domain.entity.OrderApproval;
import kh.mptc.kakada.ecommerce.domain.valueobject.BusinessId;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderRejectedEvent extends OrderApprovalEvent {
    public OrderRejectedEvent(OrderApproval orderApproval, BusinessId businessId, List<String> failureMessages, ZonedDateTime createdAt) {
        super(orderApproval, businessId, failureMessages, createdAt);
    }
}

