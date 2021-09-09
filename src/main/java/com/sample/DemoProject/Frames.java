package com.sample.DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Frames {
	static WebDriver driver;
	String Link, Heading, Inside;

	@BeforeClass
	public void initiate() {
		driver = new ChromeDriver();
		Link = "https://demoqa.com/frames";
		driver.get(Link);
		driver.manage().window().maximize();
	}

	@Test
	public void Test01() throws InterruptedException {
		driver.switchTo().frame("frame1");
		WebElement Insideframe = driver.findElement(By.id("sampleHeading"));
		Assert.assertEquals(Insideframe.getText(), "This is a sample page");
		System.out.println("Frame is accesseble successfully");
		driver.switchTo().defaultContent();
		Thread.sleep(4000);

	}

	@Test
	public void Test02() throws InterruptedException {
		WebElement Nested = driver
				.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']/../../..//li[@id='item-3']"));
		System.out.println(Nested.getText());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", Nested);
		Thread.sleep(4000);

		driver.switchTo().frame("frame1");
		WebElement parentFrame = driver.findElement(By.cssSelector("html>body"));
		Assert.assertEquals(parentFrame.getText(), "Parent frame");
		System.out.println(parentFrame.getText());
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[srcdoc*='Child Iframe']")));
		WebElement childFrame = driver.findElement(By.cssSelector("html>body"));
		Assert.assertEquals(childFrame.getText(), "Child frame");
		System.out.println(childFrame.getText());

	}

}

// @Test
// public void Test021() {
// driver.switchTo().frame("#frame2Wrapper #frame2");
// WebElement inside = driver.findElement(By.id("sampleHeading"));
// Inside = inside.getText();
// System.out.println(Inside);
