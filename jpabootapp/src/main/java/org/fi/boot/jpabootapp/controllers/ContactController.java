package org.fi.boot.jpabootapp.controllers;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.ContactDTO;
import org.fi.boot.jpabootapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
@Autowired
ContactService contactService;

@RequestMapping("/addContact")
public boolean addContact(@RequestBody ContactDTO contactDTO) {
	return contactService.addContact(contactDTO);
}
@RequestMapping("/allContact")
public Iterator<ContactDTO> getAllContacts() {
	return contactService.getAllContacts();
}
@RequestMapping("/deleteContact/{cid}")
public boolean deleteContact(@PathVariable("cid")int contactId) {
	return contactService.deleteContact(contactId);
}






}
