package webhibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users_0029")
//HQL
@NamedQueries({
	
	@NamedQuery(name="authenticateUser",query="select OBJECT(objUser) from Users objUser where objUser.userName=?1 and objUser.password=?2")
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
