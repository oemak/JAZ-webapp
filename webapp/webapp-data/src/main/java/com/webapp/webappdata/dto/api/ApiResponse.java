package com.webapp.webappdata.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private int code;
    private boolean error;
    private T data;
    private String message;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(200);
        response.setError(false);
        response.setData(data);
        return response;
    }

    public static <T> ApiResponse<T> error(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(400);
        response.setError(true);
        response.setMessage(message);
        return response;
    }
}