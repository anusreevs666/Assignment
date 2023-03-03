package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAmazon {

	@BeforeMethod
	public void openUrl() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String Url="https://www.amazon.in/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@Test 
	public void VerifyLogin() throws Exception{
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
		username_textbox = driver.find_element_by_id("ap_email");
		username_textbox.send_keys("abc@gmail.com");
		Continue_button = driver.find_element_by_id("continue");
		Continue_button.submit();
		password_textbox = driver.find_element_by_id("ap_password");
		password_textbox.send_keys("Abcd@123");
		SignIn_button = driver.find_element_by_id("auth-signin-button-announce");
		SignIn_button.submit();
		Assert.assertEquals(actualText,"")
	}
	
	@Test
	public void AddToCart() throws Exception{
		driver.findElement(By.id("twotabsearchtextbox")).clear();  //clear search tab
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("realme");// search bar 
		
		//window handle
		String originalWindow = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;
		
		driver.findElement(By.id("nav-search-submit-button")).click();//click search
		wait.until(numberOfWindowsToBe(2));
			for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    	}
			}
		
		//to verify if product is there
		String product=getDriver().findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[2]/div")).getText();
		if(product.contains("realme")) {
			getdriver().findElement(By.id("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		}else {
			System.out.println("There is no Realme phone in stock");
		}
		Thread.sleep(1000);
		
		//to verify Add to Cart Functionlity
		int size=getDriver().findElement(By.id("add-to-cart-button")).size();
		if(size==1) {
			getDriver().findElement(By.id("add-to-cart-button")).click();
		}else if(a==0) {
			System.out.println("Add To Cart Button is not there");
		}else {
			System.out.println("Add To Cart Button is not there");
		}
		
		//To verify Product is added to cart using assertion
		String expected_Message="Added to Cart";
		String actual_message=driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
		assertEquals(expected_Message, actual_message);
	}
	
	@Test
	public void LogoutAndInvalidCredentialsLogin() throws Exception{
		//mousehover
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span")); //mouse hover
		action.moveToElement(ele).perform();
		WebElement signOutBtn = driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
		signOutBtn.click();// signout
		
		//verify invalid credentoals login
		username_textbox = driver.find_element_by_id("ap_email");
		username_textbox.send_keys("abc");
		Continue_button = driver.find_element_by_id("continue");
		Continue_button.submit();
		String error_message="We cannot find an account with that email address";
		String actual_message=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		assertEquals(error_message, actual_message);
		
		driver.find_element_by_id("ap_email").clear() // clear text box
		username_textbox = driver.find_element_by_id("ap_email");
		username_textbox.send_keys("abc@gmail.com");
		Continue_button = driver.find_element_by_id("continue");
		Continue_button.submit();
		password_textbox = driver.find_element_by_id("ap_password");
		password_textbox.send_keys("Abc");
		String error_message2="Your password is incorrect";
		String actual_message2=driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();
		assertEquals(error_message2, actual_message2);
		
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
		driver.close();//close browser
	}
	
	

}
