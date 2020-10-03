package com.easemytrip.register;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.login.LoginPage;
import com.easemytrip.utils.BasePage;

public class CreateAccount extends BasePage {
	public CreateAccount(WebDriver driver) {
		super(driver);
	}


	Scanner in=new Scanner(System.in);
	public LoginPage pass(String otp, String pass, String cpass, ExtentTest log ) {
		System.out.println("Enter OTP");
		log.info("Waiting for OTP");
		otp=in.next();
		log.info("OTP given");
		//System.out.println("Enter Password");
		log.info("Waiting for Password");
		//pass=in.next();
		log.info("Password given");
		//System.out.println("Re-Enter Password");
		log.info("Waiting for Password to be re-entered");
		//cpass=in.next();
		log.info("Password re-entered");
		
		//WebDriverWait wt=new WebDriverWait(driver,30);
		log.info("Entering OTP");
		driver.findElement(By.xpath(prop.getProperty("otpBox"))).sendKeys(otp);
		log.info("OTP entered");
		//wt.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(prop.getProperty("otpBox")), otp));
		log.info("Entering Password");
		driver.findElement(By.xpath(prop.getProperty("enterPass"))).sendKeys(pass);
		log.info("Password Entered");
		log.info("Re-Entering Password");
		driver.findElement(By.xpath(prop.getProperty("confirmPass"))).sendKeys(cpass);
		log.info("Re-Entered Password");
		log.info("Clicking Submit");
		driver.findElement(By.xpath(prop.getProperty("submitButton"))).click();
		log.info("Submit Clicked");
		return new LoginPage(driver);
		
	}

}
