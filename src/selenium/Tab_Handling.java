package selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilities.BaseClass;

public class Tab_Handling extends BaseClass {

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void tab_Handling() throws IOException {

		test = report.createTest("<b>Test Switch TAB Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		// TAB Handling....
		driver.get("https://www.google.com");
		test.log(Status.PASS, "Launch google.com",
				MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		driver.switchTo().newWindow(WindowType.TAB);
		test.log(Status.PASS, "Create a new empty tab",
				MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		driver.get("https://www.naukri.com");
		test.log(Status.PASS, "Launch naukri.com in new empty tab",
				MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());

		for (String id : driver.getWindowHandles()) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains("https://www.naukri.com")) {
				test.log(Status.PASS, "Switched to Naukri.com tab",
						MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
				break;
			}
		}
	}

}
