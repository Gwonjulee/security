package com.demo.security.controller.response;

public record ResultResponse<T> ( boolean success,
                                  String code,
                                  String message,
                                  T data
) {
    public static final String CODE_SUCCEED = "SUCCEED";
    public static final String CODE_FAIL = "FAILED";

    public static <T> ResultResponse<T> ok(T data) {
        return new ResultResponse<>(true,CODE_SUCCEED, null, data);
    }

    public static <T> ResultResponse<T> fail(String message) {
        return new ResultResponse<>(false,CODE_FAIL, message, null);
    }
}
