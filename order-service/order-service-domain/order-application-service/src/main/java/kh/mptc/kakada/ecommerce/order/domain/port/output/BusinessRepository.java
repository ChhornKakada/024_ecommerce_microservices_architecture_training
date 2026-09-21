package kh.mptc.kakada.ecommerce.order.domain.port.output;

import kh.mptc.kakada.ecommerce.order.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusiness(Business business);
}
