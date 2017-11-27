package com.assignment.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.assignment.constants.Constants;
import com.assignment.dto.Customer;
import com.assignment.dto.Order;
import com.assignment.dto.Product;

public class Bill {
	
	public void generateBill(Order order, Customer customer){
		
		StringBuilder s = new StringBuilder();
		s.append(Constants.CUSTOMER_NAME+customer.getName()+Constants.NEXT_LINE);
		s.append(Constants.ADDRESS+customer.getAddress()+Constants.NEXT_LINE);
		s.append(order.getDate()+Constants.NEXT_LINE);
		s.append(Constants.LINE_SEPARATOR);
		s.append(printProductList(order.getOrderDetail().getProducts())+Constants.NEXT_LINE);
		//s.append("Payment method : "+Constants.FIVE_TAB+customer.getPaymentMethod()+Constants.NEXT_LINE);
		s.append(Constants.LINE_SEPARATOR+Constants.NEXT_LINE);
		s.append("Subtotal : "+order.getOrderDetail().getTotalPrice()+Constants.NEXT_LINE);
		s.append("6.25% sales tax : "+order.getOrderDetail().getTax()+Constants.NEXT_LINE);
		s.append("Total : "+order.getTotal());
		System.out.println(s);
		writeToFile(s.toString());
	}
	
	public Customer fetchCustomerDetails(){
		Customer costomer = new Customer();
		String name = "Default name";
		String address = "Default address";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name");
		if (sc.hasNext()) {
			name = sc.nextLine();
		}
		costomer.setName(name);
		System.out.println("Enter address");
		if (sc.hasNext()) {
			address = sc.nextLine();
		}
		costomer.setAddress(address);
		costomer.setPaymentMethod(fetchPaymentMethod(sc));
		sc.close();
		
		return costomer;
	}
	
	public String printProductList(List<Product> productList) {
		String output1 = Constants.NEXT_LINE+Constants.ID+Constants.DOUBLE_TAB+Constants.NAME+Constants.DOUBLE_TAB+Constants.SINGLE_TAB+Constants.UNITS+Constants.DOUBLE_TAB+Constants.COST+Constants.NEXT_LINE;
		StringBuilder s = new StringBuilder();
		s.append(output1);
		for(Product p: productList){
			s.append(p.getId()+Constants.DOUBLE_TAB+p.getProductName()+Constants.DOUBLE_TAB+p.getNumberOfUnits()+Constants.DOUBLE_TAB+Constants.SINGLE_TAB+(p.getUnitPrice()*p.getNumberOfUnits())+Constants.NEXT_LINE);
		}
		return s.toString();
	}
	
	public void writeToFile(String s){
		try {
			File file = new File("Bill.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(s);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String fetchPaymentMethod(Scanner sc){
		String result = "Cash";
		System.out.println("Enter the payment method");
		System.out.println("Enter 0 Cash or 1 for Card");
		int payment = sc.nextInt();
		if(payment == 1)
			result = "Card";
		else
			result = "Cash";
		return result;
	}

}
