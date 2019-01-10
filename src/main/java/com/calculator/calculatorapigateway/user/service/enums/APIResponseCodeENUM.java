package com.calculator.calculatorapigateway.user.service.enums;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public enum APIResponseCodeENUM {
    SUCCESS("200","SUCCESS"),
    NUMBER_MISSING("400","NUMBER IS MISSING"),
    WRONG_FORMAT("401","NUMBER IN WRONG FORMAT"),
    FAULTY_OPERATION_REQUEST("402","OPERATION REQUEST IN WRONG FORMAT"),
    WRONG_OPERATION("403","WRONG OPERATION SUPPLIED"),
    INSUFFICIENT_CREDITS("404","INSUFFICIENT CREDITS, PLEASE TOP UP"),
    GENERAL_FAILURE("500","SOME EXCEPTION");

    private final String code;
    private final String message;

    APIResponseCodeENUM(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "APIResponseCodeENUM{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
