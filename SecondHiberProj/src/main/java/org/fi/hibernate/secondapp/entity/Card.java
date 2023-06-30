package org.fi.hibernate.secondapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card_0029")
public class Card {
	
	@Column(name="srNo")
	@GeneratedValue(generator="increment")
	int srNo;
	@Id
	@Column(name="cardNo")
	String cardNo;
	@Column(name="expirty")
	String expirty;
	@Column(name="cvv")
	int cvv;
	@Column(name="balance")
	float balance;
	
	public Card() {
		
	}
	public Card(int srNo, String cardNo, String expirty, int cvv,float balance) {
		super();
		this.srNo = srNo;
		this.cardNo = cardNo;
		this.expirty = expirty;
		this.cvv = cvv;
		this.balance=balance;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpirty() {
		return expirty;
	}
	public void setExpirty(String expirty) {
		this.expirty = expirty;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}

}
