package com.easemytrip.pomrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.easemytrip.utils.Base;

import hotelpom.NewTest;

public class TestRunner extends Base {
	NewTest ht;

	/*
	 * @Test(priority = 1, description = "Entering traveller details Test") public
	 * void enteringDetails() { driver.get(prop.getProperty("travdetailsURL")); ht =
	 * new NewTest(driver); ht.enterDetails("Prerna@gmail.com", "9988989898");
	 * ht.clickCheckBox(testLog); ht.clickPay(testLog);
	 * 
	 * }
	 * 
	 * @Test(priority = 2, description = "Clicking payment button only Test") public
	 * void clickPayButton() {
	 * 
	 * ht.clickPay(testLog);
	 * 
	 * }
	 */

	@Test(priority = 3, description = "Entering incomplete traveller details, check T&C & clicking on pay Test")
	public void incompleteDetails() {
		driver.get(prop.getProperty("travdetailsURL"));
		ht = new NewTest(driver);
		ht.clickCheckBox(testLog);
		WebElement e = driver.findElement(By.xpath(prop.getProperty("checkbox")));
		Assert.assertEquals(e.isSelected(), true);

	}
}
