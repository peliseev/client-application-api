package ru.tinkoff.contactapplicationapi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tinkoff.contactapplicationapi.entity.Applications;

import java.util.List;
import java.util.Optional;

public interface ApplicationsDao extends CrudRepository<Applications, Long> {
    Optional<List<Applications>> findByContact_Id(long contactId);
}
