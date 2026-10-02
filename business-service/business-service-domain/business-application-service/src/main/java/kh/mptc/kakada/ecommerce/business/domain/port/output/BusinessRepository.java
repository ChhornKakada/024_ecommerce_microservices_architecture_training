package kh.mptc.kakada.ecommerce.business.domain.port.output;

import kh.mptc.kakada.ecommerce.business.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusinessInformation(Business business);

}

