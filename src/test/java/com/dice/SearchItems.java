package com.dice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchItems {

	

	public static void main(String[] args) {

		
		List<String> KiWi = new ArrayList<>(); 
		
		try (
		FileReader fr = new FileReader("LocationsZip.txt");
		BufferedReader br = new BufferedReader(fr); )
		{
		String value;
		while ((value = br.readLine()) != null) {  
			KiWi.add(value);  
			}
		}catch (IOException e) {  e.printStackTrace();  }
		
		DiceJobSearch.main(KiWi);

	}
}
