package hotelpom;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;



public class HotelListingPage extends BasePage {

	public HotelListingPage(WebDriver driver) {
		super(driver);
	}

	public void checkStarRating(ExtentTest log) throws Exception {
		log.info("Clicking on 5 star rating");
		WebElement sr = driver.findElement(By.xpath(prop.getProperty("starrating")));
		// sr.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", sr);
		Thread.sleep(4000);
		Assert.assertEquals(sr.isSelected(), true);

		log.info("Page reloaded after 5 Star rating checkbox is checked");

	}

	public void checkSortBy(ExtentTest log) throws Exception {
		log.info("Sorting the hotel list");
		Select sort = new Select(driver.findElement(By.id(prop.getProperty("dropdownlist"))));
		sort.selectByValue("price|ASC");
		WebElement sb = driver.findElement(By.xpath(prop.getProperty("sortby")));
		Assert.assertEquals(sb.isSelected(), true);
	}

	public void clickButton(ExtentTest log) throws Exception {
		log.info("Clicking on Easy Stay");
		WebElement cb = driver.findElement(By.linkText(prop.getProperty("easystay")));
		Thread.sleep(4000);
		cb.click();
		Assert.assertEquals(cb.isSelected(), true);
	}

}
