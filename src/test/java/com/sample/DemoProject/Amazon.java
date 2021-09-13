package com.sample.DemoProject;

import org.testng.Assert;
//import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon {
	static WebDriver driver;
	private String link, Emailid, password, Books;

	@BeforeClass
	public void initiate() {
		driver = new ChromeDriver();
		link = "https://www.amazon.in/";
		driver.get(link);
		driver.manage().window().maximize();
		

	}

	@Test()
	public void Test01() {
		WebElement signin = driver.findElement(By.cssSelector("[id*='link-accountList-']"));
	    signin.click();
		WebElement loginPageIcon = driver.findElement(By.cssSelector(".a-icon.a-icon-logo"));
		Assert.assertTrue(loginPageIcon.isDisplayed());
	}

	@Test()
	public void Test02() {
		WebElement emailid = driver.findElement(By.cssSelector("#ap_email"));
		Emailid = "yogendra46vashistha@gmail.com";
		emailid.sendKeys(Emailid);
		WebElement continueButton = driver.findElement(By.cssSelector("input[id='continue']"));
		continueButton.click();
		WebElement passwordField = driver.findElement(By.cssSelector("#ap_password"));
		password = "Yogi@1998";
		passwordField.sendKeys(password);
		driver.findElement(By.cssSelector("#signInSubmit")).click();

	}

	@Test(dependsOnMethods = "Test01")
	public void Test03() {
		WebElement search = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		search.sendKeys(Books);
		WebElement searchbutton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
		searchbutton.click();
		List<WebElement> nameofbook = driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
		List<WebElement> priceofbook = driver.findElements(By.cssSelector("[class*='a-spacing-top-small'] .a-price-whole"));
		for (int i = 0; i < 30; i++) {
			System.out.println("Book " + i + " Name = " + nameofbook.get(i).getText());
			System.out.println("price of book is"+ " " + priceofbook.get(i).getText());

		}
	}

}
