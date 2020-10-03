package com.easemytrip.pomrunner;

import java.io.IOException;
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import hotelpom.HotelSearchingPage;
import com.easemytrip.utils.Base;

public class HotelIntegrationTest extends Base {

	@Test(description = "Booking hotel integration Test")
	public void bookingHotelIntegration() throws IOException, InterruptedException {

		try {
			driver.get(prop.getProperty("searchURL"));

			HotelSearchingPage sh = new HotelSearchingPage(driver);
			sh.clickSearch().click();
			Alert a = driver.switchTo().alert();
			Thread.sleep(2000);
			a.accept();
			driver.switchTo().defaultContent();
			driver.findElement(By.cssSelector(prop.getProperty("hotellist"))).click();
			HotelTravDetailsPageRunner hd = new HotelTravDetailsPageRunner();
			hd.selectingTitle();
			hd.dp();
			hd.checkTc();
			hd.clickPayment();

		} catch (Exception e) {
			System.out.println("Booking hotel integration not successful");
		}

	}
}
