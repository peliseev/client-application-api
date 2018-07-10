package ru.tinkoff.contactapplicationapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse extends Response {

    @JsonProperty("error")
    private Error error;

    @JsonCreator
    public ErrorResponse(
            @JsonProperty("success") boolean success) {
        super(success);
    }

    public ErrorResponse(boolean success, Error error) {
        super(success);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

}
