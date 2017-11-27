package com.assignment.dao;

import java.util.ArrayList;
import java.util.List;

import com.assignment.dto.UserInput;

public class CreateUserInputList {
	
	List<UserInput> userInputList = new ArrayList<UserInput>();
	
	public List<UserInput> mergeUserInputIntoList(List<Integer> productIds, List<Integer> productUnits){
		int count = 0;
		for(int p: productIds){
			UserInput userInput = new UserInput();
			userInput.setProductId(p);
			userInput.setNumberOfUnits(productUnits.get(count++));
			userInputList.add(userInput);
		}
		return userInputList;
	}

}
