package com.sample.DemoProject;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
    static WebDriver driver;
    static WebDriverWait wait;
    private String url, headingText, emailID;
	
	@BeforeClass
	public void initiate() {
	driver = new ChromeDriver();
	url = "http://demo.guru99.com/popup.php";
	emailID = "yogendra46vashistha@gmail.com";
	
	driver.get(url);
	driver.manage().window().maximize();
	}
	
	@Test
	public void Test00_Clicking_the_first_button() throws InterruptedException {
		WebElement clickhereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickhereButton.click();
		Thread.sleep(1000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(driver.getCurrentUrl());
		System.out.println(tabs2);
		System.out.println(tabs2.size());
		driver.switchTo().window(tabs2.get(1));
		System.out.println(driver.getCurrentUrl());
	}
	
	
	@Test(dependsOnMethods = "Test00_Clicking_the_first_button")
	public void Test01_Verify_Url_Launch_Successfully() {
		WebElement heading = driver.findElement(By.cssSelector("h2[class*='barone']"));
		headingText = heading.getText();
		System.out.println("Text we are getting from UI:"+headingText);
		Assert.assertEquals(headingText, "Guru99 Bank");
	}
	
	@Test(dependsOnMethods = "Test01_Verify_Url_Launch_Successfully")
	public void Test02_Verify_User_Can_Enter_Their_Email_Address() {
		WebElement emailId = driver.findElement(By.name("emailid"));
		emailId.sendKeys(emailID);
		Assert.assertTrue(emailID.contains("@gmail.com"));
		Assert.assertTrue(!emailID.isEmpty());
	}
	
	@Test(dependsOnMethods = "Test02_Verify_User_Can_Enter_Their_Email_Address")
	public void Test03_clicking_the_button() {
		WebElement submitButton = driver.findElement(By.cssSelector("[value='Submit']"));
		submitButton.click();
	}
	

	//@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}
