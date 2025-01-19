package com.oguzhan.exception;

public class BaseException extends RuntimeException{

    public BaseException() {

    }
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
