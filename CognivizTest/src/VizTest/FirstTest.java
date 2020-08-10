package VizTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest{
  
	//Base url and path to driver are declared before creating functions
	
	public String baseUrl = "https://cognitensor.com/";
	String driverPath = "D:\\\\Installed Apps\\\\Webdrivers\\\\geckodriver-v0.26.0-win64\\\\geckodriver.exe";
	public WebDriver driver;
	
	// This annotation is used to run below mentioned function before running the other functions
	@BeforeTest
	 public void openBrowser() {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();
	  }
	
	// Test annotation is used in testNG to declare test functions, 
	// we can set the priority of the functions in which order they will be executed
	@Test(priority=0)
	  public void checkUrl() {
		String expectedTitle = "Cognitensor | an A.I. company";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	} 
	
	
	@Test(priority=1)
	public void clientLogin() {
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[2]/a[7]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://console.cognitensor.com/login";

		if(actualUrl.equals(expectedUrl)) { 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("qatester@cognitensor.com");;
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("admin12345");
			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div/button/span[1]")).click();
			String actualHead = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
			String expectedHead = "Deep Optics";
			Assert.assertEquals(actualHead, expectedHead);
		}
		
		else {
			String actualHead = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
			String expectedHead = "Deep Optics";
			Assert.assertEquals(actualHead, expectedHead);
		}
	}
	/*
	@Test(priority=2)
	public void clientLogin() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("qatester@cognitensor.com");;
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("admin12345");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div/button/span[1]")).click();
		
		String actualHead = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/h2")).getText();
		String expectedHead = "Deep Optics";
		Assert.assertEquals(actualHead, expectedHead);
	}
	*/
	
	@Test(priority=2)
	public void clickViz() {
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/div/a[2]")).click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://console.cognitensor.com/athena";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	  
	@Test(priority=3)
	public void userProfile() {
		
		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[1]/div/a[1]/div/span")).click();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://console.cognitensor.com/athena/profile";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=4)
	public void editUser() {
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/span[2]")).click();
		String first_name = "Jon";
		String last_name = "Smith";
		String department = "QA";
		String company_profile = "Cogni";
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div/input")).sendKeys(first_name);
		
		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div/input")).sendKeys(last_name);

		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[3]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[3]/div/div/div/input")).sendKeys(department);
		
		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[4]/div/div/div/input")).sendKeys(company_profile);

		driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[5]/button/span[1]")).click();
		
		String loginStatus = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("Toastify__toast-body"))).getText();
	    System.out.println(loginStatus+"  ============================");

		driver.navigate().refresh();
		String displayed_name = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/span[2]")).getText().toString();
		Assert.assertEquals(displayed_name, first_name);
	}
	
	@Test(priority=5)
	public void logoutUser() {
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div/h5"))).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[1]/span[1]")).click();
		System.out.println("Logging out==========");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://console.cognitensor.com/login";
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
