package org.fi.boot.jpabootapp.repository;

import org.fi.boot.jpabootapp.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
