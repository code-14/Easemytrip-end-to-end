package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class FlightTripSecurePage extends BasePage {

	public FlightTripSecurePage(WebDriver driver) {
		super(driver);
	}

	public void selectSecureTrip(String email, ExtentTest log) {
		log.info("Desired Flight Selected");
		log.info("Scrolling down the page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");

		try {
			WebElement secureFree = driver.findElement(
					By.xpath("//label[contains(text(),'Yes, I want to secure my trip with Free Cancellati')]"));
			if (secureFree.isDisplayed()) {
				log.info("Selecting Yes to Secure the trip With Free Cancellation");
				secureFree.click();
			}
		} catch (Exception E) {
			log.info("Securing Trip with Free Cancellation is not Available");
		}

		try {
			WebElement secureInsur = driver
					.findElement(By.xpath("//label[contains(text(),'Yes, I want to secure my trip with insurance.')]"));
			if (secureInsur.isDisplayed()) {
				log.info("Selecting Yes to Secure the trip With Insurance");
				secureInsur.click();
			}
		} catch (Exception E) {
			log.info("Securing Trip with Insurance is not Available: ");
		}

		new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='con-m']//input[@id='txtEmailId']")));

		log.info("Entering Email Id");
		driver.findElement(By.xpath("//div[@class='con-m']//input[@id='txtEmailId']")).sendKeys(email);
	}

}
