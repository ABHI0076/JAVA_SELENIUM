package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CBRE {

	public void dropdown() {
	WebElement dropdown = new ChromeDriver().findElement(By.xpath("djbvisdbv"));
	
	List<String> expValues = new ArrayList<String>();
	Select sel = new Select(dropdown);
	
	List<WebElement> actValues = sel.getOptions();
	
	int i=0;
	for(WebElement ele : actValues) {
		String value = ele.getText();
		
		if(value.equals(expValues.get(i))) {
			//log
		}
		i++;
	}
	
	
	}
}
