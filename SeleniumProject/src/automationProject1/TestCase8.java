package automationProject1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase8 {
	BasicPages bp = new BasicPages();

	@BeforeTest
	public void launchBrowser() throws Exception {
		bp.setUp();
		Thread.sleep(2000);
	}
	@Test 
	public void TestExecution()throws Exception {
	bp.invalidlogin("", "");
	Thread.sleep(3000);
	}
	@AfterTest
    public void closingbrowser() {
    	bp.closebrowser();	
    }

}
