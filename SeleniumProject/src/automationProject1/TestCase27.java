package automationProject1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase27 {

	BasicPages bp = new BasicPages();
	   
	@BeforeTest
	public void launchBrowser() throws Exception {
		bp.setUp();
		bp.login("standard_user", "secret_sauce");  
		Thread.sleep(2000);	
	}
    @Test 
	public void TestExecution()throws Exception {
    bp.Checkoutbutton();
    bp.scrolldowncheckout();
    bp.Checkoutprocess("Ravi","Krishna",350024);
    bp.finishCheckout();
	Thread.sleep(3000);	
	}
    @AfterTest
    public void closingbrowser() {
    	bp.closebrowser();	
    }

}
