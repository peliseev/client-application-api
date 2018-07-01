package ru.tinkoff.contactapplicationapi.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinkoff.contactapplicationapi.dao.ApplicationsDao;
import ru.tinkoff.contactapplicationapi.dao.ContactDao;
import ru.tinkoff.contactapplicationapi.entity.Applications;
import ru.tinkoff.contactapplicationapi.entity.Contact;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Date;

@Singleton
@Startup
@Component
public class InitData {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private ApplicationsDao applicationsDao;

    @PostConstruct
    public void load() {
        Applications app1 = new Applications();
        Applications app2 = new Applications();
        Applications app3 = new Applications();
        Applications app4 = new Applications();
        Applications app5 = new Applications();
        Applications app6 = new Applications();

        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        Contact contact3 = new Contact();

        contactDao.save(contact1);
        contactDao.save(contact2);
        contactDao.save(contact3);

        app1.setProductName("Кредитная карта");
        app1.setDtCreated(new Date(1530445116000L));
        app1.setContact(contact1);
        applicationsDao.save(app1);

        app2.setProductName("Дебетовая карта");
        app2.setDtCreated(new Date(1530469116000L));
        app2.setContact(contact1);
        applicationsDao.save(app2);

        app3.setProductName("Ипотека");
        app3.setDtCreated(new Date(1530459216000L));
        app3.setContact(contact1);
        applicationsDao.save(app3);

        app4.setProductName("Кредит");
        app4.setDtCreated(new Date(1530482516000L));
        applicationsDao.save(app4);

        app5.setProductName("Брокерский счет");
        app5.setDtCreated(new Date(1530928573000L));
        app5.setContact(contact2);
        applicationsDao.save(app5);

        app6.setProductName("ИИС");
        app6.setDtCreated(new Date(1530928573000L));
        app6.setContact(contact2);
        applicationsDao.save(app6);
    }
}
