package selenium;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilities.BaseClass;

public class Grid extends BaseClass{
	
	@Test(enabled=true,groups= {"SeleniumTests"})
	public void grid() throws IOException {
		test = report.createTest("<b>Test GRID Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		
		/*
		 * When would you use a Selenium Grid?
		 * 
		 * 1. To run your tests in parallel, against different browser types, browser
		 * versions, operating systems 2. To reduce the time needed to execute a test
		 * suite
		 * 
		 * Selenium Grid runs test suites in parallel against multiple machines (called
		 * Nodes). For large and long-running test suites, this can save minutes, hours,
		 * or perhaps days. This shortens the turnaround time for test results as your
		 * application under test (AUT) changes.
		 * 
		 * Grid can run tests (in parallel) against multiple different browsers, and it
		 * can run against multiple instances of the same browser. As an example, let’s
		 * imagine a Grid with six Nodes. The first machine has Firefox’s latest
		 * version, the second has Firefox “latest minus one”, the third gets the latest
		 * Chrome, and the remaining three machines are Mac Minis, which allows for
		 * three tests to run in parallel on the latest version of Safari.
		 */
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "100");
		chromeOptions.setCapability("platformName", "Windows");
		WebDriver driver = new RemoteWebDriver(new URL("http://gridUrl:4444"), chromeOptions);
		driver.get("https://www.google.com");
	}

}
