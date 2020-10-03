package com.easemytrip.pomrunner;

import org.testng.annotations.Test;

import hotelpom.HotelListingPage;
import com.easemytrip.utils.Base;

public class HotelListingPageRunner extends Base {
	HotelListingPage hl;

	@Test(priority = 1, description = "Hotel Listing page Checkbox Test")
	public void checkboxTest() throws Exception {

		try {
			driver.get(prop.getProperty("HotelListURL"));
			hl = new HotelListingPage(driver);
			hl.checkStarRating(testLog);
			Thread.sleep(4000);
		} catch (Exception E) {
			throw new AssertionError("Checkbox not selected");
		}
	}

	@Test(priority = 2, description = "Hotel listing page Sortby dropdown Test")
	public void dropdownTest() throws Exception {

		try {
			hl.checkSortBy(testLog);
			Thread.sleep(4000);
		} catch (Exception E) {
			throw new AssertionError("Sorting not done");
		}

	}

	@Test(priority = 3, description = "Hotel listing page Button Test")
	public void buttonTest() throws Exception {

		try {

			hl.clickButton(testLog);

		} catch (Exception E) {
			throw new AssertionError("Buttons not clicked");
		}
	}

}
