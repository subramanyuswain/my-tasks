package com.assignment.dto;

public class Item {
	
	private int shippingWeight;
	private String description;
	private int totalPrice;
	public int getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(int shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Item [shippingWeight=" + shippingWeight + ", description=" + description + ", totalPrice=" + totalPrice
				+ "]";
	}

}
