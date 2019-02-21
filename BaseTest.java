package salesForceTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest Logger;

	public static void initialize(String reportFileName) {
		System.setProperty("webdriver.chrome.driver", "C:\\TrainingJAN19\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		String path = "C:\\TrainingJAN19\\ExtentReport\\" + reportFileName;
		report = new ExtentReports(path);
	}

	public static void launch(String url) {
		driver.get(url);
	}

	/*
	 * Name : EnterText Description - Enter the text value in the object field
	 * Arguments ObjextName -Name of the object textvalue-value of the object
	 * 
	 * Created by : Raji Created Date :14-02-3019 Last modified date :
	 * 14-02-2019
	 */
	public static void enterText(WebElement obj, String objname, String textvalue) {
		if (obj == null)
			return;
		if (obj.isDisplayed()) {
			obj.sendKeys(textvalue);
			System.out.println("Pass" + textvalue + "entered in" + objname);
		} else {
			System.out.println("Fail" + textvalue + "not entered in" + objname);
		}
	}

	public static void selectcheckbox(WebElement obj, String objname) {
		if (obj == null)
			return;
		if (obj.isDisplayed()) {
			if (!obj.isSelected()) {
				obj.click();

			}
			System.out.println(" Pass checkbox " + objname + "is selected");
		} else {
			System.out.println(" Fail checkbox " + objname + "Could not be found");
		}
	}

	public static void buttonclick(WebElement obj, String objname) {
		if (obj == null)
			return;
		if (obj.isDisplayed()) {
			if (obj.isEnabled()) {
				obj.click();

			}
			System.out.println(" Pass Button " + objname + "is clicked");
		} else {
			System.out.println(" Fail Button " + objname + "Could not be found");
		}
	}

	public static WebElement findElement(By location, String objname) {
		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			System.out.println("Pass" + objname + "found on the page");
		} catch (NoSuchElementException ex) {
			System.out.println("Fail" + objname + "Not found on the page");

		}
		return obj;
	}

}
