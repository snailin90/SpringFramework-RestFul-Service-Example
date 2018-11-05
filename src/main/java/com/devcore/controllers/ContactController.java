package com.devcore.controllers;

import com.devcore.entity.Contact;
import com.devcore.entity.ContactResponse;
import com.devcore.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Snailin Inoa
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/api/getContacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactResponse getContacts() {
        return contactService.getContacts();
    }

    @RequestMapping(value = "/api/createContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactResponse createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @RequestMapping(value = "/api/updateContact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactResponse updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @RequestMapping(value = "/api/removeContact", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContactResponse removeContact(@RequestBody Contact contact) {
        return contactService.removeContact(contact);
    }

}
