package com.calculator.calculatorapigateway.user.service.model;


import com.calculator.calculatorapigateway.user.service.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class APIResponse {
    private Boolean success;
    private String code;
    private String message;
    private Object data;

    public APIResponse() {
    }

    public APIResponse(Boolean success, String code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static APIResponse buildSuccess(Object data) {
        return new APIResponse(true,"200","SUCCESS",data);
    }

    public static APIResponse buildFailure(String code, String message) {
        return new APIResponse(false,code,message,null);
    }

    public static APIResponse buildFailure(APIResponseCodeENUM responseCodeENUM) {
        return new APIResponse(false,responseCodeENUM.getCode(),responseCodeENUM.getMessage(),null);
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
