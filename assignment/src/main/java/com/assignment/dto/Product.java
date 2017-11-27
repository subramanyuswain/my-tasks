package com.assignment.dto;

import com.assignment.constants.Constants;

public class Product {
	
	private int id;
	private String productName;
	private int unitPrice;
	private int numberOfUnits;
	
	
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = processProductName(productName);
	}
	
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String processProductName(String productName){
		int currentLength = productName.length();
		int diff = currentLength-Constants.FIXED_PRODUCT_NAME_SIZE;
		if(diff>0)
			productName = productName.substring(Constants.BEGIN_INDEX, Constants.FIXED_PRODUCT_NAME_SIZE);
		if(diff<0){
			productName = productName+returnSpace(diff);
		}
		return productName;
	}
	public String returnSpace(int number){
		int input = Math.abs(number);
		StringBuilder result = new StringBuilder();
		for(int i=0; i<input; i++){
			result.append(" ");
		}
		return result.toString();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", unitPrice=" + unitPrice + ", numberOfUnits="
				+ numberOfUnits + "]";
	}

}
