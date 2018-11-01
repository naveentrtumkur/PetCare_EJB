package com.chase.payment;

public class PaymentProcessor {

	String name;
	int number, expiration, cvv, amount;
	CreditCardPayment credit = new CreditCardPayment(name, number, expiration, cvv, amount);
	public String ping()
	{
		return "Bank is up and running";
	}
	
	public String processPayment(CreditCardPayment creditCard)
	{
		return "1234";
	}
}