package com.chase.payment;

public class CreditCardPayment {

	String name;
	int number, expiration, cvv, amount;
	public CreditCardPayment(String name, int number, int expiration, int cvv, int amount) {
		super();
		this.name = name;
		this.number = number;
		this.expiration = expiration;
		this.cvv = cvv;
		this.amount = amount;
	}
	
}
