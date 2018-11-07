package com.devcore;

import com.devcore.controllers.ContactController;
import com.devcore.entity.Contact;
import com.devcore.entity.ContactResponse;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author sinoa {ContactRestControllerTest} is testing class for the
 * ContactController Component To skip the test when compiling use this command
 * : mvn -DskipTests clean install   or mvn test
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactRestControllerTest {

    @Autowired
    private ContactController contactController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void CheckGetContactListService() {
        ContactResponse contactResponse = contactController.getContacts();
        Assert.assertThat(contactResponse.getCode(), Matchers.is("000"));
    }

    @Test
    public void CheckGetContactListServiceUsingMock() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/contact/api/getContacts")).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000")));
    }

    /*
        Create method using the Autowired component {ContactController}.
        Need to make sure that this Contact doesn't exist in the DB, because if exist will fail because the {EMAIL} field is UNIQUE.
    
     */
    @Test
    public void CheckCreateContactService() {
        Contact contact = new Contact();
        contact.setName("Julio");
        contact.setLastname("Martinez");
        contact.setTelephoneNumber("111-111-1111");
        contact.setCelNumber("222-222-2222");
        contact.setEmail("julio@example.com");
        ContactResponse contactResponse = contactController.createContact(contact);
        Assert.assertThat(contactResponse.getCode(), Matchers.is("000"));
    }

    /*
        Create method using the Autowired component {MockMvc}.
        Need to make sure that this Contact doesn't exist in the DB, because if exist will fail because the {EMAIL} field is UNIQUE.
    
     */
    @Test
    public void CheckCreateContactUsingMock() throws Exception {

        Contact contact = new Contact();
        contact.setName("PEPE");
        contact.setLastname("INOA");
        contact.setTelephoneNumber("111-111-1111");
        contact.setCelNumber("222-222-2222");
        contact.setEmail("pepe@example.com");
        Gson gson = new Gson();
        String contactJSON = gson.toJson(contact);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contact/api/createContact").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content(contactJSON)).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000")));
    }

    /*
        Update method using the Autowired component {ContactController}.
        Need to make sure that this Contact  exist in the DB and the contact.setID(ID_For_existing_record_in_DB), because if the id(Long) passed doesn't
        exist will fail because won't found that record in DB.
    
     */
    @Test
    public void checkUpdateContactService() {
        Contact contact = new Contact();
        contact.setId(1l); // need to make sure this ID exist in the DB, otherwise TEST will fail
        contact.setName("Julio-Updated");
        contact.setLastname("Martinez-Updated");
        contact.setTelephoneNumber("111-111-1111");
        contact.setCelNumber("222-222-2222");
        contact.setEmail("julio@example.com");
        ContactResponse contactResponse = contactController.updateContact(contact);
        Assert.assertThat(contactResponse.getCode(), Matchers.is("000"));

    }

    /*
        Update method using the Autowired component {MockMvc}.
        Need to make sure that this Contact  exist in the DB and the contact.setID(ID_For_existing_record_in_DB), because if the id(Long) passed doesn't
        exist will fail because won't found that record in DB.
    
     */
    @Test
    public void CheckUpdateContactUsingMock() throws Exception {

        Contact contact = new Contact();
        contact.setId(2l);  // need to make sure this ID exist in the DB, otherwise TEST will fail
        contact.setName("PEPE-Updated");
        contact.setLastname("INOA-Updated");
        contact.setTelephoneNumber("111-111-1111");
        contact.setCelNumber("222-222-2222");
        contact.setEmail("pepe@example.com");
        Gson gson = new Gson();
        String contactJSON = gson.toJson(contact);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/contact/api/updateContact").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content(contactJSON)).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000")));
    }

    /*
        Update method using the Autowired component {ContactController}.
        Need to make sure that this Contact  exist in the DB and the contact.setID(ID_For_existing_record_in_DB), because if the id (Long) passed doesn't
        exist will fail because won't found that record in DB for deletion.
    
     */
    @Test
    public void checkRemoveContactService() {
        Contact contact = new Contact();
        contact.setId(1l);
        contact.setName("Julio-Updated");
        contact.setLastname("Martinez-Updated");
        contact.setTelephoneNumber("111-111-1111");
        contact.setCelNumber("222-222-2222");
        contact.setEmail("julio@example.com");
        ContactResponse contactResponse = contactController.updateContact(contact);
        Assert.assertThat(contactResponse.getCode(), Matchers.is("000"));

    }

    /*
        Update method using the Autowired component {ContactController}.
        Need to make sure that this Contact  exist in the DB and the contact.setID(ID_For_existing_record_in_DB), because if the  id (Long) passed doesn't
        exist will fail because won't found that record in DB for deletion.
    
     */
    @Test
    public void checkRemoveContactServiceUsingMock() throws Exception {
        Contact contact = new Contact();
        contact.setId(3l);  // need to make sure this ID exist in the DB, otherwise TEST will fail
        Gson gson = new Gson();
        String contactJSON = gson.toJson(contact);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/contact/api/removeContact").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE).content(contactJSON)).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000")));

    }

}
