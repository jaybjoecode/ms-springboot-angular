package com.example.apiserver.core;

import org.springframework.lang.Nullable;

public class CustomResponse<T> {
    private final Boolean success;
    private final String message;
    private T data;

    public CustomResponse() {
        this.success = true;
        this.message = "success";
    }

    public CustomResponse(T data) {
        this.success = true;
        this.message = "success";
        this.data = data;
    }

    public CustomResponse(String message, T data) {
        this.success = true;
        this.message = message;
        this.data = data;
    }

    public CustomResponse(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static CustomResponse<?> ok() {
        return new CustomResponse<>();
    }

    public static <T> CustomResponse<T> ok(T obj) {
        return new CustomResponse<T>(obj);
    }

    public static <T> CustomResponse<T> ok(String msg, T obj) {
        return new CustomResponse<T>(msg, obj);
    }

    public static <T> CustomResponse<T> ok(Boolean success, String msg, T obj) {
        return new CustomResponse<T>(success, msg, obj);
    }

    public static <String> CustomResponse<String> error(String msg) {
        return new CustomResponse<>(msg);
    }
}
