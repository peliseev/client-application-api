package ru.tinkoff.contactapplicationapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("code")
    private int code;

    @JsonProperty("description")
    private String description;

    public Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
