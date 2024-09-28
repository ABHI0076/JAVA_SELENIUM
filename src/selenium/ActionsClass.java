package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class ActionsClass extends BaseClass{

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void actionClassTest() {
		
		test = report.createTest("<b>Test Actions class Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");

		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// Capture Tool-Tip.
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[text()='Student']"))).perform();
		WebElement tooltip = driver.findElement(By.xpath("//div[text()='Student']/../following-sibling::span[@class='tooltip']"));
		System.out.println(tooltip.getText());	

	}

}
