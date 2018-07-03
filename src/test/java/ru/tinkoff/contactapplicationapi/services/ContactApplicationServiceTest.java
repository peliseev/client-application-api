package ru.tinkoff.contactapplicationapi.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.contactapplicationapi.dao.ApplicationsDao;
import ru.tinkoff.contactapplicationapi.dao.ContactDao;
import ru.tinkoff.contactapplicationapi.entity.Applications;
import ru.tinkoff.contactapplicationapi.entity.Contact;
import ru.tinkoff.contactapplicationapi.exceptions.ApplicationsNotFoundException;
import ru.tinkoff.contactapplicationapi.models.Response;
import ru.tinkoff.contactapplicationapi.models.SuccessResponse;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactApplicationServiceTest {

    private ContactApplicationService service;

    @MockBean
    private ContactDao contactDao;

    @MockBean
    private ApplicationsDao applicationsDao;

    @Before
    public void setUp() {
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        Contact contact3 = new Contact();
        Mockito.when(contactDao.findById(1)).thenReturn(Optional.of(contact1));
        Mockito.when(contactDao.findById(2)).thenReturn(Optional.of(contact2));
        Mockito.when(contactDao.findById(3)).thenReturn(Optional.of(contact3));

        Applications app1 = new Applications();
        app1.setProductName("Кредитная карта");
        app1.setDtCreated(new Date(1530445116000L));
        app1.setContact(contact1);

        Applications app2 = new Applications();
        app2.setProductName("Дебетовая карта");
        app2.setDtCreated(new Date(1530469116000L));
        app2.setContact(contact1);

        List<Applications> applications = Arrays.asList(app1,app2);

        Mockito.when(applicationsDao.findByContact_Id(1)).thenReturn(Optional.of(applications));

        Applications app3 = new Applications();
        app3.setProductName("Ипотека");
        app3.setDtCreated(new Date(1530459216000L));
        app3.setContact(contact2);

        Mockito.when(applicationsDao.findByContact_Id(3)).thenReturn(Optional.empty());

        service = new ContactApplicationService(applicationsDao,contactDao);
    }

    @Test
    public void process_successWith2Applications() {
        Response response = service.process(1);

        Assert.assertThat(response, instanceOf(SuccessResponse.class));
        Assert.assertTrue(response.isSuccess());

        SuccessResponse successResponse = (SuccessResponse) response;

        Assert.assertEquals(successResponse.getResult().getContactId(),1);
        Assert.assertEquals(successResponse.getResult().getApplication().getProductName(), "Дебетовая карта");
    }

    @Test(expected = ApplicationsNotFoundException.class)
    public void process_throwsApplicationsNotFoundException() {
        Response response = service.process(3);
    }
}