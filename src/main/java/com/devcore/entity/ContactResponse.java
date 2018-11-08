package com.devcore.entity;

import com.devcore.utility.OutputResponse;
import java.util.List;

/**
 *
 * @author Snailin Inoa
 */
public class ContactResponse extends OutputResponse {

    private List<Contact> contactList;
    private Contact contact;

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactResponse{" + "contactList=" + contactList + ", contact=" + contact + '}';
    }

}
