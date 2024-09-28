package interview;

import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.Headers;

public class API {

//	public void clickLink(List<WebElement> lst, WebElement element) {
//		
//		for(WebElement ele : lst)
//		if(ele.getAttribute("href").equals(element.getAttribute("href"))) {
//			element.click();
//		}
//	}

	public static void main(String[] args) {

//		Response res = given().header("content-type", "Application/Json").
//		when().get(URI).
//		then().log().all().body();
//		
//		res.

//		String str = "Iris software is in Noida";
//		
//		char[] charArr = str.toLowerCase().toCharArray();
//		
//		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		
//		for(Character ch :charArr) {
//			
//			if(map.containsKey(ch)) {
//				if(ch.equals(' ')) {
//					continue;
//				}
//				map.put(ch, map.get(ch)+1);
//			}
//			else {
//				if(ch.equals(' ')) {
//					continue;
//				}
//				map.put(ch, 1);
//			}
//		}
//		
//		for(Character ch : map.keySet()) {
//
//			System.out.println(ch + ": "+map.get(ch));
//		}
//
//	}

//		String str = "Iris software is in Noida";
//		
//		String[] strArr = str.split(" ");
//		
//		String revString="";
//		for(int i=0;i<strArr.length;i++) {
//			
//			String word = strArr[i];
//			String revWord="";
//			
//			for(int j=word.length()-1;j>=0;j--) {
//				revWord=revWord+word.charAt(j);
//			}
//			revString = revString+revWord+" ";
//		}
//		System.out.println(revString);
//		
//		
//		
//		select min(salary) form (select dist Salary form TableName order salary desc) where Rownum>=3;

//String str = "ABdhsd Asbs214Cfd1343cfd2r3e2c%^$!@Vg!^$#%!$#hav544#23";
//
//System.out.println(str.replaceAll("[^A-Za-z]", ""));

//int i =134;
//int r,sum=0;
//
//while(i>0) {
//	r = i%10;
//	sum=sum+r;
//	i=i/10;
//	
//}
//
//System.out.println("Sum is : " +sum);

		
//Pass Credentials to Window Authentication Popup Using 'ChromeDevTool'.
// 'ChromeDevTool' is applicable only for Chromium based Browsers(Chrome and Edge).
		
		// Setup Chrome driver
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Authentication username & password
		String auth = "UserName:Password";
		
		// Get the devtools from the running driver and create a session
		DevTools devTools = driver.getDevTools();
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
}
