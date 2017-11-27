package com.assignment.dto;

import java.util.List;

public class OrderDetail {
	private List<Product> products;
	private int totalPrice;
	private int tax;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	@Override
	public String toString() {
		return "OrderDetail [products=" + products + ", totalPrice=" + totalPrice + ", tax=" + tax + "]";
	}
}
