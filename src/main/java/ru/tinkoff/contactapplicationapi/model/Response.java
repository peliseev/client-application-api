package ru.tinkoff.contactapplicationapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("success")
    private boolean success;

    Response(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

}
