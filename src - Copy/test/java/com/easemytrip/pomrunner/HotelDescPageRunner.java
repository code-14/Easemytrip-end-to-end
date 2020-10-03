package com.easemytrip.pomrunner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import hotelpom.HotelDescPage;
import com.easemytrip.utils.Base;

public class HotelDescPageRunner extends Base {
	HotelDescPage hd;

	@Test(priority = 1, description = "Show Amenities button Test")
	public void clickAmenities() throws Exception {

		driver.get(prop.getProperty("hoteldescURL"));
		hd = new HotelDescPage(driver);
		hd.scrollReviewCheck(testLog);
		hd.checkAmenities(testLog);
		boolean amcheck = driver.findElement(By.linkText("Hide All Amenities")).isDisplayed();
		if (amcheck == true) {
			System.out.println("Show amenities button test in hotel description page passed");
		} else {
			System.out.println("Show amenities button test in hotel description page failed");
		}
	}

	@Test(priority = 2, description = "Book now button Test")
	public void clickBookNow() throws InterruptedException {

		hd.hotelDescBookNow(testLog);

		String Actual = driver.getTitle();
		String Expected = "Traveller Detail";
		if (Actual.equalsIgnoreCase(Expected)) {
			System.out.println("Booking hotel button test from hotel description page passed");
		} else {
			System.out.println("Booking hotel buttton test from hotel description page passed");
		}
	}
}
