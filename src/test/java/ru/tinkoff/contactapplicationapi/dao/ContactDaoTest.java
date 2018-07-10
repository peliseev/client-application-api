package ru.tinkoff.contactapplicationapi.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.contactapplicationapi.entity.Contact;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactDaoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ContactDao contactDao;

    @Test
    public void whenFindById_thenReturnContact() {
        Contact contact = new Contact();
        Object contactId = testEntityManager.persistAndGetId(contact);
        testEntityManager.flush();

        Optional<Contact> found = contactDao.findById((long) contactId);
        assertThat(found.get().getId()).isEqualTo((long) contactId);
    }

}