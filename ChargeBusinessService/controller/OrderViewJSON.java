package com.ibm.intrada.order.controller;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderViewJSON {

	private String orderNumber;
	private String accountNumber;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
	
}
