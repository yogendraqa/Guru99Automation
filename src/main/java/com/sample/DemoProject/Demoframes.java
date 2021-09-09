package com.sample.DemoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Demoframes {
	static WebDriver driver;
	String Link;
	
	@BeforeClass
	public void initiate() {
		driver = new ChromeDriver();
		Link = "https://demoqa.com/frames";
		driver.get(Link);
	}

}
