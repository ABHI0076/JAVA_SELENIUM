package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class SelectClass extends BaseClass{

	@Test(enabled = true, groups = { "SeleniumTests" })
	public void dropdownHandling() {
		
		test = report.createTest("<b>Test Select clas Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.functionize.com/free-trial");
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='job_role']"));
		Select sel = new Select(dropdown);

		List<String> expVal = new LinkedList<String>(Arrays.asList("QA Manager / Lead", "QA Analyst",
				"Quality Engineer / SDET", "Director, Head of, or VP of Quality", "Software Engineer",
				"Director, Head of, or VP of Software Engineering", "CIO / CTO / CEO", "Other",
				"Consultant / Services Provider", "Automation Test Engineer", "Scrum Master"));

		List<WebElement> options = sel.getOptions();
		for (int i = 1; i < options.size(); i++) {

			if (expVal.contains(options.get(i).getText())) {
				System.out.println(options.get(i).getText() + " : Matched");
				expVal.remove(options.get(i).getText());
			}

		}
		if(expVal.size()>=1) {
		System.out.println("Not Matched are : " + expVal.toString());
		Assert.fail("Dropdown values didn't match");
		}

	}

}
