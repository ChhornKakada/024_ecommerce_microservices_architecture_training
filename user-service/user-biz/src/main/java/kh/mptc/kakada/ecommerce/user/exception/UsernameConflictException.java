package kh.mptc.kakada.ecommerce.user.exception;

import kh.mptc.kakada.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UsernameConflictException extends GlobalException {
    public UsernameConflictException(HttpStatus status, String message) {
        super(status, message);
    }
}
