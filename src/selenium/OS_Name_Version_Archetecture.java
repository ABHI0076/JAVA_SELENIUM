package selenium;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class OS_Name_Version_Archetecture extends BaseClass{
	
	@Test(enabled = true, groups = { "SeleniumTests" })
	public void os_Name_Version_Archetecture() {
		
		System.out.println("Operating system name is : "+System.getProperty("os.name"));
		System.out.println("Operating system version is : "+System.getProperty("os.version"));
		System.out.println("Operating system archetecture is : "+System.getProperty("os.arch"));
		test = report.createTest("<b>Test OS NAme, Version Functionality</b>");
		test.assignAuthor("<b>ABHISHEK ANAND</b>");
		test.assignCategory("<b>REGRESSION</b>");	

	}

}
