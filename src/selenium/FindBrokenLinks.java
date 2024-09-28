package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BaseClass;

public class FindBrokenLinks extends BaseClass{
	
	@Test(enabled=true,groups= {"SeleniumTests"})
	public void verifyLinks() {
		
		test = report.createTest("<b>Find Broken links</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement ele:links) {
			String actLink = ele.getAttribute("href");
			if(actLink==null || actLink.isEmpty()) {
				continue;
			}
			if(actLink.contains("https://www.selenium.dev")) {

			try {
				/*
				 * 1. URL url: This represents a Uniform Resource Locator (URL) pointing to the
				 * desired web resource. It's typically created using the new URL(String)
				 * constructor. 2. url.openConnection(): This method creates a generic
				 * URLConnection object, which represents a connection to the specified URL.
				 * This object provides a way to interact with the remote resource. 3.
				 * (HttpsURLConnection)url.openConnection(): This part is called casting. It
				 * explicitly converts the generic URLConnection object into an
				 * HttpsURLConnection object. Why cast? HttpsURLConnection is a subclass of
				 * URLConnection that is specifically designed for HTTPS (Hypertext Transfer
				 * Protocol Secure) connections. It provides methods and properties that are
				 * relevant to HTTPS, such as handling SSL certificates and encryption.
				 */
				URL url = new URL(actLink);
				HttpsURLConnection urlConnect = (HttpsURLConnection)url.openConnection();
				urlConnect.setConnectTimeout(3000);
				urlConnect.setRequestMethod("GET");
				urlConnect.connect();
				if(urlConnect.getResponseCode()>=400) {
					System.out.println(url+":- "+ urlConnect.getResponseMessage()+" is a broken link");
				}else {
					System.out.println(url+":- "+ urlConnect.getResponseMessage());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				System.out.println("URL belongs to another domain, Skipping it.");
				continue;
			}
			
		}
		
	}

}
