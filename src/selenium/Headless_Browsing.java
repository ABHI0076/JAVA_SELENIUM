package selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class Headless_Browsing extends BaseClass{

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void headless() {
		
		test = report.createTest("<b>Test Headless_Browsing Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless=true");
//		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.air.irctc.co.in/");
		System.out.println("Launched browser in headless mode and script completed successfully.");
		driver.quit();

	}


}
