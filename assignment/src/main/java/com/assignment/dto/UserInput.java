package com.assignment.dto;

public class UserInput {
	
	private int productId;
	public UserInput(int productId, int numberOfUnits) {
		super();
		this.productId = productId;
		this.numberOfUnits = numberOfUnits;
	}
	public UserInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int numberOfUnits;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	@Override
	public String toString() {
		return "UserInput [productId=" + productId + ", numberOfUnits=" + numberOfUnits + "]";
	}

}
