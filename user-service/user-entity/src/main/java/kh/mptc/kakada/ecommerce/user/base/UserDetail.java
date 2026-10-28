package kh.mptc.kakada.ecommerce.user.base;

import lombok.Builder;

import java.util.Date;

@Builder
public record UserDetail(
    String id,
    String familyName,
    String givenName,
    String username,
    String email,
    String gender,
    String mobilePhone,
    String address,
    Date birthday
) {
}
