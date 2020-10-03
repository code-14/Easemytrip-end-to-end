package com.easemytrip.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;
import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public By e_signinbtn = By.linkText("Sign in");
	public By e_username = By.id("txtusername");
	public By e_password = By.id("Password1");
	public By e_loginButton = By.xpath("//*[@id=\"divLogin\"]/div[1]/div[2]/div/div[11]/input");
	public By e_logoutbtn = By.xpath("//a[contains(text(),'Log Out')]");

	public void hover() {
		WebElement myaccount = driver.findElement(By.id("spnMyAcc"));
		Actions ac = new Actions(driver);// for working with mouse & keyboard
		ac.moveToElement(myaccount).perform();

	}

	public void clickSignin() {
		driver.findElement(e_signinbtn).click();
		
	}

	public void setUserName(String user) {
		driver.findElement(e_username).clear();
		driver.findElement(e_username).sendKeys(user);
	}

	public void setPassword(String pass) {
		driver.findElement(e_password).clear();
		driver.findElement(e_password).sendKeys(pass);
	}

	public void clickLogin() {
		driver.findElement(e_loginButton).click();
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

	public void doLogin(String user, String pass, ExtentTest log) throws Exception {
		hover();
		Thread.sleep(1000);
		log.info("Clicking on Signin button");
		clickSignin();
		Thread.sleep(1000);
		log.info("Typing username");
		setUserName(user);
		log.info("Typing password");
		setPassword(pass);
		Thread.sleep(1000);
		log.info("Clicking on Login button");
		clickLogin();
		log.info("Login button clicked");
		// return new WelcomePage(driver);
	}

	
	
	public void doLogout() throws Exception {
		Thread.sleep(10000);
		hoverlogout();
		
		clickLogout();
		clickAlert();

	}
	public void doLogout1() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.id("welcome-det-User")).click();
		//hoverlogout();
		clickLogout();
		clickAlert();

	}
	public void doLogin1(String user, String pass, ExtentTest log) throws Exception {
		//hover();
		//Thread.sleep(1000);
		//log.info("Clicking on Signin button");
		//clickSignin();
		Thread.sleep(1000);
		log.info("Typing username");
		setUserName(user);
		log.info("Typing password");
		setPassword(pass);
		Thread.sleep(1000);
		log.info("Clicking on Login button");
		clickLogin();
		log.info("Login button clicked");
		// return new WelcomePage(driver);
	}
	
	

}
