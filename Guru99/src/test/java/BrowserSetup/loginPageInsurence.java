package BrowserSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class loginPageInsurence {
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
		
	}
}
