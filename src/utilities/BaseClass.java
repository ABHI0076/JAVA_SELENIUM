 package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BaseClass extends ExtentReporting {

	// For Parallel Execution, always make driver non-static.

	/*
	 * A static field belongs to the class (and not the instance of a class) and so
	 * it exists only once no matter how many times you call that class. You can
	 * read more about this here and here and many other sources.
	 * 
	 * As it is, every time your code executes driver = new ChromeDriver() (or
	 * driver = new FirefoxDriver()) it launches a new browser, which you observed,
	 * and overwrites the field driver with the new value.
	 * 
	 * In order to run your tests in parallel, you must make the driver not static.
	 * You will also have to adjust your code to access this field in a non-static
	 * way.
	 */
	public WebDriver driver;
	public ITestContext context;

	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Inside Before class");
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			System.out.println("Inside Before class");
		}
		
//		test = report.createTest(this.getClass().getName());
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		driver.quit();
		System.out.println("Inside After class");
	}

	@BeforeSuite(alwaysRun = true)
	public void extentReportSetup() {
		generateExtentReport();
		System.out.println("Inside Before Suite.");
		
	}

	@AfterSuite(alwaysRun = true)
	public void flushExtentReport() throws IOException {
		flushReport();
		/* Automatically open the report in the browser. */
		Desktop.getDesktop().browse(new File("./Reports/ExtentReport.html").toURI());
		System.out.println("Inside After Suite.");
	}

	@AfterMethod(alwaysRun = true)
	public void insertTestResultStatusToExtentReport(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " <b>PASSED</b>", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " <b>FAILED</b>", ExtentColor.RED));
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(captureScreen(driver)).build());
			test.log(Status.FAIL, result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " <b>SKIPPED</b>", ExtentColor.YELLOW));
		}
		System.out.println("Inside After Method.");
	}

	public void implicitlyWait(int timeDuration_In_Seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeDuration_In_Seconds));
	}

	public void navigateToURL(String url) {
		driver.navigate().to(url);
		implicitlyWait(10);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		test.log(Status.INFO, "User Navigated to the URL");
	}

	public String captureScreen(WebDriver driver) throws IOException {

		TakesScreenshot tsc = (TakesScreenshot) driver;
		File srcFile = tsc.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_").trim();
		System.out.println(fileName);
		String folderPath = System.getProperty("user.dir") + "/screenshots/";
		File destFile = new File(folderPath + fileName + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File imageFile = new File(destFile.getAbsolutePath());
		FileInputStream fileInputStream = new FileInputStream(imageFile);
		byte[] imageData = new byte[(int) imageFile.length()];
		fileInputStream.read(imageData);
		fileInputStream.close();
		return Base64.getEncoder().encodeToString(imageData);

	}

}
