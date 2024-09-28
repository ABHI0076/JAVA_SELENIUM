package selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilities.BaseClass;
import utilities.ExtentReporting;

public class ExplicitWait extends BaseClass{

	@Test(enabled=true,groups= {"SeleniumTests"})
	public void ExplicitWait_Method() throws IOException {
		test = report.createTest("<b>Test ExplicitWait Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		navigateToURL("https://www.selenium.dev/downloads/");
		Assert.assertEquals(driver.getTitle(), "Downloads | Selenium", "Title verified");
		test.log(Status.PASS, "Title of the page verified",MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
		driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();
		
		// Note:- Default polling frequency of explicit wait is 500 millisecond(0.5 second).
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[@id='navbarDropdown']/following-sibling::div/a")));
		
		/* //Wait for the alert to be displayed and store it in a variable
		 * Alert alt = wait.until(ExpectedConditions.alertIsPresent()); alt.accept();
		 */

		driver.findElement(By.xpath("//a[@id='navbarDropdown']/following-sibling::div/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		test.log(Status.PASS, "Explicit wait verified");
		captureScreen(driver);


	}
}
