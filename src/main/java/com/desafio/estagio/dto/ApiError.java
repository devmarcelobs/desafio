package com.desafio.estagio.dto;

import java.time.LocalDateTime;

public class ApiError {
    private String path;
    private String message;
    private int statusCode;
    private LocalDateTime localDateTime;

    public ApiError() {
    }

    public ApiError(String path, String message, int statusCode, LocalDateTime localDateTime) {
        this.path = path;
        this.message = message;
        this.statusCode = statusCode;
        this.localDateTime = localDateTime;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
