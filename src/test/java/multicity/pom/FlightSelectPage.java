package multicity.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class FlightSelectPage extends BasePage {

	public FlightSelectPage(WebDriver driver) {
		super(driver);
	}

	public void chooseFlight(ExtentTest log) {
		log.info("Choosing Flight as per the Requirement");

		new WebDriverWait(driver, 35)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='BtnBookNow']")));
		
		log.info("Clicking Book Now to Proceed");
		driver.findElement(By.xpath("//div[@id='BtnBookNow']")).click();
	}
}
