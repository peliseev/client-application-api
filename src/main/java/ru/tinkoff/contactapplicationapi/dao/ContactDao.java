package ru.tinkoff.contactapplicationapi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tinkoff.contactapplicationapi.entity.Contact;

import java.util.Optional;

public interface ContactDao extends CrudRepository<Contact, Long> {
    Optional<Contact> findById (long contactId);
}