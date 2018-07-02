package ru.tinkoff.contactapplicationapi.services;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.contactapplicationapi.dao.ApplicationsDao;
import ru.tinkoff.contactapplicationapi.dao.ContactDao;
import ru.tinkoff.contactapplicationapi.entity.Applications;
import ru.tinkoff.contactapplicationapi.entity.Contact;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class ContactApplicationServiceTest {

    @Autowired
    private ContactApplicationService contactApplicationService;

    @MockBean
    private ContactDao contactDao;

    @MockBean
    private ApplicationsDao applicationsDao;

    @Before
    public void setUp() {
        Contact contact1 = new Contact();
        Mockito.when(contactDao.findById(contact1.getId())).thenReturn(Optional.of(contact1));

        Applications app1 = new Applications();
        Applications app2 = new Applications();

    }


}