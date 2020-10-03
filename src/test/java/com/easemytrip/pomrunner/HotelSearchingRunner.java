package com.easemytrip.pomrunner;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.Alert;

import org.testng.annotations.DataProvider;

import hotelpom.HotelSearchingPage;
import com.easemytrip.utils.Base;
import com.easemytrip.utils.ExcelReader;

public class HotelSearchingRunner extends Base {
	HotelSearchingPage sh;

	@Test(priority = 1, description = "Searching hotel with default values")
	public void SearchHotelDefault() throws IOException, InterruptedException {

		try {
			driver.get(prop.getProperty("searchURL"));

			sh = new HotelSearchingPage(driver);
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

	@DataProvider
	public Object[][] getData() {
		ExcelReader ex = new ExcelReader(prop.getProperty("excelpathSearchHotel"));
		int row = ex.rowNumbers(prop.getProperty("sheetSearchName"));
		Object[][] data = new Object[row - 1][8];
		for (int i = 0; i < row - 1; i++) {
			data[i][0] = ex.readCellData(prop.getProperty("sheetSearchName"), i + 1, 0);
			data[i][1] = ex.getCellDataInt(prop.getProperty("sheetSearchName"), i + 1, 1);
			data[i][2] = ex.readCellData(prop.getProperty("sheetSearchName"), i + 1, 2);
			data[i][3] = ex.getCellDataInt(prop.getProperty("sheetSearchName"), i + 1, 3);
			data[i][4] = ex.readCellData(prop.getProperty("sheetSearchName"), i + 1, 4);
			data[i][5] = ex.getCellDataInt(prop.getProperty("sheetSearchName"), i + 1, 5);
			data[i][6] = ex.getCellDataInt(prop.getProperty("sheetSearchName"), i + 1, 6);
			data[i][7] = ex.getCellDataInt(prop.getProperty("sheetSearchName"), i + 1, 7);
		}
		return data;
	}

	@Test(priority = 2, dataProvider = "getData", description = "Searching hotel with iterative data")
	public void SearchHotelsIter(String cityname, int cindate, String cinmonth, int coutdate, String coutmonth,
			int adultno, int childno, int roomno) throws IOException, InterruptedException {

		try {
			driver.get(prop.getProperty("searchURL"));

			sh = new HotelSearchingPage(driver);
			sh.clickCity().click();
			sh.enterCity().sendKeys(cityname);
			sh.selectCity(cityname);
			sh.selectCheckIn(cinmonth, cindate);
			sh.selectCheckOut(coutmonth, coutdate);
			sh.addAdult(adultno);
			sh.addChild(childno);
			sh.addRoom(roomno);
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
