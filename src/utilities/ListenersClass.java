package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ListenersClass extends BaseClass implements ITestListener{

  @Override
  public void  onTestFailure(ITestResult result){
	  System.out.println("Test failed: " + result.getName());
	  try {
		  captureScreen(driver);
	  }catch(Exception e){
		  e.getMessage();
	  }
  }
}
