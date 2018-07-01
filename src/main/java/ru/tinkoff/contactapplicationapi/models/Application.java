package ru.tinkoff.contactapplicationapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application {
    @JsonProperty("applicationId")
    private long applicationId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("created")
    private String created;

    public Application(long applicationId, String productName, String created) {
        this.applicationId = applicationId;
        this.productName = productName;
        this.created = created;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
