package automationProject1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase5 {

	BasicPages bp = new BasicPages();

	@BeforeTest
	public void launchBrowser() throws Exception {
		bp.setUp();
	}	
	@Test 
	public void TestExecution()throws Exception {
		bp.invalidlogin("fdgfgh", "rtrth55");
		Thread.sleep(3000);
	}
	@AfterTest
    public void closingbrowser() {
    	bp.closebrowser();	
    }

}
