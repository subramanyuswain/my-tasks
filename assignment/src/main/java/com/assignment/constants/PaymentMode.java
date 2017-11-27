package com.assignment.constants;

import java.util.Scanner;

public enum PaymentMode {
	CASH("Cash"),
	CREDIT_CARD("Credit Card"),
	DEBIT_CARD("Debit Card"),
	CHECK("Check");
	
	private String value;
	PaymentMode(String value){
		this.value=value;
	}
	
	public static String getPaymentMode(int pay){
		String result = Constants.INVALID_PAYMENT;
		if(pay<1 || pay>4){
			return result;
		}
		else if(pay == 1){
			result = PaymentMode.DEBIT_CARD.value;
			getDebitcardNumber();
		}
		else if(pay == 2){
			result = PaymentMode.CREDIT_CARD.value;
			getCreditcardNumber();
		}
		else if(pay == 3)
			result = PaymentMode.CASH.value;
		else if(pay == 4){
			result = PaymentMode.CHECK.value;
			getCheckNumber();
		}
		return result;
	}
	
	public static String getCheckNumber(){
		System.out.println("Please enter check number");
		Scanner sc = new Scanner(System.in);
		String checkNumber = sc.nextLine();
		sc.close();
		return checkNumber;
	}
	public static String getCreditcardNumber(){
		System.out.println("Please enter credit card number");
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		System.out.println("Please enter expiry date in mm/yy");
		String expDate = sc.nextLine();
		sc.close();
		return number;
	}
	public static String getDebitcardNumber(){
		System.out.println("Please enter Debit card number");
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		sc.close();
		return number;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		System.out.println(PaymentMode.getPaymentMode(pay));
		sc.close();
	}
}
