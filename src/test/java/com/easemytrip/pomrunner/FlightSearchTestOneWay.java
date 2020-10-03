package com.easemytrip.pomrunner;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.FlightSearchPage;
import POM.FlightSelectPage;
import POM.FlightTripSecurePage;
import POM.SetPersonalDetails;
import POM.TravelDate;
import com.easemytrip.utils.Base;
import com.easemytrip.utils.ExcelReader;

public class FlightSearchTestOneWay extends Base {
	
	@Test(enabled = true, description = "Testing Flight Searching", dataProvider = "dp")
	public void flightSearch(String origin, String dest, String dday, String dmonth, String dyear, String travelClass, String sname, String fname, String lname,
			String email, String mobile) throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		FlightSearchPage sp = new FlightSearchPage(driver);
		sp.searchOneWayFlight(origin, dest, testLog);

		TravelDate Date = new TravelDate(driver);
		Date.setTravelDate(dday, dmonth, dyear, testLog);

		driver.findElement(By.xpath("//span[@class='optclass-name']")).click();
		driver.findElement(By.xpath("//div[@id='myDropdown_n9']//div//label[contains(text(),'" + travelClass + "')]"))
				.click();
		driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();

			if (!(origin.equals(dest))) {
				FlightSelectPage find = new FlightSelectPage(driver);
				find.chooseFlight(testLog);

				FlightTripSecurePage secure = new FlightTripSecurePage(driver);
				secure.selectSecureTrip(email, testLog);

				SetPersonalDetails details = new SetPersonalDetails(driver);
				details.setDetails(sname, fname, lname, mobile, testLog);

				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[@id='card']//div[@class='mk-pym'][contains(text(),'Make Payment')]")));

				} catch (Exception E) {
					throw new AssertionError("Flight Booking Test Failed");
				}
				} else {
					System.out.println("hi");
				Alert alert = driver.switchTo().alert();
				new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
				testLog.info(alert.getText());
				alert.accept();
				throw new AssertionError("Flight Searching Test Failed");
			}
	}

	@DataProvider
	public Object[][] dp() {
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\files\\OneWay.xlsx");
		int rows = excel.rowNumbers(prop.getProperty("sheetName1"));
		int col = excel.colNumbers(prop.getProperty("sheetName1"));
		Object data[][] = new Object[rows - 1][col];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = excel.readCellData(prop.getProperty("sheetName1"), i+1, j);
			}
		}
		return data;
	}

	@Test(enabled = false, description = "Complete Testing of Flight Booking - till Payment", dataProvider = "dpEndTOEnd")
	public void flightBookCompleteTest(String origin, String dest, String dday, String dmonth, String dyear, String travelClass, String sname, String fname, String lname,
			String email, String mobile) {
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		FlightSearchPage search = new FlightSearchPage(driver);
		search.searchOneWayFlight(origin, dest, testLog);

		TravelDate Date = new TravelDate(driver);
		Date.setTravelDate(dday, dmonth, dyear, testLog);

		driver.findElement(By.xpath("//span[@class='optclass-name']")).click();
		driver.findElement(By.xpath("//div[@id='myDropdown_n9']//div//label[contains(text(),'" + travelClass + "')]"))
				.click();
		driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();

		FlightSelectPage find = new FlightSelectPage(driver);
		find.chooseFlight(testLog);

		FlightTripSecurePage secure = new FlightTripSecurePage(driver);
		secure.selectSecureTrip(email, testLog);

		SetPersonalDetails details = new SetPersonalDetails(driver);
		details.setDetails(sname, fname, lname, mobile, testLog);

		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@id='card']//div[@class='mk-pym'][contains(text(),'Make Payment')]")));

		} catch (Exception E) {
			throw new AssertionError("Flight Booking Test Failed");
		}
	}

	@DataProvider
	public Object[][] dpEndTOEnd() {
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\files\\OneWay.xlsx");
		int rows = excel.rowNumbers(prop.getProperty("sheetNameEnd"));
		int col = excel.colNumbers(prop.getProperty("sheetNameEnd"));
		Object data[][] = new Object[rows - 1][col];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = excel.readCellData(prop.getProperty("sheetNameEnd"), i+1, j);
			}
		}
		return data;
	}

}