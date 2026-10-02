package kh.mptc.kakada.ecommerce.business.domain.port.output;

import kh.mptc.kakada.ecommerce.business.domain.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);

}

