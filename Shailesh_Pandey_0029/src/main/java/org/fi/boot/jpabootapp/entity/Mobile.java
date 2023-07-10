package org.fi.boot.jpabootapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mobilephone_0029")
public class Mobile {
	@Id
	@Column(name="phoneid")
	@GeneratedValue(generator = "increment")
	int phoneId;
	@Column(name="phonename")
	String phoneName;
	@Column(name="phonememory")
	int phoneMemory;
	@Column(name="phoneos")
	String phoneOS;
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public int getPhoneMemory() {
		return phoneMemory;
	}
	public void setPhoneMemory(int phoneMemory) {
		this.phoneMemory = phoneMemory;
	}
	public String getPhoneOS() {
		return phoneOS;
	}
	public void setPhoneOS(String phoneOS) {
		this.phoneOS = phoneOS;
	}
	public int getPhoneSize() {
		return phoneSize;
	}
	public void setPhoneSize(int phoneSize) {
		this.phoneSize = phoneSize;
	}
	@Column(name="phonesize")
	int phoneSize;
}
