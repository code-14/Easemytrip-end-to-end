package com.easemytrip.login;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;



public class LoginPageOTP extends BasePage {

	public LoginPageOTP(WebDriver driver) {
		super(driver);
	}
	
	public By e_signinbtn =By.linkText("Sign in");
	public By e_signinotp =By.id("otpbx");
	public By e_mobotp =By.id("txtMobileOTP");
	public By e_loginotp = By.xpath("//*[@id=\"divOTPLOGININT\"]/div[1]/div[2]/div/div[5]/input");
	public By e_otp =By.id("txtMobOTP");
	public By e_login2otp = By.xpath("//*[@id=\"divEnterOTP\"]/div[1]/div[2]/div[2]/div[8]/input");
	public By e_logoutbtn = By.linkText("Log Out");
	
	public void hover() {
		WebElement myaccount= driver.findElement(By.id("spnMyAcc"));
		Actions ac = new Actions(driver);//for working with mouse & keyboard
		ac.moveToElement(myaccount).perform();
		
	}
	
	 public void clickSignin() {
	        driver.findElement(e_signinbtn).click();
	}
	 public void clickSigninotp() {
	        driver.findElement(e_signinotp).click();
	}
	 public void setMobile(String mob) {
	        driver.findElement(e_mobotp).sendKeys(mob);
	}
	 public void clickLoginotp() {
	        driver.findElement(e_loginotp).click();
	}
	//cond
    public void setMobOtp() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter OTP");
    	String mobotp=sc.next();
        driver.findElement(e_otp).sendKeys(mobotp);
    }
    
    public void clickLogin2otp() {
        driver.findElement(e_login2otp).click();
    }
    public void hoverlogout() {
		WebElement logaccount = driver.findElement(By.id("welcome-det-User"));
		Actions ac = new Actions(driver);// for working with mouse & keyboard
		ac.moveToElement(logaccount).perform();

	}

	public void clickLogout() {
		driver.findElement(e_logoutbtn).click();
	}

	public void clickAlert() {
		driver.switchTo().alert().accept();
	}
    
    public void doLoginOtp(String mob, ExtentTest log ) throws Exception {
    	hover();
    	log.info("Clicking on signin btn");
    	Thread.sleep(1000);
    	clickSignin();
    	log.info("Clicking on signin with OTP");
    	clickSigninotp();
    	log.info("Entering mobile number");
    	Thread.sleep(1000);
    	setMobile(mob);
    	log.info("Clicking on login otp");
    	Thread.sleep(1000);
    	clickLoginotp();
    	
    	//Assert.assertEquals(driver.findElement(By.id("txtMobOTP")).isDisplayed(), true);
		/*
		 * try {
		 * 
		 * }catch(Exception E) { System.out.println("Invalid Mobile number");
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"divOTPLOGININT\"]/div[1]/div[1]/div[2]/i")); }
		 */
    	log.info("Entering OTP");
    	Thread.sleep(10000);
    	setMobOtp();
    	Thread.sleep(1000);
    	clickLogin2otp();
    	
    	
        //return new WelcomePage(driver);
    }
	
    public void doLogout() throws Exception {
		Thread.sleep(10000);
		hoverlogout();
		Thread.sleep(10000);
		clickLogout();
		clickAlert();

	}
	
}
