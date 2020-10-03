package hotelpom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import com.easemytrip.utils.BasePage;

public class HotelTravDetailsPage extends BasePage {

	public HotelTravDetailsPage(WebDriver driver) {
		super(driver);
	}

	public void selectTitle1(ExtentTest log) {
		log.info("Selecting title for traveller 1");
		WebElement s = driver.findElement(By.name(prop.getProperty("travellertitle1")));
		Select title = new Select(s);
		title.selectByValue(prop.getProperty("title1"));
		log.info("Title 1 selected");
	}

	public void selectTitle2(ExtentTest log) {
		log.info("Selecting title for traveller 2");
		WebElement s = driver.findElement(By.name(prop.getProperty("travellertitle2")));
		Select title = new Select(s);
		title.selectByValue(prop.getProperty("title2"));
		log.info("Title 2 selected");
	}

	public void enterDetails(String fname, String lname, String fname2, String lname2, String email, String contact) {
		WebElement E = driver.findElement(By.xpath(prop.getProperty("pay")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", E);
		driver.findElement(By.id(prop.getProperty("firstname"))).clear();
		driver.findElement(By.id(prop.getProperty("firstname"))).sendKeys(fname);

		driver.findElement(By.id(prop.getProperty("lastname"))).clear();
		driver.findElement(By.id(prop.getProperty("lastname"))).sendKeys(lname);

		driver.findElement(By.id(prop.getProperty("firstname2"))).clear();
		driver.findElement(By.id(prop.getProperty("firstname2"))).sendKeys(fname2);

		driver.findElement(By.id(prop.getProperty("lastname2"))).clear();
		driver.findElement(By.id(prop.getProperty("lastname2"))).sendKeys(lname2);

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