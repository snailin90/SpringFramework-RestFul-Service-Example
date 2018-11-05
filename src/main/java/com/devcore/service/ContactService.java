package com.devcore.service;

import com.devcore.entity.Contact;
import com.devcore.entity.ContactResponse;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Snailin Inoa
 *
 * ContactService interface have the CRUD Methods that will have the business
 * logic.
 *
 */
@Service
public interface ContactService {

    public ContactResponse getContacts();

    public ContactResponse createContact(Contact contact);

    public ContactResponse removeContact(Contact contact);

    public ContactResponse updateContact(Contact contact);

}
