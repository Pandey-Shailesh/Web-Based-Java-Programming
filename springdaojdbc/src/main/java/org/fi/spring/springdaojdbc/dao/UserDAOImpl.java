package org.fi.spring.springdaojdbc.dao;

import java.util.Iterator;

import org.fi.spring.springdaojdbc.entity.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory hibernateFactory;
	

	@Override
	public boolean addUser(Users objUser) {
	
		try (Session hibernateSession = hibernateFactory.openSession()) {
			
			hibernateSession.beginTransaction();
			hibernateSession.save(objUser);
			hibernateSession.getTransaction().commit();
			return true;
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean authenticate(String userName, String password) {
try (Session hibernateSession = hibernateFactory.openSession()) {
			Users objUser= hibernateSession.find(Users.class, userName);
			if (objUser.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
			
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	
	}

	@Override
	public Iterator<Users> allUsers() {
try (Session hibernateSession = hibernateFactory.openSession()) {
			Query<Users> query = hibernateSession.createQuery("from Users");
			return query.getResultList().iterator();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
