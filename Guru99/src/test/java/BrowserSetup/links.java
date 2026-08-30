package BrowserSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class links {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("https://demo.guru99.com/test/link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	}

	@AfterTest
	public void Closedown() {
		driver.quit();
		
	}
}
