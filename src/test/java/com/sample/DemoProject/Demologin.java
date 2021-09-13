package com.sample.DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demologin {
	static WebDriver driver;
	String url;

	@BeforeClass
	public void initiate() {
		driver = new ChromeDriver();
		url = "https://demoqa.com/login";

		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void Test00() {
		WebElement Newuserbutton = driver.findElement(By.cssSelector("#newUser"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)", "");
		Newuserbutton.click();
	}

	@Test
	public void Test01() throws InterruptedException {
		WebElement firstName = driver.findElement(By.cssSelector("#firstname"));
		WebElement lastName = driver.findElement(By.cssSelector("#lastname"));
		WebElement Username = driver.findElement(By.cssSelector("#userName"));
		WebElement password = driver.findElement(By.cssSelector("#password"));
		firstName.sendKeys("Yogendra");
		lastName.sendKeys("Vashishtha");
		Username.sendKeys("yogi");
		password.sendKeys("yogi1998");
		Thread.sleep(20000);
		driver.findElement(By.id("register")).click();
	}

	@Test
	public void Test02() throws InterruptedException {
		WebElement Nested = driver.findElement(By.xpath(
				"//div[text()='Book Store Application']/../../..//div[@class='element-list collapse show']//li[@id='item-2']"));
		System.out.println(Nested.getText());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", Nested);
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("input#searchBox")).sendKeys("yogendra");
		System.out.println(verifyBookIsAvailable());
	}

	String bookName;

	public String verifyBookIsAvailable() {
		if (isBookPresent()) {
			bookName = driver.findElement(By.cssSelector(".rt-tbody .action-buttons")).getText();
		} else
			bookName = "No such Book found";
		return bookName;

	}

	public boolean isBookPresent() {
		boolean a = false;
		try {
			return driver.findElement(By.cssSelector(".rt-tbody .action-buttons")).isDisplayed();
		} catch (Exception e) {
			return a;
		}
	}

}
