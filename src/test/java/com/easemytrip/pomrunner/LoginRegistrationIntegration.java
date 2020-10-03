package com.easemytrip.pomrunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.easemytrip.login.LoginPage;
import com.easemytrip.register.CreateAccount;
import com.easemytrip.register.RegisterPage;
import com.easemytrip.utils.Base;

public class LoginRegistrationIntegration extends Base {
	CreateAccount c;
	String otp;
	LoginPage lp;
	WebElement e;
	String user="9051796350";
	String pass="cbi";
	
	
	
	
	@Test(description="Registration And Login Integration Test")
	public void registerAndLoginTestValid() throws Exception  {
		

		driver.get(prop.getProperty("url"));
		RegisterPage fp = new RegisterPage(driver);
		c=fp.register(user, testLog);
		
		
		
	
		testLog.info("Waiting For Create Account Page");
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(prop.getProperty("otpBox"))));
		
		//Assert.assertEquals(driver.findElement(By.xpath(prop.getProperty("otpBox"))).isDisplayed() , true);
		
		testLog.info("Create Account Page visible");
		
		lp=c.pass(otp,pass,pass, testLog);
		
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
					lp.e_username));
			 //Assert.assertEquals(driver.findElement(lp.e_username).isDisplayed(), true); 
					testLog.info("Registration Successful");
					testLog.info("Login Page Visible");
					lp.doLogin1(user, pass, testLog);
					lp.doLogout1();
					System.out.println("Successful login");
//					try {
//						lp.doLogout();
//						Thread.sleep(10000);
//						System.out.println("username: " + user + " password: " + pass);
//						System.out.println("Successful login");
//					} catch (Exception E) {
//						System.out.println("username: " + user + " password: " + pass);
//						System.out.println(" Login Failed");
//						driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[1]/div[1]/div[2]/i")).click();
//					}
//			
//		} catch(Exception E) {
//			if(driver.findElement(By.xpath(prop.getProperty("errorOtp"))).isDisplayed()) {
//				testLog.info("Registration Unsuccessful" );
//				testLog.info("Incorrect OTP");
//				System.out.println("Incorrect OTP");
//			}
//			else if(driver.findElement(By.xpath(prop.getProperty("invalidOtp"))).isDisplayed()) {
//				e=driver.findElement(By.xpath(prop.getProperty("invalidOtp")));
//				String msg=e.getText();
//				testLog.info("Registration Unsuccessful" );
//				testLog.info(msg);
//				System.out.println(msg);
//			}
//			else  {
//				e=driver.findElement(By.xpath(prop.getProperty("errorPass")));
//				testLog.info("Registration Unsuccessful" );
//				testLog.info("Password Mismatch");
//				System.out.println("Password Mismatch");
//				
//			} 
//		} 
//		} catch (Exception E) {
//			testLog.info("Invalid E-mail ID or Phone No.");
//			System.out.println("Invalid E-mail ID or Phone No.");
//		}
//			
//}

	}
}
