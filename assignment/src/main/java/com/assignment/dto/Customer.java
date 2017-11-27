package com.assignment.dto;

public class Customer {
	
	public Customer(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String address;
	private String paymentMethod = "Cash";
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + "]";
	}

}
