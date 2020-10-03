package com.easemytrip.login;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class ForgotPassword extends BasePage {

	public ForgotPassword(WebDriver driver) {
		super(driver);
	}

	public By e_signinbtn = By.linkText("Sign in");
	public By e_forgotbtn = By.linkText("Forgot Password?");
	public By e_mobfp = By.id("txtEmailMobF");
	public By e_loginfp = By.xpath("//*[@id=\"hidForget\"]/div[1]/div[2]/div[1]/div[7]/input");
	public By e_otpfp = By.id("otptxtF");
	public By e_passfp = By.id("passF");
	public By e_confirmPassfp = By.id("confirmpassF");
	public By e_submitfp = By.xpath("//*[@id=\"hidForget\"]/div[1]/div[2]/div[2]/div[5]/input");

	public void hover() {
		WebElement myaccount = driver.findElement(By.id("spnMyAcc"));
		Actions ac = new Actions(driver);// for working with mouse & keyboard
		ac.moveToElement(myaccount).perform();
	}

	public void clickSignin() {
		driver.findElement(e_signinbtn).click();
	}

	public void forgotPass() {
		driver.findElement(e_forgotbtn).click();
	}

	public void setUserName(String mobfp) {
		driver.findElement(e_mobfp).sendKeys(mobfp);
	}

	public void loginFp() {
		driver.findElement(e_loginfp).click();
	}

	public void setMobOtpfp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP");
		String mobotp = sc.next();
		driver.findElement(e_otpfp).sendKeys(mobotp);
	}

	public void setPassword(String pass) {
		driver.findElement(e_passfp).sendKeys(pass);
	}

	public void setConfirmPassword(String conPass) {
		driver.findElement(e_confirmPassfp).sendKeys(conPass);
	}

	public void clickLoginfp() {
		driver.findElement(e_submitfp).click();
	}

	public void doLoginfp(String mobfp, String pass, String conPass, ExtentTest log) {
		hover();
		log.info("Clicking on Signin btn");
		clickSignin();
		log.info("Clicking on Forgot password option");
		forgotPass();
		log.info("Entering mobile number");
		setUserName(mobfp);
		log.info("Clicking on Login btn");
		loginFp();
	
		  try { Assert.assertEquals(driver.findElement(By.id("otptxtF")).isDisplayed(),true); 
		  }
		  catch(Exception E) 
		  { 
			  System.out.println("Invalid Mobile number");
		  driver.findElement(By.xpath("//*[@id=\"divOTPLOGININT\"]/div[1]/div[1]/div[2]/i"));
		  }
		 
		
		log.info("Entering OTP");
		setMobOtpfp();
		log.info("Entering password");
		setPassword(pass);
		log.info("Re-entering password");
		setConfirmPassword(conPass);
		log.info("Clicking on Login btn");
		clickLoginfp();

	}

}
