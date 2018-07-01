package ru.tinkoff.contactapplicationapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponse extends Response {

    @JsonProperty("result")
    private ContactApplication result;

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
