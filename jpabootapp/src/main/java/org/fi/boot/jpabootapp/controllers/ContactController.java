package org.fi.boot.jpabootapp.controllers;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.ContactDTO;
import org.fi.boot.jpabootapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@GetMapping("/contacts/{pageNo}/{size}")
public Iterator<ContactDTO> getPage(@PathVariable("pageNo")int pageNo,@PathVariable("size")int size) {
	return contactService.pageData(pageNo, size);
}
@GetMapping("/findById/{cid}")
public ContactDTO findByContactId(@PathVariable("cid")int contactId) {
	return contactService.getContactByID(contactId);
}

@GetMapping("/findByFirstName")
public ContactDTO findByContactFirstName(@RequestParam("fname")String firstName) {
	return contactService.getContactByFirstName(firstName);
}
@GetMapping("/findByLastName")
public ContactDTO findByContactLasttName(@RequestParam("lname")String lastName) {
	return contactService.getContactByLastName(lastName);
}
@GetMapping("/allContactByDomain")
public Iterator<ContactDTO> findByContactEmailDomain(@RequestParam("email")String emailDomain) {
	return contactService.getContactByEmailDomain(emailDomain);
}


}
