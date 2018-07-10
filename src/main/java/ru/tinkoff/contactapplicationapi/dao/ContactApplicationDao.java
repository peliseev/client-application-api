package ru.tinkoff.contactapplicationapi.dao;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import ru.tinkoff.contactapplicationapi.entity.Applications;
import ru.tinkoff.contactapplicationapi.entity.Contact;

@Component
public class ContactApplicationDao {

    public Pair<Contact, Applications> getContactApplication(Long contactId) {
        String sqlQuery = "SELECT CONTACT.CONTACT_ID, APPLICATION_ID, DT_CREATED, PRODUCT_NAME " +
                "";
        return null;
    }
}
