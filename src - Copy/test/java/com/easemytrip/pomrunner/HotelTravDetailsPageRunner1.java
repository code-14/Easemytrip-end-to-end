package com.easemytrip.pomrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import hotelpom.HotelTravDetailsPage;
import com.easemytrip.utils.Base;

public class HotelTravDetailsPageRunner1 extends Base {
	HotelTravDetailsPage ht;

	@Test(priority = 1, description = "Clicking payment button only in traveller details page Test")
	public void clickPayButton() {
		try {
		driver.get(prop.getProperty("travdetailsURL"));
		ht = new HotelTravDetailsPage(driver);
		WebElement E = driver.findElement(By.xpath(prop.getProperty("pay")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", E);
		ht.clickPay(testLog);
		}
		catch (Exception E) {
			throw new AssertionError("Clicking payment button only Test Failed");
		}
	}

	@Test(priority = 2, description = "Entering incomplete traveller details, check T&C & clicking on pay Test")
	public void incompleteDetails() {
		try {
		WebElement E = driver.findElement(By.xpath(prop.getProperty("pay")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", E);
		ht.clickCheckBox(testLog);
		ht.clickPay(testLog);
		}
		catch (Exception E) {
			throw new AssertionError("Checking T&C & Payment button click Failed");
		}
	}
}
