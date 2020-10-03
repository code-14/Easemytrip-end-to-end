package com.easemytrip.pomrunner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.easemytrip.POM.FlightSearchPage;
import com.easemytrip.POM.FlightSelectPage;
import com.easemytrip.POM.FlightTripSecurePage;
import com.easemytrip.POM.SetPersonalDetails;
import com.easemytrip.POM.TravelDate;
import com.easemytrip.utils.Base;
import com.easemytrip.utils.ExcelReader;

public class FlightSearchTest extends Base {
	@Test(enabled = false, description = "Testing Flight Searching", dataProvider = "dpModule")
	public void flightSearch(String origin, String dest, String dday, String dmonth, String dyear, String rday,
			String rmonth, String ryear, String travelClass) throws Exception {
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		FlightSearchPage sp = new FlightSearchPage(driver);
		sp.searchRoundTripFlight(origin, dest, testLog);

		TravelDate Date = new TravelDate(driver);
		Date.setTravelDate(dday, dmonth, dyear, rday, rmonth, ryear, testLog);

		driver.findElement(By.xpath("//span[@class='optclass-name']")).click();
		driver.findElement(By.xpath("//div[@id='myDropdown_n9']//div//label[contains(text(),'" + travelClass + "')]"))
				.click();
		driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();

		if (!(origin.equals(dest))) {
			try {
				WebElement msg = driver.findElement(
						By.xpath("//span[contains(text(),'There were no flights found for this date & route')]"));
				new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(msg));
				testLog.info(msg.getText());
				driver.findElement(By.xpath(
						"//div[@id='divFltNotFound']//div//div//a[contains(text(),'Modify Search & Try Again')]"))
						.click();
				throw new AssertionError("Flight Booking Test Failed");
			} catch (Exception E) {
				new WebDriverWait(driver, 20)
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DivOut0']")));
			}
		} else {
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			testLog.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}
	}

	@DataProvider
	public Object[][] dpModule() {
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\files\\RoundTrip.xlsx");
		int rows = excel.rowNumbers(prop.getProperty("sheetNameM"));
		int col = excel.colNumbers(prop.getProperty("sheetNameM"));
		Object data[][] = new Object[rows - 1][col];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = excel.readCellData(prop.getProperty("sheetNameM"), i + 1, j);
			}
		}
		return data;
	}

	@Test(enabled = true, description = "Complete Testing of Flight Booking - till Payment", dataProvider = "dpEndTOEnd")
	public void flightBookCompleteTest(String origin, String dest, String dday, String dmonth, String dyear,
			String rday, String rmonth, String ryear, String travelClass, String sname, String fname, String lname,
			String email, String mobile) {
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		FlightSearchPage search = new FlightSearchPage(driver);
		search.searchRoundTripFlight(origin, dest, testLog);

		TravelDate Date = new TravelDate(driver);
		Date.setTravelDate(dday, dmonth, dyear, rday, rmonth, ryear, testLog);

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
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\files\\RoundTrip.xlsx");
		int rows = excel.rowNumbers(prop.getProperty("sheetNameE"));
		int col = excel.colNumbers(prop.getProperty("sheetNameE"));
		Object data[][] = new Object[rows - 1][col];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = excel.readCellData(prop.getProperty("sheetNameE"), i + 1, j);
			}
		}
		return data;
	}

}