package kh.mptc.kakada.ecommerce.business.domain.service;

import kh.mptc.kakada.ecommerce.business.domain.entity.Business;
import kh.mptc.kakada.ecommerce.business.domain.event.OrderApprovalEvent;
import kh.mptc.kakada.ecommerce.business.domain.event.OrderApprovedEvent;
import kh.mptc.kakada.ecommerce.business.domain.event.OrderRejectedEvent;
import kh.mptc.kakada.ecommerce.domain.valueobject.OrderApprovalStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class BusinessDomainServiceImpl implements BusinessDomainService {

    @Override
    public OrderApprovalEvent validateOrder(Business business, List<String> failureMessages) {
        business.validateOrder(failureMessages);

        if (failureMessages.isEmpty()) {
            business.constructOrderApproval(OrderApprovalStatus.APPROVED);
            return new OrderApprovedEvent(business.getOrderApproval(), business.getId(),
                    failureMessages, ZonedDateTime.now(ZoneId.of("UTC")));
        }

        business.constructOrderApproval(OrderApprovalStatus.REJECTED);
        return new OrderRejectedEvent(business.getOrderApproval(), business.getId(),
                failureMessages, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}

