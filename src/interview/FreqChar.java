package interview;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FreqChar {
	public static void main(String[] args) {

		String str = "Abhishek Anand";

		char[] charArr = str.toUpperCase().toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (Character ch : charArr) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (Character ch : map.keySet()) {
			System.out.println(ch + ": " + map.get(ch));
		}

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		WebElement drpdown = driver.findElement(By.className("product_sort_container"));
		Select sel = new Select(drpdown);

		List<WebElement> list = sel.getOptions();
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}
		driver.quit();

	}
}
