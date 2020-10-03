package com.easemytrip.pomrunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.easemytrip.login.ForgotPassword;
import com.easemytrip.login.LoginPage;
import com.easemytrip.login.LoginPageOTP;

import com.easemytrip.utils.Base;
import com.easemytrip.utils.ExcelReader;

@Listeners()
public class LoginPageTestInvalid extends Base {

	@Test(priority = 1, dataProvider = "dp", description = "Login by entering username & password")
	public void LoginTest(String user, String pass) throws Exception {
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// global wait
		LoginPage lp = new LoginPage(driver);
		lp.doLogin(user, pass, testLog);
		try {
			lp.doLogout();
			Thread.sleep(10000);
			System.out.println("username: " + user + ", password: " + pass);
			System.out.println("Successful login");
		} catch (Exception E) {
			System.out.println("username: " + user + " password: " + pass);
			System.out.println(" Login Failed");
			driver.findElement(By.xpath("//*[@id=\"divLogin\"]/div[1]/div[1]/div[2]/i")).click();
		}
	}

	@Test(enabled = false, priority = 2, dataProvider = "dp2", description = "Login with forgort password")
	public void LoginTestfp(String mobfp, String pass, String conPass) {
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// global wait
		ForgotPassword fp = new ForgotPassword(driver);
		fp.doLoginfp(mobfp, pass, conPass, testLog);
	}

	@DataProvider
	public Object[][] dp() {

		ExcelReader ex = new ExcelReader(prop.getProperty("excellogin"));
		int rows = ex.rowNumbers("invalidL");
		int col = ex.colNumbers("invalidL");
		System.out.println(rows);
		System.out.println(col);
		Object data[][] = new Object[rows - 1][col];
		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < col; j++) {
				data[i - 1][j] = ex.readCellData("invalidL", i, j);
			}

		}
		return data;
	}

	@DataProvider
	public Object[][] dp2() {

		ExcelReader ex = new ExcelReader(prop.getProperty("excellogin"));
		int rows = ex.rowNumbers("invalidfp");
		int col = ex.colNumbers("invalidfp");

		Object data[][] = new Object[rows - 1][col];
		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < col; j++) {
				data[i - 1][j] = ex.readCellData("invalidfp", i, j);
			}

		}
		return data;
	}

}