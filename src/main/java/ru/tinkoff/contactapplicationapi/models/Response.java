package ru.tinkoff.contactapplicationapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("success")
    private boolean success;

    public Response(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
