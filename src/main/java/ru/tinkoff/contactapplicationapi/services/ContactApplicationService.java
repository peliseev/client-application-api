package ru.tinkoff.contactapplicationapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.contactapplicationapi.dao.ApplicationsDao;
import ru.tinkoff.contactapplicationapi.dao.ContactDao;
import ru.tinkoff.contactapplicationapi.entity.Applications;
import ru.tinkoff.contactapplicationapi.entity.Contact;
import ru.tinkoff.contactapplicationapi.exceptions.ApplicationsNotFoundException;
import ru.tinkoff.contactapplicationapi.exceptions.ContactNotFoundException;
import ru.tinkoff.contactapplicationapi.models.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ContactApplicationService {

    private ApplicationsDao applicationsDao;
    private ContactDao contactDao;

    @Autowired
    ContactApplicationService(ApplicationsDao applicationsDao, ContactDao contactDao) {
        this.applicationsDao = applicationsDao;
        this.contactDao = contactDao;
    }

    public Response process(long contactId) {
        Optional<Contact> optionalContacts = contactDao.findById(contactId);

        if (!optionalContacts.isPresent()) {
            throw new ContactNotFoundException();
        }

        Optional<List<Applications>> optionalApplications = applicationsDao.findByContact_Id(contactId);
        if (!optionalApplications.isPresent()) {
            throw new ApplicationsNotFoundException();
        }

        List<Applications> applications = optionalApplications.get();

        Optional<Applications> optionalApplication = applications.stream().max(Comparator.comparing(Applications::getDtCreated));

        if (!optionalApplication.isPresent()) {
            throw new ApplicationsNotFoundException();
        }

        Applications application = optionalApplication.get();

        return new SuccessResponse(true,
                new ContactApplication(contactId,
                        new Application(application.getId(), application.getProductName(), application.getDtCreated().toString())));
    }
}
