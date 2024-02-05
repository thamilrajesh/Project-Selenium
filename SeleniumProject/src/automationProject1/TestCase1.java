package automationProject1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	BasicPages bp = new BasicPages();

	@BeforeTest
	public void launchBrowser() throws Exception {
		bp.setUp();
	}	
	@Test 
	public void TestExecution()throws Exception {
              
      bp.logintest();
      Thread.sleep(2000);
	}
	@AfterTest
    public void closingbrowser() {
    	bp.closebrowser();	
    }

}
