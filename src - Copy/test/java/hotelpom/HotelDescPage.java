package hotelpom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;



public class HotelDescPage extends BasePage {

	public HotelDescPage(WebDriver driver) {
		super(driver);
	}

	public void scrollReviewCheck(ExtentTest log) throws Exception {
		WebElement E = driver.findElement(By.linkText(prop.getProperty("showallamenities")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", E);
	}

	public void checkAmenities(ExtentTest log) throws Exception {
		log.info("Clicking on Show All Amenities button");
		driver.findElement(By.linkText(prop.getProperty("showallamenities"))).click();
		Thread.sleep(3000);
	}

	public HotelTravDetailsPage hotelDescBookNow(ExtentTest log) {
		log.info("Clicking on book now button");
		String pid = driver.getWindowHandle();
		Actions ac = new Actions(driver);
		WebElement w = driver.findElement(By.xpath(prop.getProperty("booknowbtn")));
		ac.moveToElement(w).click().perform();
		Set<String> wh = driver.getWindowHandles();
		for (String s : wh) {
			if (!s.equals(pid)) {
				driver.switchTo().window(s);
			}

		}
		return new HotelTravDetailsPage(driver);
	}
}
