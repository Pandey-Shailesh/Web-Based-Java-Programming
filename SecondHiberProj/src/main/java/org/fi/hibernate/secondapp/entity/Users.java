package org.fi.hibernate.secondapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users_0029")
//HQL
@NamedQueries({
	@NamedQuery(name="allUsers",query="from Users"),
	@NamedQuery(name="byUserName",query="select OBJECT(objUser) from Users objUser where objUser.userName=?1")
})
@NamedNativeQueries({
	@NamedNativeQuery(name="nallUsers",query="select * from users_0029"),
	@NamedNativeQuery(name="nbyUserName",query="select * from users_0029  where userName=?1")
})
public class Users {
@Id
@Column(name="username")
	String userName;
@Column(name="password")
	String password;
@Column(name="name")
	String name;
@Column(name="email")
	String email;

	@Override
public String toString() {
	return "Users [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email + "]";
}

	public Users() {

	}

	public Users(String userName, String password, String name, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
