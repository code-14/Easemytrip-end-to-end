package hotelpom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import com.easemytrip.utils.BasePage;

public class NewTest extends BasePage {

	public NewTest(WebDriver driver) {
		super(driver);
	}

	public void enterDetails(String email, String contact) {
		WebElement E = driver.findElement(By.xpath(prop.getProperty("pay")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", E);

		driver.findElement(By.id(prop.getProperty("emailid"))).clear();
		driver.findElement(By.id(prop.getProperty("emailid"))).sendKeys(email);

		driver.findElement(By.id(prop.getProperty("contactno"))).clear();
		driver.findElement(By.id(prop.getProperty("contactno"))).sendKeys(contact);

	}

	public void clickCheckBox(ExtentTest log) {

		log.info("Checking T&C checkbox");

		WebElement e = driver.findElement(By.xpath(prop.getProperty("checkbox")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", e);

	}

	public void clickPay(ExtentTest log) {
		log.info("Clicking on Continue to Payment button");
		WebElement e = driver.findElement(By.xpath(prop.getProperty("pay")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", e);
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} else {
			System.out.println("Alert not present");
		}
	}

	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
