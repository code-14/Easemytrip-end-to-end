package com.easemytrip.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public CreateAccount register(String id, ExtentTest log) {
	  log.info("Clicking on my account");
		driver.findElement(By.xpath(prop.getProperty("myAccount"))).click();
		log.info("Clicking on Register Button" );
		
		
		driver.findElement(By.xpath(prop.getProperty("register"))).click();
		log.info("Waiting for Register page to open" );
		log.info("Typing Email ID or Mobile No." );
		driver.findElement(By.xpath(prop.getProperty("input"))).sendKeys(id);
		log.info("E-mail ID or Mobile No. is visisble" );
		log.info("Clicking on Register Button" );
		driver.findElement(By.xpath(prop.getProperty("registerButton"))).click();
		log.info("Waiting for Create Account page to open" );

		return new CreateAccount(driver);
	}
}
