package VizTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginLogout{
  
	//Base url and path to driver are declared before creating functions
	
	public String baseUrl = "https://cognitensor.com/";
	public WebDriver driver;

	// This annotation is used to run below mentioned function before running the other functions
	@BeforeTest
	@Parameters("browser")
	 public void openBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			String driverPath = "D:\\Installed Apps\\Webdrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
			String driverPath = "D:\\Installed Apps\\Webdrivers\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("opera")) {
			String driverPath = "D:\\Installed Apps\\Webdrivers\\operadriver_win64\\operadriver.exe";
			System.setProperty("webdriver.opera.driver", driverPath);
			driver = new OperaDriver();
		}

		else if(browserName.equalsIgnoreCase("IE")) {
			String driverPath = "D:\\Installed Apps\\Webdrivers\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
		}

		else if(browserName.equalsIgnoreCase("edge")) {
			String driverPath = "D:\\Installed Apps\\Webdrivers\\edgedriver_win64\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
		}
		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  }
	
	
	@Test()
	public void Login() {
		
		
		/*
		Sheet s;

	    FileInputStream fi = new FileInputStream("C:\\Users\\yirsh\\Desktop\\UAT WEBSHOP.xls");
	    Workbook w = Workbook.getWorkbook(fi);
	    s = w.getSheet(1);
	    int z = s.getRows();
	    System.out.println("no of Users:"+z);
	    driver.get("http://...@...ip.../path/");
	    driver.manage().window().maximize();
	    //Thread.sleep(10000);
	    for(int row = 1; row < 6; row++)
	    {
	        String username = s.getCell(2, 1).getContents();
	        System.out.println("Username: "+username);
	        driver.findElement(By.id("j_username_leftAside")).sendKeys(username);

	        String password = s.getCell(3, 1).getContents();
	        System.out.println("Password: "+password);
	        driver.findElement(By.id("j_password_leftAside")).sendKeys(password);

	        driver.findElement(By.xpath("/html[@class=' js opacity generatedcontent pointerevents']/body[@class='page-homepage pageType-ContentPage template-pages-layout-RexelHomePageLayout pageLabel-homepage language-de ']/div[@id='page']/div[@id='content']/div[@id='content']/div[@class='content-top-inner']/div[@id='content-inner']/div[@class='mid-wrapper'][1]/div[@class='yCmsContentSlot']/div[@class='login clear']/form[@id='loginForm']/div[@class='left sign-in']/button[@class='Sign-in rx-btn mb0']")).click();

	        if(driver.getPageSource().contains("Willkommen"))
	        {
	            System.out.println("Login Sucessfull");     
	        }
	        else
	        {
	            System.out.println("Login Failed");
	        }

	        driver.quit();
	    }
		
		*/
		
		
		//System.out.println("Clicking Login Button==============");
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/header/div[2]/div[2]/a[7]")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("qatester@cognitensor.com");;
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("admin12345");
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div/button/span[1]")).click();
		
		//String expectedUrl = "https://console.cognitensor.com/landing/main";
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 20 );
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/a")));
		//String actualUrl1 = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/div/a[2]")).click();
		System.out.println("Entering landing page==========");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/a[1]/div/span")).click();
		
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
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		String loginStatus = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.className("Toastify__toast-body"))).getText();
	    System.out.println(loginStatus+"  ============================");

		//driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		
		//WebDriverWait wait1 = new WebDriverWait(driver,40);
		//wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div[3]/div/div/div[1]")));
		
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
		//String displayed_name = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/span[2]")).getText().toString();
		
		
		
		
		
	
		WebDriverWait wait = new WebDriverWait(driver, 40);		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div[1]/div/div/h5"))).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/button[1]/span[1]")).click();
		//String actualUrl = driver.getCurrentUrl();
		//String expectedUrl = "https://console.cognitensor.com/login";
		//Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	
	@AfterTest
	public void closeBrowser() {
		//driver.close();
	}
	
}
