package com.oguzhan.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("1001","Record cannot be found"),
    GENERAL_EXCEPTION("9999", "General Error");

    private String code;

    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
