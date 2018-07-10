package ru.tinkoff.contactapplicationapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactApplication {
    @JsonProperty("contactId")
    private long contactId;

    @JsonProperty("application")
    private Application application;

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public ContactApplication(long contactId, Application application) {
        this.contactId = contactId;
        this.application = application;
    }

}
