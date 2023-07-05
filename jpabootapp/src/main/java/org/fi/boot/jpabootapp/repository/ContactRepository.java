package org.fi.boot.jpabootapp.repository;

import java.util.List;
import java.util.Optional;

import org.fi.boot.jpabootapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
public Optional<Contact>findByFirstName(String firstName);
public Optional<Contact>findByLastName(String lastName);
@Query(value="select * from contacts_0029 where email like %:criteria",nativeQuery = true)
public List<Contact> getEmailDomainLike(@Param("criteria")String emailDomain);
}
