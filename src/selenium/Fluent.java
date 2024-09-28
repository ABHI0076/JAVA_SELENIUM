package selenium;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class Fluent extends BaseClass{
	
	@Test(enabled=true,groups= {"SeleniumTests"})
	public void fluentWait() throws IOException {
		test = report.createTest("<b>Test FluentWait Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		navigateToURL("https://www.selenium.dev/downloads/");
		Assert.assertEquals(driver.getTitle(), "Downloads | Selenium", "Title verified");
		test.log(Status.PASS, "Title of the page verified",MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();

		FluentWait<WebDriver> fluWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class)
				.withMessage("Waited for element to be clickable");

		fluWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='navbarDropdown']/following-sibling::div/a")));

		driver.findElement(By.xpath("//a[@id='navbarDropdown']/following-sibling::div/a")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		test.log(Status.PASS, "Fluent wait verified");
		captureScreen(driver);
	}

}
