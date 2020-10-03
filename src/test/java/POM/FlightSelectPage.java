package POM;

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

		new WebDriverWait(driver, 40)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='bodyMain']/form[@id='FrmEmtMdl']/div[@id='ServiceControllerId']/div/div[@id='divFltMain']/div/div[@id='ResultDiv']/div/div/div/div[1]/div[1]/div[1]")));

		log.info("Clicking Book Now to Proceed");
		driver.findElement(By.xpath("//body[@id='bodyMain']//div[@id='ResultDiv']//div//div//div[1]//div[1]//div[1]//div[6]//button[1]")).click();
	}
}
