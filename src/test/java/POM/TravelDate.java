package POM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class TravelDate extends BasePage {

	public TravelDate(WebDriver driver) {
		super(driver);
	}

	public void setTravelDate(String dday, String dmonth, String dyear, ExtentTest log) {
		departureDate(dday,dmonth,dyear,log);
	}

	public void departureDate(String day, String month, String year,ExtentTest log) {
		log.info("Setting Departure Date");
		month = month + " " + year;
		WebElement dt = driver.findElement(By.xpath("//input[@id='ddate']"));
		dateSelector(day, month, dt, log);
	}

	public void dateSelector(String day, String month, WebElement dt, ExtentTest log) {
		log.info("Searching for desired month and year of travel");
		dt.click();
		while (true) {
			String date = driver.findElement(By.xpath("//div[@class='month2']")).getText();
			if (date.equals(month))
				break;
			else
				driver.findElement(By.xpath("//img[@id='img2Nex']")).click();
		}
		log.info("Searching for desired date of travel");
		List<WebElement> days = driver.findElements(By.xpath("//div[@class='days']/ul/li"));
		for (WebElement el : days) {
			String dd = el.getText();
			String data[] = dd.split("\n");
			if (data[0].equals(day)) {
				el.click();
				break;
			}
		}
	}
}
