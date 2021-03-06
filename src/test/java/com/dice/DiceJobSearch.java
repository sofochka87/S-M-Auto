package com.dice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(List<String> args) {
		
		//Set up Chrome driver path
		WebDriverManager.chromedriver().setup();
		//invoke Selenium webDriver
		WebDriver driver = new ChromeDriver();
		
		//fullscreen 
		//driver.manage().window().fullscreen();
		//set wait time in case web page is slow
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String location = "";
		for(String x : args) {
			location = x;
			
		//navigate to http://dice.com
		String url = "http://dice.com";
		driver.get(url);
		
		
			
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice home page successfuly loaded");
		}else {
			System.out.println("Step FAIL. Dice homepage did not load succesfully");
			throw new RuntimeException("Step FAIL. Dice homepage did not load succesfully");
		}
		
		
			
			
		String keyWord = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyWord);
		
			
		//String location = "22102";
        driver.findElement(By.id("search-field-location")).clear();
        driver.findElement(By.id("search-field-location")).sendKeys(location);
        
        driver.findElement(By.id("findTechJobs")).click();
        
        String count ="";
        try {
              count = driver.findElement(By.id("posiCountId")).getText();
        }catch (org.openqa.selenium.NoSuchElementException e) { 
        	System.out.println("In Location: "+location  + ", results: not found");}
        
        if(count.equals("")) { continue; }
        System.out.println(count);
        
        //Ensure count is more than ZERO
        int countResult = Integer.parseInt(count.replace(",", ""));
        if(countResult > 0) {
        	System.out.println("Step PASS. Keyword: "+keyWord + "Serch returned "+ countResult+ " result in "+location );
        	
        }else  {
        	System.out.println("Step FAIL. Keyword: "+keyWord + "Serch returned "+ countResult+ "result in "+location );
          }
        
       
        System.out.println("In Location: "+location  +", results: "+ countResult);
        
        
		}
		
		driver.close();
		
        System.out.println();
        
        System.out.println("TEST COMPLITED - "+ LocalDateTime.now());
        
        
        
        
	}
}
