package kh.mptc.kakada.ecommerce.business.domain.service;

import kh.mptc.kakada.ecommerce.business.domain.entity.Business;
import kh.mptc.kakada.ecommerce.business.domain.event.OrderApprovalEvent;

import java.util.List;

public interface BusinessDomainService {
    OrderApprovalEvent validateOrder(Business business, List<String> failureMessages);
}

