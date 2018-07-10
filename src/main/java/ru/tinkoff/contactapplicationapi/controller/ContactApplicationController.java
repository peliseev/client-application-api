package ru.tinkoff.contactapplicationapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.contactapplicationapi.model.Response;
import ru.tinkoff.contactapplicationapi.service.ContactApplicationService;

@RestController
public class ContactApplicationController {

    private ContactApplicationService contactApplicationService;

    @Autowired
    public ContactApplicationController(ContactApplicationService contactApplicationService) {
        this.contactApplicationService = contactApplicationService;
    }

    @GetMapping("/contact/{contactId}/application")
    public Response getContactApplication(@PathVariable("contactId") long contactId) {
        return contactApplicationService.process(contactId);
    }
}
