package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class JavaScriptExec extends BaseClass{
	
	
	@Test(enabled=true,groups= {"SeleniumTests"})
	public void javascriptExecu() {
		test = report.createTest("<b>Test Javascript Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://in.bookmyshow.com/explore/home/national-capital-region-ncr");
		
		// Scroll to a specific webElement
		WebElement contactTodayLink = driver.findElement(By.xpath("//a[text()='Contact today!']"));
		
		/*
		 * Casting: The (JavascriptExecutor) syntax is used to cast the driver object to
		 * the JavascriptExecutor interface. This means that the driver object will now
		 * be treated as a JavascriptExecutor object, allowing you to access its
		 * methods.
		 */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		/*
		 * 1. arguments is an array-like object that contains the arguments passed to
		 * the JavaScript function. 2. In this case, there is only one argument, which
		 * is the element represented by searchBoxActual. 3. arguments[0] refers to the
		 * first argument, which is the searchBoxActual element. 4. click() simulates a
		 * click event on the specified element.
		 */
		js.executeScript("arguments[0].scrollIntoView()", contactTodayLink);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement searchBox = driver.findElement(By.xpath("//span[contains(text(), 'Search for Movies')]"));
		js.executeScript("arguments[0].scrollIntoView()", searchBox);
		
		// Click on a specific webElement
		js.executeScript("arguments[0].click();", searchBox);
		//js.executeScript("document.getElementById('4').click();");
		WebElement searchBoxActual = driver.findElement(By.xpath("//input[@placeholder='Search for Movies, Events, Plays, Sports and Activities']"));
		// Sendkeys into textbox
		js.executeScript("arguments[0].click();", searchBoxActual);
		js.executeScript("arguments[0].value='Appu';", searchBoxActual);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
