package com.assignment.bsl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.assignment.constants.Constants;
import com.assignment.constants.PaymentMode;
import com.assignment.dao.Bill;
import com.assignment.dao.ProductData;
import com.assignment.dto.Customer;
import com.assignment.dto.Order;
import com.assignment.dto.OrderDetail;
import com.assignment.dto.Product;
import com.assignment.dto.UserInput;

public class OrderService {
	
	public void placeOrder(){
		ProductData productData = new ProductData();
		Customer costomer = new Customer();
		String name = Constants.DEFAULT_NAME;
		String address = Constants.DEFAULT_ADDRESS;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer name");
		String temp = sc.nextLine();
		if(!temp.trim().isEmpty())
			name = temp;
		costomer.setName(name);
		System.out.println("Enter address");
		temp = sc.nextLine();
		if(!temp.trim().isEmpty())
			address = temp;
		costomer.setAddress(address);
		System.out.println(productData);
		
		
		List<UserInput> userInputList = fetchOrder(sc, productData);
		Order order = calculateOrder(userInputList, productData);
		
		Bill bill = new Bill();
		costomer.setPaymentMethod(fetchPaymentmode(sc));
		bill.generateBill(order,costomer);
		sc.close();
	}
	public Order calculateOrder(List<UserInput> input, ProductData productData){
		Map<Integer, Product> productMap = productData.getProductDataMap();
		
		//find Order details
		OrderDetail orderDetail = new OrderDetail();
		List<Product> productList = new ArrayList<Product>();
		int total = 0;
		for(UserInput i: input){
			Product p = productMap.get(i.getProductId());
			p.setNumberOfUnits(i.getNumberOfUnits());
			productList.add(p);
			total = total+(p.getUnitPrice()*p.getNumberOfUnits());
		}
		orderDetail.setProducts(productList);
		orderDetail.setTotalPrice(total);
		orderDetail.setTax((int)(total*Constants.TAX));
		int tax = (int)(total*Constants.TAX);
		
		//Order 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		Order order = new Order();
		order.setDate(dtf.format(localDate));
		order.setStatus("Payment status");
		order.setOrderDetail(orderDetail);
		order.setTotal(tax+total);
		
		return order;
	}
	
	public List<UserInput> fetchOrder(Scanner sc, ProductData productData){
		List<UserInput> result = new ArrayList<UserInput>();
		Map<Integer,Integer> inputIds = new HashMap<Integer,Integer>();
		int numberOfUnits = 0;
		int id = 0;
		int maxValidItemOption = productData.getProductData().size();
		boolean nextOrder = true;
		boolean invalidInput = false;
		do{
			System.out.println("Enter the Id of the"+Constants.PRODUCT+"which you want to Order");
			
			do{
				id = sc.nextInt();
				invalidInput = isInvalidInput(maxValidItemOption, id);
				if(invalidInput){
					System.out.println("Invalid input, please enter between 1 to "+maxValidItemOption);
				}
				else if(inputIds.containsKey(id)){
					System.out.println("Item already added, please any other id");
					invalidInput = true;
				}
				else
					inputIds.put(id,id);
			}
			while(invalidInput);
			System.out.println();
			System.out.println("Enter the number of units of "+productData.getProductDataMap().get(id).getProductName());
			numberOfUnits = sc.nextInt();
			
			UserInput userInput = new UserInput(id, numberOfUnits);
			result.add(userInput);
			System.out.println();
			System.out.println("Would you like to place another Order , type (Y/N)");
			String userApproval = sc.next();
			nextOrder = userApproval.equalsIgnoreCase("N")?false:true;
		}
		while(nextOrder);
		return result;
	}
	
	public boolean isInvalidInput(int max, int input){
		if(input > max || input<=0)
			return true;
		else
			return false;
	}
	
	public String fetchPaymentmode(Scanner sc){
		System.out.println("Select payment Mode type,");
		System.out.println("1 for Debit Card");
		System.out.println("2 for Credit Card");
		System.out.println("3 for Cash Card");
		System.out.println("4 for Check");
		String result = Constants.DEFAULT_PAYMENT;
		boolean invalidInput = true;
		do{
			int pay= sc.nextInt();
			if(pay<1 || pay>4){
				System.out.println("Invalid entry, please enter correct value");
				invalidInput = true;
			}
			else{
				result=PaymentMode.getPaymentMode(pay);
				invalidInput=false;
			}
		}while(invalidInput);
		System.out.println("Payment Successful");
		return result;
	}
	
	public static void main(String args[]){
		OrderService orderService = new OrderService();
		orderService.placeOrder();
		//System.out.println(orderService.fetchPaymentmode(new Scanner(System.in)));
	}
	

}
