package selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.common.base.Throwables;

import utilities.BaseClass;
import utilities.CustomizedException;

public class Window_Handling extends BaseClass {

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void window_Handling() throws IOException {

		test = report.createTest("<b>Test Switch WINDOWS Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		// TAB Handling....
		driver.get("https://www.google.com");
		test.log(Status.PASS, "Launch google.com",
				MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		driver.switchTo().newWindow(WindowType.WINDOW);
		test.log(Status.PASS, "Create a new window",
				MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		driver.get("https://www.naukri.com");
		if (driver.getTitle().trim()
				.equals("Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com")) {
			test.log(Status.PASS, "Launch naukri.com in new window",
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		} else {
			test.log(Status.FAIL, new CustomizedException("Didn't launch naukri.com in new window"),
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
			Assert.assertEquals(driver.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
		}

		for (String id : driver.getWindowHandles()) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains("https://www.naukri.com")) {
				test.log(Status.PASS, "Switched to Naukri.com Window",
						MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
				break;
			}
		}
	}

}
