package selenium;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TakeScreenShots {

	public static void captureScreen(WebDriver driver, String path) {

		System.out.println(path);
		TakesScreenshot tsc = (TakesScreenshot) driver;
		File srcFile = tsc.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_").trim();
		System.out.println(fileName);
		File destFile = new File(path + fileName + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
