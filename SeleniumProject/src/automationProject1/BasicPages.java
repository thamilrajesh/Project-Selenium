package automationProject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicPages {

    private WebDriver driver;
    
    String[][] usersAndPasswords = {
            {"standard_user", "secret_sauce"},
            {"locked_out_user", "secret_sauce"},
            {"problem_user","secret_sauce"},
            {"performance_glitch_user","secret_sauce"},
            {"error_user","secret_sauce"},
            {"visual_user","secret_sauce"}
    };
        
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;
    
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errormsg;
    
    @FindBy(id = "react-burger-menu-btn")
    private WebElement LeftNaviButton;
    
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutlink;

    @FindBy(className = "select_container")
    private WebElement soption;
            
    @FindBy(className = "inventory_item_img")
    private WebElement productimg;
      
    @FindBy (className = "inventory_item_name")
    private WebElement itemname;
    
    @FindBy(xpath = "//button[text()='Add to cart']")
    private WebElement Addtocartbutton;
    
    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removebutton;
    
    @FindBy(css = "a.shopping_cart_link")
    private WebElement carticon;
    
    @FindBy(id = "item_1_title_link")
    private WebElement twoitem;
    
    @FindBy(id = "item_4_title_link")
    private WebElement removeitem;
    
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement itemcartone;
    
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement itemcarttwo;

    @FindBy(className = "cart_list")
    private WebElement cartproductdetails;
        
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeButton;
    
    @FindBy(id = "continue-shopping")
    private WebElement continueshoppingButton;
    
    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;
    
    @FindBy(id = "postal-code")
    private WebElement postCodeInput;

   @FindBy(id = "continue")
    private WebElement continueButton;
         
   @FindBy(className = "cart_list")
   private WebElement checkoutproductdetails;
   
   @FindBy(className = "summary_info")
   private WebElement checkoutsummary;

   @FindBy(id = "cancel")
   private WebElement cancelcheckout;
   
   @FindBy(id = "finish")
   private WebElement finishcheckout;
   
   @FindBy(className = "complete-header")
    private WebElement orderConfirmation;
   
   @FindBy(xpath = "//*[@id=\"cancel\"]")
   private WebElement cancelorder;
   
   @FindBy(id = "back-to-products")
   private WebElement backhome;
   
   @FindBy(className = "footer_copy")
   private WebElement FooterText;
   
   @FindBy(linkText = "Twitter")
   private WebElement TwitterIcon;
   
   @FindBy(linkText = "Facebook")
   private WebElement FacebookIcon;
   
   @FindBy(linkText = "LinkedIn")
   private WebElement LinkedInIcon;

   // Launch the browser
    public void setUp() throws Exception {
       
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Thamil\\Desktop\\Manual and Selinium Testing\\Selenium\\Jars\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Open the SauceDemo website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        // Initialize the PageObjects class
        PageFactory.initElements(driver, this);
    }
   // Close the browser
    public void closebrowser() {
        driver.quit();
    }
    
    public void logintest() throws Exception {
    	
    	for(String[] userdata : usersAndPasswords) {
    		usernameInput.sendKeys(userdata[0]);
            passwordInput.sendKeys(userdata[1]);
            Thread.sleep(3000);
            loginButton.click();
            Thread.sleep(3000);
            if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("Login successful for user: "+userdata[0]);
                
            } else {
                System.out.println("Login failed for user: " + userdata[0]);
            }
            driver.get("https://www.saucedemo.com/");
          usernameInput.clear();
          passwordInput.clear();
          Thread.sleep(2000);
    	}
    			
    }

    public void login(String username, String password) throws Exception {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Thread.sleep(3000);
        loginButton.click();
    }
    
    public void navigateInventory() throws Exception {
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
        	System.out.println("Login successful and application Navigates to Inventory Page");
        }
        else {
        	System.out.println("Login not successful and application is not navigates to Inventory Page");
        }
    }
    public void invalidlogin(String username, String password) throws Exception {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Thread.sleep(3000);
        loginButton.click();
        if(errormsg.getText().contains("Epic sadface: Username and password do not match any user in this service")){
        	System.out.println("Correct Error Message Displayed for Invalid Entries");
        }
        else if(errormsg.getText().contains("Epic sadface: Username is required")) {
        	System.out.println("Correct Error Message Displayed for Blank Entries in Username field");
        }
        else if(errormsg.getText().contains("Epic sadface: Password is required")) {
        	System.out.println("Correct Error Message Displayed for Blank Entries in password field");
        }
        else {
        	System.out.println("Wrong Error Message Displayed");
        }
      
        
    }
    
    public void logout() throws Exception
    {
    	LeftNaviButton.click();
    	Thread.sleep(3000);
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("arguments[0].click();", logoutlink);
    	if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
        	System.out.println("Logout successful");
        }
        else {
        	System.out.println("Logout unsuccessful");
        }
    	
    }
    
    public void sortoption() {
    	soption.click();
    	
    }
    public void sortByOption(String sortorder) throws Exception {
    	soption.click();
    	Thread.sleep(2000);
    	WebElement sorder = driver.findElement(By.cssSelector("option[value='" + sortorder + "']"));
    	sorder.click();
    	Thread.sleep(3000);
    }
    
    public void Invdetailschk()
    {
    
    List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
          
    for (WebElement product : products) 
    {
    	String productName = product.findElement(By.className("inventory_item_name")).getText();
    	String productPrice = product.findElement(By.className("inventory_item_price")).getText();
    	boolean nameresult = product.isDisplayed();
    	boolean priceresult = product.isDisplayed();
    	
    	if(nameresult &&  priceresult == true) {
        	System.out.println(productName+" is displayed with price "+productPrice); }
        	else
        	{
        	System.out.println("Product name and price details are not displayed"); 	
        	}
    	
    }
    
    if (productimg.isDisplayed()) {
    	System.out.println("product Images are displayed");
    }
    else {
    	System.out.println("product Images are not displayed");
    }
    
    if (Addtocartbutton.isDisplayed()) {
    	System.out.println("Add to cart buttons are visible");
    }
    else {
    	System.out.println("Add to cart buttons are not visible");
    }
    if (Addtocartbutton.isEnabled()) {
    	System.out.println("Add to cart buttons are Enable");
    }
    else {
    	System.out.println("Add to cart buttons are not Enable");
    }
    }
    
    public void addToCartname(){
      Addtocartbutton.click();
      if (removebutton.getText().contains("Remove")) {
    	  System.out.println("After Click the AddtoCart button, Button name is changed to "+removebutton.getText());
    	  }
      else {
    	  System.out.println("After Click the AddtoCart button, Button name is not changed to Remove"); 
      }
    }
    public boolean cartimage() {
    	if (carticon.isDisplayed() && carticon.isEnabled()) {
    		carticon.click();
    		System.out.println("Carticon is visible and clickable in Inventory Page");
    		return true;
    	}
    	else {
    		return false;	
    	}
	
    }
    
    public void navigatetocartpage() throws Exception {
    	itemname.click();
    	Thread.sleep(2000);
    	Addtocartbutton.click();
    	Thread.sleep(2000);
    	carticon.click();
    }
    
    public void navigatecarttwoproduct() throws Exception {
    	itemname.click();
    	Thread.sleep(2000);
    	Addtocartbutton.click();
    	Thread.sleep(2000);
    	driver.navigate().to("https://www.saucedemo.com/inventory.html");
    	Thread.sleep(2000);
    	twoitem.click();
    	Thread.sleep(2000);
    	Addtocartbutton.click();
    	Thread.sleep(2000);
    	carticon.click();
    	Thread.sleep(2000);
    	
    }
    public void navigatecartmultiproduct() throws Exception {
    	itemcartone.click();
    	Thread.sleep(2000);
    	itemcarttwo.click();
    	Thread.sleep(2000);
    	carticon.click();
    	Thread.sleep(2000);
    	
    }
    public void CartproductDetails() throws Exception {
    	Thread.sleep(2000);
    	if(cartproductdetails.isDisplayed()) {
    		System.out.println(cartproductdetails.getText());
    	}
    	else {
    		System.out.println("Cart Product details are not displayed");
    	}
     	
    }
    public void removeProductFromCart() throws Exception  {
    	String removeitemname = removeitem.getText();
    	removebutton.click();
    	System.out.println(removeitemname+" removed from the cart");
      }
	
    public void ContinueShopping() throws Exception {
    	itemcarttwo.click();
    	Thread.sleep(2000);
    	carticon.click();
    	Thread.sleep(3000);
    	continueshoppingButton.click();
    	
    }
    public void Checkoutbutton() throws Exception {
    	itemcartone.click();
    	Thread.sleep(3000);
    	carticon.click();
    	Thread.sleep(2000);
    	checkoutButton.click();    
    }
    
    public void scrolldowncheckout() throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,100)", "");
    	Thread.sleep(2000);
    }
    
    public void Checkoutprocess(String firstName, String lastName, int postCode) throws Exception {
    	firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postCodeInput.sendKeys(String.valueOf(postCode));
        Thread.sleep(2000);
        continueButton.click();
        Thread.sleep(3000);
    	
    }
    public void CheckoutDetails() throws Exception {
    	Thread.sleep(2000);
    	if(checkoutproductdetails.isDisplayed()) {
    		System.out.println(checkoutproductdetails.getText());
    	}
    	else {
    		System.out.println("Checkout Product details are not displayed");
    	}
     	if(checkoutsummary.isDisplayed()){
    		System.out.println(checkoutsummary.getText());
    	}
    	else {
    		System.out.println("Checkout Product Summary are not displayed");
    	}
    }
    public void cancelCheckout() throws Exception {
    	cancelcheckout.click();
    	
    }
    public void finishCheckout() throws Exception {
    	finishcheckout.click();
    	if(orderConfirmation.getText().contains("Thank you for your order!")) {
    		System.out.println(orderConfirmation.getText());
    	}
    	else {
    		System.out.println("Order Confirmation message is not displayed");
    	}
    	
    }
    public void CancelOrder() throws Exception {
    	cancelorder.click();
    	
    }
    
    public void BackHome() throws Exception {
    	Thread.sleep(2000);
    	backhome.click();
    	
    }
    
    public void Footer() throws Exception {
    	if (FooterText.isDisplayed()== true) {
    		System.out.println("FooterText is Displayed");
    	}
    	else {
    		System.out.println("FooterText is not Displayed");
    	}
    	
    	if (TwitterIcon.isDisplayed()== true && FacebookIcon.isDisplayed()== true && LinkedInIcon.isDisplayed()== true) {
    		System.out.println("TwitterIcon, FacebookIcon and LinkedInIcon are Displayed");
    	}
    	else {
    		System.out.println("TwitterIcon, FacebookIcon and LinkedInIcon are not Displayed");
    	}
    	
    }
    public void scrooldownPage() throws Exception {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,500)", "");
	    Thread.sleep(2000);
    }
    public void TwitterPage() throws Exception {
    	 TwitterIcon.click();
    }
    
    public void FacebookPage() throws Exception {
       	FacebookIcon.click();
    }

    public void LinkedInPage() throws Exception {
       	LinkedInIcon.click();
    }
}
