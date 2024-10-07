package selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.ExcelReader;

public class ReadExcelData extends BaseClass {

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void readExcelTest() throws IOException {

		test = report.createTest("<b>Test Excel Read Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		// Read data from ExcelSheet
		Map<String, String> data = ExcelReader.readDataFromExcel(System.getProperty("user.dir")+prop.getProperty("TestDataFilePath"),
				prop.getProperty("RegressionSheet"));
		
		String userName = data.get("UserName");
		String password = data.get("Password");
		String pageTitle = data.get("PageTitle");

		driver.get(prop.getProperty("QA_Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// Capture Tool-Tip.
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		String actPageTitle = driver.getTitle();
		Assert.assertEquals(actPageTitle, pageTitle);
	}
}
