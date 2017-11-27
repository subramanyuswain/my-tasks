package com.assignment.dao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInput {
	public static final String PATH = "Products.txt";
	public Map<String, String> readProducts() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource(PATH).getFile());
			Scanner in = new Scanner(file);
			String line = "";
			while (in.hasNextLine()) {
				line = in.nextLine();
				String parts[] = line.split(":");
				map.put(parts[0].trim(), parts[1].trim());
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
}
