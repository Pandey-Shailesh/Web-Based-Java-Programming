package org.fi.boot.jpabootapp.services;

import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.ContactDTO;

public interface ContactService {
public boolean addContact(ContactDTO contactDTO);
public boolean deleteContact(int contactId);
public Iterator<ContactDTO> getAllContacts();
public Iterator<ContactDTO> pageData(int pageNo,int size);
}
