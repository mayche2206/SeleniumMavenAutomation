package com.dice;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	
	public static void main(String[] args) {
		
		
		//set up chrome driver path
		WebDriverManager.chromedriver().setup();
		//invoke selenium webdriver
		WebDriver driver = new ChromeDriver();
		
		
		//fullscreen
		
		driver.manage().window().fullscreen();
		
		//set wait time in case web page is slow
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
		String url = "https://dice.com";
		
		driver.get(url);
		
		String actual = driver.getTitle();
		String expected = "Job Search for Technology Professionals | Dice.com";
		
		
		if (actual.equals(expected)) {
			System.out.println("Right one!");
		}else {
			System.out.println("Wrong one!!!");
			
			throw new RuntimeException("WRONG path");
		}
		
		
		
		
		String keyword = "java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		
		String location = "22102";
		
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		
		
		driver.findElement(By.id("findTechJobs")).click();
		
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		int countResult = Integer.parseInt(count.replace(",", ""));
		
		if (countResult > 0) {
			System.out.println("keyword: " +keyword+ " search returned "+countResult + " results in "+location);
			
		}else {
			System.out.println("STEP FAILED: keyword: " +keyword+ " search returned "+countResult + " results in "+location);
			
		}
		
		
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
