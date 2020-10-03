package POM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class FlightSearchPage extends BasePage {

	public FlightSearchPage(WebDriver driver) {
		super(driver);
	}

	public void searchOneWayFlight(String from, String to, ExtentTest log) {

//		log.info("Searching for One Way Tab");
//		driver.findElement(By.xpath("//li[@class='border-lft flig-show click-one bg-color']")).click();
//
//		log.info("Selecting Origin City");
//		WebElement origin = driver.findElement(By.xpath("//input[@id='FromSector_show']"));
//		origin.click();
//		origin.sendKeys(from);
//		driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/div/span[contains(text(),'" + from + "')]")).click();
//
//		log.info("Selecting Destination City");
//		WebElement dest = driver.findElement(By.xpath("//input[@id='Editbox13_show']"));
//		dest.click();
//		dest.sendKeys(to);
//		driver.findElement(By.xpath("//ul[@id='ui-id-2']/li/div/span[contains(text(),'" + to + "')]")).click();
		
		
		log.info("Searching for One Way Tab");
		driver.findElement(By.xpath("//li[@class='border-lft flig-show click-one bg-color']")).click();

		log.info("Selecting Origin City");
		WebElement city1 = driver.findElement(By.xpath("//input[@id='FromSector_show']"));
		city1.click();
		if (from != "") {
			city1.sendKeys(from);
			driver.findElement(By.xpath("//ul[@id='ui-id-1']/li/div/span[contains(text(),'" + from + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}

		log.info("Selecting Destination City");
		WebElement city2 = driver.findElement(By.xpath("//input[@id='Editbox13_show']"));
		city2.click();
		if (to != "") {
			city2.sendKeys(to);
			driver.findElement(By.xpath("//ul[@id='ui-id-2']/li/div/span[contains(text(),'" + to + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}
	}
}
