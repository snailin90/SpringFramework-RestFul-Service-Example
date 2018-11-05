package com.devcore.service;

import com.devcore.entity.Contact;
import com.devcore.entity.ContactResponse;
import com.devcore.repository.ContactRepository;
import com.devcore.utility.Constant;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Snailin Inoa
 */
@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public ContactResponse getContacts() {
        LOGGER.debug("getContacts :: START");
        ContactResponse contactResponse = new ContactResponse();
        try {
            contactResponse.setContactList(contactRepository.findAll());
            contactResponse.setCode(Constant.SUCCESS_CODE);
            contactResponse.setMessage(Constant.SUCCESS_MSG);
        } catch (Exception e) {
            contactResponse.setCode(Constant.ERROR_CODE);
            contactResponse.setMessage(Constant.ERROR_MSG + " : " + e.getMessage());
        }
        LOGGER.debug("getContacts :: END");
        return contactResponse;

    }

    @Override
    public ContactResponse createContact(Contact contact) {
        LOGGER.debug("createContact :: START");
        ContactResponse contactResponse = new ContactResponse();
        try {
            Contact contactCreated = contactRepository.save(contact);
            contactResponse.setContact(contactCreated);
            contactResponse.setCode(Constant.SUCCESS_CODE);
            contactResponse.setMessage(Constant.SUCCESS_MSG);
        } catch (Exception e) {
            contactResponse.setCode(Constant.ERROR_CODE);
            contactResponse.setMessage(Constant.ERROR_MSG + " : " + e.getMessage());
        }
        LOGGER.debug("createContact :: END");
        return contactResponse;
    }

    @Override
    public ContactResponse removeContact(Contact contact) {
        LOGGER.debug("removeContact :: START");
        ContactResponse contactResponse = new ContactResponse();
        try {
            boolean isPresent = contactRepository.findById(contact.getId()).isPresent();
            if (!isPresent) {
                contactResponse.setCode(Constant.ERROR_CODE);
                contactResponse.setMessage(Constant.ERROR_MSG + " : " + "Contact with the ID : " + contact.getId() + " was not Found in the System.");

            } else {
                contactRepository.deleteById(contact.getId());
                contactResponse.setCode(Constant.SUCCESS_CODE);
                contactResponse.setMessage(Constant.SUCCESS_MSG);
            }
        } catch (Exception e) {
            contactResponse.setCode(Constant.ERROR_CODE);
            contactResponse.setMessage(Constant.ERROR_MSG + " : " + e.getMessage());

        }
        LOGGER.debug("removeContact :: END");
        return contactResponse;
    }

    @Override
    public ContactResponse updateContact(Contact contact) {
        LOGGER.debug("updateContact :: START");
        ContactResponse contactResponse = new ContactResponse();

        try {

            boolean isPresent = contactRepository.findById(contact.getId()).isPresent();

            if (!isPresent) {
                contactResponse.setCode(Constant.ERROR_CODE);
                contactResponse.setMessage(Constant.ERROR_MSG + " : " + "Contact with the ID : " + contact.getId() + " was not Found in the System.");

            } else {
                Contact updatedContact = contactRepository.save(contact);
                contactResponse.setContact(updatedContact);
                contactResponse.setCode(Constant.SUCCESS_CODE);
                contactResponse.setMessage(Constant.SUCCESS_MSG);
            }
        } catch (Exception e) {

            contactResponse.setCode(Constant.ERROR_CODE);
            contactResponse.setMessage(Constant.ERROR_MSG + " : " + e.getMessage());

        }
        LOGGER.debug("updateContact :: END");
        return contactResponse;

    }

}
