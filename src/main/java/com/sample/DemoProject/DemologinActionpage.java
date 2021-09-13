package com.sample.DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemologinActionpage {
	WebDriver driver;
	public DemologinActionpage(WebDriver driver){
		this.driver=driver;
	}
	public void EnterUserDetailsForRegistration(String fName, String lName, String User, String pass ) {
		
		WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
		WebElement lastName = driver.findElement(By.cssSelector("#lastname"));
		WebElement Username = driver.findElement(By.cssSelector("#userName"));
		WebElement password = driver.findElement(By.cssSelector("#password"));
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Username.sendKeys(User);
		password.sendKeys(pass);
		
	}
	
	
	}
	

