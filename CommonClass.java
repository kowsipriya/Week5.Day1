package Week5.day1;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class CommonClass {
		
		public ChromeDriver driver;
		public WebElement mainFrame;
		
		@BeforeMethod
		public void loginServiceNow() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		//To invoke the instance
		driver.get("https://dev55302.service-now.com");
		driver.manage().window().maximize();
		WebElement mainFrame = driver.findElement(By.id("gsft_main"));
		driver.switchTo().frame(mainFrame);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Sughanthan#8");
		driver.findElement(By.id("sysverb_login")).click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);	
	    }
		
		@BeforeMethod
		public void openSearchIncident() throws InterruptedException {
			driver.findElement(By.id("filter")).clear();
			driver.findElement(By.id("filter")).sendKeys("incidents", Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
			mainFrame = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(mainFrame);		
		}
		
		@AfterMethod
		public void logoutServiceNow() {
			driver.switchTo().defaultContent();
			driver.findElement(By.id("user_info_dropdown")).click();
			driver.findElement(By.linkText("Logout")).click();
			driver.close();		
		}
	}

