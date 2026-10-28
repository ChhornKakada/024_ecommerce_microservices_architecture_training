package kh.mptc.kakada.ecommerce.user.exception;

import kh.mptc.kakada.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class PasswordMismatchException extends GlobalException {
    public PasswordMismatchException(HttpStatus status, String message) {
        super(status, message);
    }
}
