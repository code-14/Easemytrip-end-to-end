package com.easemytrip.pomrunner;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import hotelpom.HotelSearchingPage;
import com.easemytrip.utils.Base;

public class HotelSearchingRunner1 extends Base {
	HotelSearchingPage sh;

	@Test(priority = 1, description = "Searching hotel with same check-in and check-out date")
	public void SearchHotelsSameCC() throws IOException, InterruptedException {

		try {
			driver.get(prop.getProperty("searchURL"));

			sh = new HotelSearchingPage(driver);
			sh.clickCity().click();
			sh.enterCity().sendKeys(prop.getProperty("cityname"));
			sh.selectCity(prop.getProperty("cityname"));
			String inmonth = prop.getProperty("cinmonth");
			int indate = Integer.parseInt(prop.getProperty("cindate"));
			sh.selectCheckIn(inmonth, indate);
			sh.selectCheckOut((prop.getProperty("coutmonth")), (Integer.parseInt(prop.getProperty("coutdate"))));
			sh.addAdult(Integer.parseInt(prop.getProperty("adultno")));
			sh.clickSearch().click();
			String Actual = driver.getTitle();
			String Expected = "Hotel List";

			if (Actual.equalsIgnoreCase(Expected)) {
				System.out.println("Search hotel test passed");
			} else {
				System.out.println("Search hotel test failed");
			}
			Alert a = driver.switchTo().alert();
			Thread.sleep(2000);
			a.accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}

	}

	@Test(priority = 2, description = "Searching hotel with empty city name field")
	public void SearchHotelEmpCity() throws IOException, InterruptedException {

		try {

			sh.clickCity().click();
			sh.selectCheckIn(prop.getProperty("cinmonth"), Integer.parseInt(prop.getProperty("cindate")));
			sh.selectCheckOut((prop.getProperty("coutmonth")), (Integer.parseInt(prop.getProperty("coutdate"))));
			sh.addAdult(Integer.parseInt(prop.getProperty("adultno")));
			sh.clickSearch().click();
			String Actual = driver.getTitle();
			String Expected = "Hotel List";

			if (Actual.equalsIgnoreCase(Expected)) {
				System.out.println("Search hotel test passed");
			} else {
				System.out.println("Search hotel test failed");
			}
			Alert a = driver.switchTo().alert();
			Thread.sleep(2000);
			a.accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}

	}
}
