package org.fi.boot.jpabootapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.fi.boot.jpabootapp.dto.ContactDTO;
import org.fi.boot.jpabootapp.entity.Contact;
import org.fi.boot.jpabootapp.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public Iterator<ContactDTO> pageData(int pageNo, int size) {
		Pageable page = PageRequest.of(pageNo, size,Sort.by("firstName").ascending());
		Iterator<Contact> iter = contactRepository.findAll(page).iterator();
		ArrayList<ContactDTO> list = new ArrayList<>();
		
		while (iter.hasNext()) {
			Contact objContact = iter.next();
			ContactDTO contactDTO= new ContactDTO();
			BeanUtils.copyProperties(objContact, contactDTO);
			list.add(contactDTO);
		}
		return list.iterator();
	}

	@Override
	public ContactDTO getContactByID(int contactId) {
		Optional<Contact> optContact= contactRepository.findById(contactId);
		if (optContact.isPresent()) {
			Contact objContact = optContact.get();
			ContactDTO contactDTO= new ContactDTO();
			BeanUtils.copyProperties(objContact, contactDTO);
			return contactDTO;
		}
		return null;
	}

	@Override
	public ContactDTO getContactByFirstName(String firstName) {
		Optional<Contact> optContact= contactRepository.findByFirstName(firstName);
		if (optContact.isPresent()) {
			Contact objContact = optContact.get();
			ContactDTO contactDTO= new ContactDTO();
			BeanUtils.copyProperties(objContact, contactDTO);
			return contactDTO;
		}
		return null;

	}

	@Override
	public ContactDTO getContactByLastName(String lastName) {
		Optional<Contact> optContact= contactRepository.findByLastName(lastName);
		if (optContact.isPresent()) {
			Contact objContact = optContact.get();
			ContactDTO contactDTO= new ContactDTO();
			BeanUtils.copyProperties(objContact, contactDTO);
			return contactDTO;
		}
		return null;
	}

	@Override
	public Iterator<ContactDTO> getContactByEmailDomain(String emailDomain) {
		Iterator<Contact> iter = contactRepository.getEmailDomainLike(emailDomain).iterator();
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
