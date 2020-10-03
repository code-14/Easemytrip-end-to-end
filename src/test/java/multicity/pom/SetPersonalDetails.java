package multicity.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.easemytrip.utils.BasePage;

public class SetPersonalDetails extends BasePage {

	public SetPersonalDetails(WebDriver driver) {
		super(driver);
	}

	public void setDetails(String sname, String fname, String lname, String mobile, ExtentTest log) {
		
		log.info("Proceeding forward to book the flight");
		driver.findElement(By.xpath("//span[@id='spnVerifyEmail']")).click();

		log.info("Filling Personal Details");
		WebElement Title = driver.findElement(By.xpath("//select[@id='titleAdult0']"));
		Select title = new Select(Title);
		title.selectByVisibleText(sname);
		driver.findElement(By.xpath("//input[@id='txtFNAdult0']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@id='txtLNAdult0']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@id='txtCPhone']")).sendKeys(mobile);

		log.info("Moving to Payment Page");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[@id='spnTransaction']")).click();
		log.info("Displaying Payment Methods");
	}

}
