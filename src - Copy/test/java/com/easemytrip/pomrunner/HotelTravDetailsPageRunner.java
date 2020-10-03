package com.easemytrip.pomrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hotelpom.HotelTravDetailsPage;
import com.easemytrip.utils.*;

public class HotelTravDetailsPageRunner extends Base {
	HotelTravDetailsPage ht;

	@Test(priority = 1, description = "Selecting title from dropdown Test in traveller details page")
	public void selectingTitle() {

		try {
			driver.get(prop.getProperty("travdetailsURL"));
			ht = new HotelTravDetailsPage(driver);
			ht.selectTitle1(testLog);
			ht.selectTitle2(testLog);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.name("ddlGender")));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.name("ddlGender2")));
		} catch (Exception E) {
			throw new AssertionError("Selecting traveller Title Failed");
		}
	}

	@DataProvider
	public Object[][] dp() {
		ExcelReader ex = new ExcelReader((prop.getProperty("excelpathtraveller")));
		int row = ex.rowNumbers(prop.getProperty("sheetnametraveller"));

		Object[][] data = new Object[row - 1][6];
		for (int i = 0; i < row - 1; i++) {
			data[i][0] = ex.readCellData(prop.getProperty("sheetnametraveller"), i + 1, 0);
			data[i][1] = ex.readCellData(prop.getProperty("sheetnametraveller"), i + 1, 1);
			data[i][2] = ex.readCellData(prop.getProperty("sheetnametraveller"), i + 1, 2);
			data[i][3] = ex.readCellData(prop.getProperty("sheetnametraveller"), i + 1, 3);
			data[i][4] = ex.readCellData(prop.getProperty("sheetnametraveller"), i + 1, 4);
			data[i][5] = ex.readCellData(prop.getProperty("sheetnametraveller"), i + 1, 5);
		}
		return data;
	}

	@Test(priority = 2, dataProvider = "dp", description = "Entering traveller detailsTest")
	public void enteringDetails(String fname, String lname, String fname2, String lname2, String email,
			String contact) {
		try {
			ht.enterDetails(fname, lname, fname2, lname2, email, contact);

		} catch (Exception E) {
			throw new AssertionError("Entering travel details Failed");
		}
	}

	@Test(priority = 3, description = "Checking T&C checkbox Test")
	public void checkTc() {
		try {

			ht.clickCheckBox(testLog);
			WebElement e = driver.findElement(By.xpath(prop.getProperty("checkbox")));
			Assert.assertEquals(true, e.isSelected());
		} catch (Exception E) {
			throw new AssertionError("T&C check Test Failed");
		}
	}

	@Test(priority = 4, description = "Clicking Payment button Test")
	public void clickPayment() {
		try {

			ht.clickPay(testLog);
			WebElement E = driver.findElement(By.linkText(prop.getProperty("paysuccess")));
			Assert.assertEquals(true, E.isDisplayed());
		} catch (Exception E) {
			throw new AssertionError("Clicking payment button Test Failed");
		}
	}
}
