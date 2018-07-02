package ru.tinkoff.contactapplicationapi.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.contactapplicationapi.entity.Applications;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationsDaoTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ApplicationsDao applicationsDao;

    @Test
    public void whenFindById_thenReturnContact() throws Exception {
        Applications application = new Applications();
        Object applicationId = testEntityManager.persistAndGetId(application);
        testEntityManager.flush();

        Optional<Applications> found = applicationsDao.findById((long)applicationId);
        assertThat(found.get().getId()).isEqualTo((long)applicationId);
    }

}