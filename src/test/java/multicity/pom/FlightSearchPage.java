package multicity.pom;

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


	public void searchMultiTripFlightDefault(String from1, String to1,String from2, String to2, ExtentTest log) {

		log.info("Searching for Multi-cityTab");
		driver.findElement(By.xpath("//label[contains(text(),'Multicity Route')]")).click();

		log.info("Selecting departure City 1");
		WebElement city1 = driver.findElement(By.xpath("//input[@id='FromSector-mul1_show']"));
		city1.click();
		if (from1 != "") {
			city1.sendKeys(from1);
			driver.findElement(By.xpath("div[@id = 'FromMulti1']/div/div/ul/div/span[contains(text(),'" + from1 + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}

		log.info("Selecting Destination City 1");
		WebElement city2 = driver.findElement(By.xpath("//input[@id='ToSector-mul1_show']']"));
		city2.click();
		if (to1 != "") {
			city2.sendKeys(to1);
			driver.findElement(By.xpath("div[@id = 'ToMulti1']/div/div/ul/div/span[contains(text(),'" + to1 + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}
		
		

		log.info("Selecting departure City 2");
		WebElement city3 = driver.findElement(By.xpath("//input[@id='FromSector-mul2_show']"));
		city1.click();
		if (from1 != "") {
			city1.sendKeys(from2);
			driver.findElement(By.xpath("div[@id = 'FromMulti2']/div/div/ul/div/span[contains(text(),'" + from2 + "')]")).click();
		} /*else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}*/

		log.info("Selecting Destination City 2");
		WebElement city4 = driver.findElement(By.xpath("//input[@id='ToSector-mul2_show']']"));
		city2.click();
		if (to1 != "") {
			city2.sendKeys(to1);
			driver.findElement(By.xpath("div[@id = 'ToMulti2']/div/div/ul/div/span[contains(text(),'" + to2 + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}
	}
	
	
	public void searchMultiTripFlightAddCity(String from1, String to1,String from2, String to2,String from3, String to3, ExtentTest log) {

		log.info("Searching for Multi-cityTab");
		driver.findElement(By.xpath("//label[contains(text(),'Multicity Route')]")).click();

		log.info("Selecting departure City 1");
		WebElement city1 = driver.findElement(By.xpath("//input[@id='FromSector-mul1_show']"));
		city1.click();
		if (from1 != "") {
			city1.sendKeys(from1);
			driver.findElement(By.xpath("div[@id = 'FromMulti1']/div/div/ul/div/span[contains(text(),'" + from1 + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}

		log.info("Selecting Destination City 1");
		WebElement city2 = driver.findElement(By.xpath("//input[@id='ToSector-mul1_show']']"));
		city2.click();
		if (to1 != "") {
			city2.sendKeys(to1);
			driver.findElement(By.xpath("div[@id = 'ToMulti1']/div/div/ul/div/span[contains(text(),'" + to1 + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}
		
		

		log.info("Selecting departure City 2");
		WebElement city3 = driver.findElement(By.xpath("//input[@id='FromSector-mul2_show']"));
		city1.click();
		if (from1 != "") {
			city1.sendKeys(from2);
			driver.findElement(By.xpath("div[@id = 'FromMulti2']/div/div/ul/div/span[contains(text(),'" + from2 + "')]")).click();
		} /*else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}*/

		log.info("Selecting Destination City 2");
		WebElement city4 = driver.findElement(By.xpath("//input[@id='ToSector-mul2_show']']"));
		city2.click();
		if (to1 != "") {
			city2.sendKeys(to1);
			driver.findElement(By.xpath("div[@id = 'ToMulti2']/div/div/ul/div/span[contains(text(),'" + to2 + "')]")).click();
		} else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}
		
		log.info("Selecting departure City 3");
		WebElement city5 = driver.findElement(By.xpath("//input[@id='FromSector-mul3_show']"));
		city1.click();
		if (from1 != "") {
			city1.sendKeys(from3);
			driver.findElement(By.xpath("div[@id = 'FromMulti3']/div/div/ul/div/span[contains(text(),'" + from3 + "')]")).click();
		} /*else {
			driver.findElement(By.xpath("//div[@class='mobile-wi1 flig-show1']//input[@class='src_btn']")).click();
			Alert alert = driver.switchTo().alert();
			new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
			log.info(alert.getText());
			alert.accept();
			throw new AssertionError("Flight Searching Test Failed");
		}*/

		log.info("Selecting Destination City 3");
		WebElement city6 = driver.findElement(By.xpath("//input[@id='ToSector-mul3_show']']"));
		city2.click();
		if (to1 != "") {
			city2.sendKeys(to3);
			driver.findElement(By.xpath("div[@id = 'ToMulti3']/div/div/ul/div/span[contains(text(),'" + to3 + "')]")).click();
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
