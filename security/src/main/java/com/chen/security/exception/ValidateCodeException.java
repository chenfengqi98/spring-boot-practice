package com.chen.security.exception;


import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 50225753931234458L;

    public ValidateCodeException(String message) {
        super(message);
    }

}
