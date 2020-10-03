package hotelpom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.easemytrip.utils.BasePage;

public class HotelSearchingPage extends BasePage {

	public HotelSearchingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span[class='hp_city']")
	WebElement searchCity;

	@FindBy(css = "input[name='txtCity']")
	WebElement searchName;

	@FindBy(css = "input[value='Search']")
	WebElement searchButton;

	public WebElement clickCity() {
		return searchCity;
	}

	public WebElement enterCity() {
		return searchName;
	}

	public void selectCity(String cityname) throws IOException, InterruptedException {
		List<WebElement> cityOptions = driver.findElements(By.className(prop.getProperty("citynames")));
		for (WebElement option : cityOptions) {
			if (option.getText().equalsIgnoreCase(cityname)) {
				option.click();
				break;
			} else {
				driver.findElement(By.cssSelector(prop.getProperty("firstoption"))).click();
			}
		}
	}

	public void selectCheckIn(String cinmonth, int cindate) throws IOException, InterruptedException {

		while (!(driver.findElement(By.cssSelector(prop.getProperty("month")))).getText().contains(cinmonth)) {
			driver.findElement(By.cssSelector(prop.getProperty("nextmonthbtn"))).click();
		}

		int totDateCin = driver.findElements(By.className(prop.getProperty("date"))).size();

		for (int j = 0; j < totDateCin; j++) {
			String text = driver.findElements(By.className(prop.getProperty("date"))).get(j).getText();
			int text1 = Integer.parseInt(text);
			if (text1 == cindate) {
				driver.findElements(By.className(prop.getProperty("date"))).get(j).click();
				break;

			}
		}

	}

	public void selectCheckOut(String coutmonth, int coutdate) throws IOException, InterruptedException {

		while (!(driver.findElement(By.cssSelector(prop.getProperty("month")))).getText().contains(coutmonth)) {
			driver.findElement(By.cssSelector(prop.getProperty("nextmonthbtn"))).click();
		}

		int totDateCout = driver.findElements(By.className(prop.getProperty("date"))).size();

		for (int j = 0; j < totDateCout; j++) {
			String text = driver.findElements(By.className(prop.getProperty("date"))).get(j).getText();
			int text2 = Integer.parseInt(text);
			if (text2 == coutdate) {
				driver.findElements(By.className(prop.getProperty("date"))).get(j).click();
				break;

			}
		}

	}

	public void addAdult(int adultno) throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(prop.getProperty("guestdropdown"))).click();
		Thread.sleep(2000);

		if (adultno == 1) {
			driver.findElement(By.cssSelector(prop.getProperty("subadult"))).click();
		} else {
			for (int i = 0; i <= adultno - 2; i++) {
				driver.findElement(By.cssSelector(prop.getProperty("addadult"))).click();
			}
		}
		driver.findElement(By.cssSelector(prop.getProperty("donebutton"))).click();
		Thread.sleep(2000);
	}

	public void addChild(int childno) throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(prop.getProperty("guestdropdown"))).click();
		Thread.sleep(2000);

		for (int i = 0; i <= childno; i++) {
			driver.findElement(By.cssSelector(prop.getProperty("addchild"))).click();
		}
		driver.findElement(By.cssSelector(prop.getProperty("donebutton"))).click();
		Thread.sleep(2000);
	}

	public void addRoom(int roomno) throws IOException, InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(prop.getProperty("guestdropdown"))).click();
		Thread.sleep(2000);

		for (int i = 0; i <= roomno; i++) {
			driver.findElement(By.cssSelector(prop.getProperty("addroom"))).click();
		}
		driver.findElement(By.cssSelector(prop.getProperty("donebutton"))).click();
		Thread.sleep(2000);
	}

	public WebElement clickSearch() {

		return searchButton;

	}

}
