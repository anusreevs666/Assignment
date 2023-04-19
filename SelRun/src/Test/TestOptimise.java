package Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestOptimise {
	
	@BeforeMethod
	public void openUrl() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		String Url="https://www.optimisemedia.com/contact";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void verifyFunctionality() {
	 System.out.println("Title of the page is :" + driver.getTitle()); //to print the title of page
	 
	 //input name
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Anusree");
	 
	 //input country from dropdown
	 WebElement country= driver.findElement(By.xpath("//select[@class='ng-valid ng-dirty ng-touched']"));
	 Select  select= new Select(country);
	 select.selectByVisibleText("India");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@class='form-control ng-touched ng-dirty ng-valid']")).sendKeys("anusreevs555@gmail.com");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("9961753678");
	 
	 //input source
	 driver.findElement(By.xpath("//input[@formcontrolname='source']")).sendKeys("Linkedin");
	 
	 //input message
	 driver.findElement(By.xpath("//textarea[@formcontrolname='message']")).sendKeys("Advertising");
	 
	 //click on submit
	 driver.findElement(By.xpath("//button[@class='btn outline-btn blue submit']")).click();
	 
	 //verify message
	 String ExpectedMessage="Thanks for your query, we will get back to you soon.";
	 String ActualMessage=driver.findElement(By.xpath("/html/body/app-root/div/app-shell/app-contact/div/div[2]/div/div/div/div")).getText();
	 Assert.assertEquals(ExpectedMessage,ActualMessage);
	 
	 
	 
	}
	@Test
	public void verifyNegativeScenario1() throws Exception{
	
	 //input name
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Anusree");
	 
	 //input country from dropdown
	 WebElement country= driver.findElement(By.xpath("//select[@class='ng-valid ng-dirty ng-touched']"));
	 Select  select= new Select(country);
	 select.selectByVisibleText("India");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@class='form-control ng-touched ng-dirty ng-valid']")).sendKeys("anusreevs555@gmail.com");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("9961753678");
	 
	 //input source
	 driver.findElement(By.xpath("//input[@formcontrolname='source']")).sendKeys("Linkedin");
	 
	//click on submit witout message
	 driver.findElement(By.xpath("//button[@class='btn outline-btn blue submit']")).click();
	 
	 String ExpectedMessage1="Message is required and its length should be 6 letters at least.";
	 String ActualMessage1=driver.findElement(By.xpath("/html/body/app-root/div/app-shell/app-contact/div/div[2]/div/div/div/form/div[6]/div/div")).getText();
	 Assert.assertEquals(ExpectedMessage1,ActualMessage1);
	 
	}
	@Test
	public void verifyNegativeScenario2() {
		 
		 //input country from dropdown
		 WebElement country= driver.findElement(By.xpath("//select[@class='ng-valid ng-dirty ng-touched']"));
		 Select  select= new Select(country);
		 select.selectByVisibleText("India");
		 
		 //input email id
		 driver.findElement(By.xpath("//input[@class='form-control ng-touched ng-dirty ng-valid']")).sendKeys("anusreevs555@gmail.com");
		 
		 //input email id
		 driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("9961753678");
		 
		 //input source
		 driver.findElement(By.xpath("//input[@formcontrolname='source']")).sendKeys("Linkedin");
		 
		 //input message
		 driver.findElement(By.xpath("//textarea[@formcontrolname='message']")).sendKeys("Advertising");
		 
		 //click on submit
		 driver.findElement(By.xpath("//button[@class='btn outline-btn blue submit']")).click();
		 
		 //verify message
		 String ExpectedMessage2="Name is required";
		 String ActualMessage2=driver.findElement(By.xpath("/html/body/app-root/div/app-shell/app-contact/div/div[2]/div/div/div/form/div[1]/div/div")).getText();
		 Assert.assertEquals(ExpectedMessage2,ActualMessage2);
		 
	}
	@Test
	public void verifyFunctionality3() {
	 System.out.println("Title of the page is :" + driver.getTitle()); //to print the title of page
	 
	 //input name
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Anusree");
	 
	 //input country from dropdown
	 WebElement country= driver.findElement(By.xpath("//select[@class='ng-valid ng-dirty ng-touched']"));
	 Select  select= new Select(country);
	 select.selectByVisibleText("India");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@class='form-control ng-touched ng-dirty ng-valid']")).sendKeys("anusreevs555@gmail.com");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("9961753678");
	 
	 //input source
	 driver.findElement(By.xpath("//input[@formcontrolname='source']")).sendKeys("Linkedin");
	 
	 //input message
	 driver.findElement(By.xpath("//textarea[@formcontrolname='message']")).sendKeys("Test");
	 
	 //click on submit
	 driver.findElement(By.xpath("//button[@class='btn outline-btn blue submit']")).click();
	 
	 //verify message
	 String ExpectedMessage3="Message is required and its length should be 6 letters at least.";
	 String ActualMessage3=driver.findElement(By.xpath("/html/body/app-root/div/app-shell/app-contact/div/div[2]/div/div/div/form/div[6]/div/div")).getText();
	 Assert.assertEquals(ExpectedMessage3,ActualMessage3);
	 
	 
	}
	@Test
	public void verifyFunctionality4() {
	
	 //input name
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Anusree");
	 
	 //input country from dropdown
	 WebElement country= driver.findElement(By.xpath("//select[@class='ng-valid ng-dirty ng-touched']"));
	 Select  select= new Select(country);
	 select.selectByVisibleText("India");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@class='form-control ng-touched ng-dirty ng-valid']")).sendKeys("anusreevs555@gmail.com");
	 
	 
	 //input source
	 driver.findElement(By.xpath("//input[@formcontrolname='source']")).sendKeys("Linkedin");
	 
	 //input message
	 driver.findElement(By.xpath("//textarea[@formcontrolname='message']")).sendKeys("Advertising");
	 
	 //click on submit
	 driver.findElement(By.xpath("//button[@class='btn outline-btn blue submit']")).click();
	 
	 //verify message
	 String ExpectedMessage4="Phone is required";
	 String ActualMessage4=driver.findElement(By.xpath("/html/body/app-root/div/app-shell/app-contact/div/div[2]/div/div/div/form/div[4]/div/div")).getText();
	 Assert.assertEquals(ExpectedMessage4,ActualMessage4);
	}
	
	@Test
	public void verifyFunctionality5() {

	 //input name
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Anusree");
	 
	 //input country from dropdown
	 WebElement country= driver.findElement(By.xpath("//select[@class='ng-valid ng-dirty ng-touched']"));
	 Select  select= new Select(country);
	 select.selectByVisibleText("India");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@class='form-control ng-touched ng-dirty ng-valid']")).sendKeys("anusreevs555@gmail.com");
	 
	 //input email id
	 driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("9961753678");
	
	 //input message
	 driver.findElement(By.xpath("//textarea[@formcontrolname='message']")).sendKeys("Advertising");
	 
	 //click on submit
	 driver.findElement(By.xpath("//button[@class='btn outline-btn blue submit']")).click();
	 
	 //verify message
	 String ExpectedMessage5="This is required and its length should be 6 letters at least.";
	 String ActualMessage5=driver.findElement(By.xpath("/html/body/app-root/div/app-shell/app-contact/div/div[2]/div/div/div/form/div[5]/div/div")).getText();
	 Assert.assertEquals(ExpectedMessage5,ActualMessage5);
	
	
	 
	 
	}
	@AfterMethod
	public void closebrowser() {
		driver.quit();
		driver.close();//close browser
	}
	
	
		 

}
