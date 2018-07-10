package ru.tinkoff.contactapplicationapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponse extends Response {

    @JsonProperty("result")
    private ContactApplication result;

    @JsonCreator
    public SuccessResponse(
            @JsonProperty("success") boolean success) {
        super(success);
    }

    public SuccessResponse(boolean success, ContactApplication result) {
        super(success);
        this.result = result;
    }

    public ContactApplication getResult() {
        return result;
    }

    public void setResult(ContactApplication result) {
        this.result = result;
    }
}
