package org.fi.boot.jpabootapp.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.fi.boot.jpabootapp.dto.ContactDTO;
import org.fi.boot.jpabootapp.entity.Contact;
import org.fi.boot.jpabootapp.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	ContactRepository contactRepository;
	
	@Override
	public boolean addContact(ContactDTO contactDTO) {
		Contact objContact = new Contact();
		BeanUtils.copyProperties(contactDTO, objContact);
		if (contactRepository.save(objContact)!=null) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean deleteContact(int contactId) {
		contactRepository.deleteById(contactId);
		return true;
	}

	@Override
	public Iterator<ContactDTO> getAllContacts() {
		Iterator<Contact> iter = contactRepository.findAll().iterator();
		ArrayList<ContactDTO> list = new ArrayList<>();
		
		while (iter.hasNext()) {
			Contact objContact = iter.next();
			ContactDTO contactDTO= new ContactDTO();
			BeanUtils.copyProperties(objContact, contactDTO);
			list.add(contactDTO);
		}
		return list.iterator();
	}

}
