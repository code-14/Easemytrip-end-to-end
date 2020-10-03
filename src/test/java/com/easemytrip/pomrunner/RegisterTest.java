package com.easemytrip.pomrunner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.easemytrip.register.CreateAccount;
import com.easemytrip.login.LoginPage;
import com.easemytrip.register.RegisterPage;
import com.easemytrip.utils.Base;
import com.easemytrip.utils.ExcelReader;

@Listeners()
public class RegisterTest extends Base {
	CreateAccount c;
	String otp;
	LoginPage lp;
	WebElement e;
	@Test(dataProvider="dp1", description="Registraion Test with valid details")
	public void registerTestValid(String username, String pass, String pass1)  {
		System.out.println(username);

		driver.get(prop.getProperty("url"));
		RegisterPage fp = new RegisterPage(driver);
		c=fp.register(username, testLog);
		
		
		try {
	
		testLog.info("Waiting For Create Account Page");
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(prop.getProperty("otpBox"))));
		
		Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("otpBox"))).isDisplayed() , true);
		
		testLog.info("Create Account Page visible");
		try {
		lp=c.pass(otp,pass,pass1, testLog);
		
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
					lp.e_username));
			 Assert.assertEquals(driver.findElement(lp.e_username).isDisplayed(), true); 
					testLog.info("Registration Successful");
					testLog.info("Login Page Visible");
			
		} catch(Exception E) {
			if(driver.findElement(By.xpath(prop.getProperty("errorOtp"))).isDisplayed()) {
				testLog.info("Registration Unsuccessful" );
				testLog.info("Incorrect OTP");
				System.out.println("Incorrect OTP");
			}
			else if(driver.findElement(By.xpath(prop.getProperty("invalidOtp"))).isDisplayed()) {
				e=driver.findElement(By.xpath(prop.getProperty("invalidOtp")));
				String msg=e.getText();
				testLog.info("Registration Unsuccessful" );
				testLog.info(msg);
				System.out.println(msg);
			}
			else  {
				e=driver.findElement(By.xpath(prop.getProperty("errorPass")));
				testLog.info("Registration Unsuccessful" );
				testLog.info("Password Mismatch");
				System.out.println("Password Mismatch");
				
			} 
		} 
		} catch (Exception E) {
			testLog.info("Invalid E-mail ID or Phone No.");
			System.out.println("Invalid E-mail ID or Phone No.");
		}
			
}
	

	
	@Test(dataProvider="dp2", dependsOnMethods="registerTestValid", description="Registration Test with Invalid Details")
	public void registerTestInvalid(String username, String pass, String pass1)  {
		System.out.println(username);

		driver.get(prop.getProperty("url"));
		RegisterPage fp = new RegisterPage(driver);
		c=fp.register(username, testLog);
		
		
		try {
	
		testLog.info("Waiting For Create Account Page");
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(prop.getProperty("otpBox"))));
		
		Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("otpBox"))).isDisplayed() , true);
		
		testLog.info("Create Account Page visible");
		try {
		lp=c.pass(otp,pass,pass1, testLog);
		
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
					lp.e_username));
			 Assert.assertEquals(driver.findElement(lp.e_username).isDisplayed(), true); 
					testLog.info("Registration Successful");
					testLog.info("Login Page Visible");
			
		} catch(Exception E) {
			if(driver.findElement(By.xpath(prop.getProperty("errorOtp"))).isDisplayed()) {
				testLog.info("Registration Unsuccessful" );
				testLog.info("Incorrect OTP");
				System.out.println("Incorrect OTP");
			}
			else if(driver.findElement(By.xpath(prop.getProperty("invalidOtp"))).isDisplayed()) {
				e=driver.findElement(By.xpath(prop.getProperty("invalidOtp")));
				String msg=e.getText();
				testLog.info("Registration Unsuccessful" );
				testLog.info(msg);
				System.out.println(msg);
			}
			else  {
				e=driver.findElement(By.xpath(prop.getProperty("errorPass")));
				testLog.info("Registration Unsuccessful" );
				testLog.info("Password Mismatch");
				System.out.println("Password Mismatch");
				
			} 
		} 
		} catch (Exception E) {
			testLog.info("Invalid E-mail ID or Phone No.");
			System.out.println("Invalid E-mail ID or Phone No.");
		}
			
	}
	@Test(dataProvider="dp3", dependsOnMethods="registerTestInvalid", description="Registration Test With Password Mismatch")
	public void registerTestInvalidPassword(String username, String pass, String pass1)  {
		System.out.println(username);

		driver.get(prop.getProperty("url"));
		RegisterPage fp = new RegisterPage(driver);
		c=fp.register(username, testLog);
		
		
		try {
	
		testLog.info("Waiting For Create Account Page");
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(prop.getProperty("otpBox"))));
		
		Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("otpBox"))).isDisplayed() , true);
		
		testLog.info("Create Account Page visible");
		try {
		lp=c.pass(otp,pass,pass1, testLog);
		
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
					lp.e_username));
			 Assert.assertEquals(driver.findElement(lp.e_username).isDisplayed(), true); 
					testLog.info("Registration Successful");
					testLog.info("Login Page Visible");
			
		} catch(Exception E) {
			if(driver.findElement(By.xpath(prop.getProperty("errorOtp"))).isDisplayed()) {
				testLog.info("Registration Unsuccessful" );
				testLog.info("Incorrect OTP");
				System.out.println("Incorrect OTP");
			}
			else if(driver.findElement(By.xpath(prop.getProperty("invalidOtp"))).isDisplayed()) {
				e=driver.findElement(By.xpath(prop.getProperty("invalidOtp")));
				String msg=e.getText();
				testLog.info("Registration Unsuccessful" );
				testLog.info(msg);
				System.out.println(msg);
			}
			else  {
				e=driver.findElement(By.xpath(prop.getProperty("errorPass")));
				testLog.info("Registration Unsuccessful" );
				testLog.info("Password Mismatch");
				System.out.println("Password Mismatch");
				
			} 
		} 
		} catch (Exception E) {
			testLog.info("Invalid E-mail ID or Phone No.");
			System.out.println("Invalid E-mail ID or Phone No.");
		}
			
}
	 @DataProvider 
	  public Object[][] dp1(){
		  
		  Object[][] data=new Object[2][3];
		  data[0][0]="9051796350";
		  data[0][1]="abf";
		  data[0][2]="abf";
		  data[1][0]="ananda.ce97@gmail.com";
		  data[1][1]="cbi";
		  data[1][2]="cbi";
		  return data;
	  }
	 @DataProvider 
	  public Object[][] dp2(){
		  ExcelReader ex=new ExcelReader(prop.getProperty("excelPath"));
		  int rows=ex.rowNumbers(prop.getProperty("sheetName"));
		  int col=ex.colNumbers(prop.getProperty("sheetName"));
		  Object[][] data=new Object[rows-1][col];
		  for(int i=0;i<data.length;i++) {
			  for(int j=0;j<col;j++) {
				  data[i][j]=ex.readCellData(prop.getProperty("sheetName"), i+1, j);
			  }
		  }
		  return data;
	  }
	 @DataProvider 
	  public Object[][] dp3(){
		  
		  Object[][] data=new Object[2][3];
		  data[0][0]="9051796350";
		  data[0][1]="abf";
		  data[0][2]="abd";
		  data[1][0]="ananda.ce97@gmail.com";
		  data[1][1]="cbi";
		  data[1][2]="cbf";
		  return data;
	}
	 
}





