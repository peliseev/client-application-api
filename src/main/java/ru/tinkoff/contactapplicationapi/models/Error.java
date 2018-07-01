package ru.tinkoff.contactapplicationapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {
    @JsonProperty("code")
    private int code;

    @JsonProperty("descriotion")
    private String descriotion;

    public Error(int code, String descriotion) {
        this.code = code;
        this.descriotion = descriotion;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String description) {
        this.descriotion = description;
    }
}
