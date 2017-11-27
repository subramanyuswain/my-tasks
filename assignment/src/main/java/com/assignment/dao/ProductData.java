package com.assignment.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.constants.Constants;
import com.assignment.dto.Product;

public class ProductData {
	
	public ProductData(){
		setProductList();
	}
	private List<Product> productList = new ArrayList<Product>();
	
	private Map<Integer, Product> productMap = new HashMap<Integer, Product>();

	public List<Product> getProductData() {
		return productList;
	}

	private void setProductList() {
		//List<Product> list = new ArrayList<Product>();
		ConsoleInput console = new ConsoleInput();
		int count = 1;
		
		//test readProducts
		Map<String, String> map = console.readProducts();
		for(Map.Entry<String, String> m: map.entrySet()){
			Product product = new Product();
			String name = m.getKey();
			int price = Integer.parseInt(m.getValue());
			product.setId(count++);
			product.setProductName(name);
			product.setUnitPrice(price);
			productList.add(product);
		}
	}
	
	public Map<Integer,Product> getProductDataMap(){
		for(Product p: productList){
			productMap.put(p.getId(), p);
		}
		return productMap;
	}
	
	@Override
	public String toString() {
		String output1 = Constants.NEXT_LINE+Constants.ID+Constants.DOUBLE_TAB+Constants.NAME+Constants.DOUBLE_TAB+Constants.UNITS+Constants.DOUBLE_TAB+Constants.COST_PER_UNIT+Constants.NEXT_LINE;
		StringBuilder s = new StringBuilder();
		s.append(output1);
		for(Product p: productList){
			s.append(p.getId()+Constants.DOUBLE_TAB+p.getProductName()+Constants.DOUBLE_TAB+p.getNumberOfUnits()+Constants.DOUBLE_TAB+p.getUnitPrice()+Constants.NEXT_LINE);
		}
		return s.toString();
	}
}
