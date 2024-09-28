package utilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {
	
	public ExtentSparkReporter sparkReporter;
	static public ExtentReports report;
	public ExtentTest test;
	
	public void generateExtentReport() {
		String path = System.getProperty("user.dir")+ "/Reports/ExtentReport.html";
		sparkReporter = new ExtentSparkReporter(path);
		/*Apply filter to the reports.*/	
		//sparkReporter.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();	  
		sparkReporter.config().setDocumentTitle("Regression Result");
		sparkReporter.config().setReportName("<b>Test Result</b>");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("MMM d, yyyy hh:mm:ss a");
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("os", "macos");

		
	}
	
	public void flushReport() {
		report.flush();
	}
	
	public void getTestResults(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "<b>PASSED</b>", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "<b>FAILED</b>", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "<b>SKIPPED</b>", ExtentColor.YELLOW));
		}

	}

}
