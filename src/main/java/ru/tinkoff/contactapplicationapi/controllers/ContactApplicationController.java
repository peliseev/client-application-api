package ru.tinkoff.contactapplicationapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.contactapplicationapi.models.Response;
import ru.tinkoff.contactapplicationapi.services.ContactApplicationService;

@RestController
public class ContactApplicationController {

    @Autowired
    private ContactApplicationService contactApplicationService;

    @GetMapping("/contact/{contactId}/application")
    public ResponseEntity<Response> getContactApplication (@PathVariable("contactId") long contactId) {
        Response response = contactApplicationService.process(contactId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
