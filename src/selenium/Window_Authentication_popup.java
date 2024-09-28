package selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.Headers;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class Window_Authentication_popup extends BaseClass {

	// **************METHOD : 1 **************

	@Test(priority = 1, enabled = true, groups = { "SeleniumTests" })
	public void windows_Auth_Popup1() {

		test = report.createTest("<b>Test Window_Authentication Method-1</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch the URL
		driver.get("https://UserName:Password@www.xyz.com");

	}

	// **************METHOD : 2 **************

	// Pass Credentials to Window Authentication Popup Using 'ChromeDevTool'.
	// 'ChromeDevTool' is applicable only for Chromium based Browsers(Chrome and
	// Edge).

	@Test(priority = 2, enabled = true, groups = { "SeleniumTests" })
	public void windows_Auth_Popup2() {

		test = report.createTest("<b>Test Window_Authentication Method-2</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Authentication username & password
		String auth = "UserName:Password";

		// Get the devtools from the running driver and create a session
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();

		// Enable the Network domain of devtools
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		// Encoding the username and password using Base64
		String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());

		// Pass the network header as Authorization : Basic <encoded String>
		Map<String, Object> headers = new HashMap<>();
		headers.put("Authorization", "Basic " + encodeToString);
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

		// Launch the URL
		driver.get("URL");
	}

	// **************METHOD : 3 **************

	/*
	 * Using AutoIT -->It works only for Windows not for Mac Install "AutoIT" and
	 * "AutoIT Script Editor". Browse to “C:\Program Files (x86)\AutoIt3\SciTE” and
	 * double-click “SciTE.exe” to launch AutoIt editor. Enter the below code to
	 * pass username and password in AutoIt editor and save the file with extension
	 * .au3 Right-click the created script(Login.au3) and choose “Compile script
	 * (x64)/ Compile script (x64) “ depending on your Windows configuration and
	 * observe that “Login.exe” is generated. Now after the driver.get() method you
	 * can put the AutoIt executable path as below.
	 * Runtime.getRuntime().exec(“D:\\Auto IT\\Login.exe”);
	 */

	@Test(priority = 3, enabled = true, groups = { "SeleniumTests" })
	public void windows_Auth_Popup3() throws IOException {

		test = report.createTest("<b>Test Window_Authentication Method-3</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch the URL
		driver.get("https:www.xyz.com");
		Runtime.getRuntime().exec("D:/Auto IT/Login.exe");
	}

}
