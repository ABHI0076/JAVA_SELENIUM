package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class Assertion extends BaseClass{

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void ExplicitWait_Method() {
		test = report.createTest("<b>Test Hard and Soft Assertion Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[@id='navbarDropdown']/following-sibling::div/a")));

		driver.findElement(By.xpath("//a[@id='navbarDropdown']/following-sibling::div/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Assert.assertEquals(driver.getTitle(), "About Selenium | Selenium", "Title verified");

//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals("Act", "exp");
//		softAssert.assertAll();

	}
}
