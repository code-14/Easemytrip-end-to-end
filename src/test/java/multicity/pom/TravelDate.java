package multicity.pom;

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

	public void setTravelDate1(String dday1, String dmonth1, String dyear1, String dday2, String dmonth2, String dyear2,ExtentTest log) {
		depDate1(dday1,dmonth1,dyear1,log);
		depDate2(dday2,dmonth2,dyear2,log);
		
	}
	public void setTravelDate2(String dday1, String dmonth1, String dyear1, String dday2, String dmonth2, String dyear2,String dday3, String dmonth3, String dyear3,
			ExtentTest log) {
		depDate1(dday1,dmonth1,dyear1,log);
		depDate2(dday2,dmonth2,dyear2,log);
		if(dday3 != "" && dmonth3 != "" && dyear3 != "" )
		depDate3(dday3,dmonth3,dyear3,log);
	}

	public void depDate1(String day, String month, String year,ExtentTest log) {
		log.info("Setting Departure Date 1");
		month = month + " " + year;
		WebElement dt = driver.findElement(By.xpath("input[@id='ddateMul1']"));
		dateSelector(day, month, dt, log);
	}

	public void depDate2(String day, String month, String year,ExtentTest log) {
		log.info("Setting Departure Date 2");
		month = month + " " + year;
		WebElement dt = driver.findElement(By.xpath("input[@id='ddateMul2']"));
		dateSelector(day, month, dt, log);
	}
	public void depDate3(String day, String month, String year,ExtentTest log) {
		log.info("Setting Departure Date 3");
		month = month + " " + year;
		WebElement dt = driver.findElement(By.xpath("input[@id='ddateMul3']"));
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
