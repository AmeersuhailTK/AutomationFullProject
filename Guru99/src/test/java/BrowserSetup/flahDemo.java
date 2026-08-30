package BrowserSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class flahDemo {

	    public WebDriver driver;

	   @BeforeMethod 
	    public void setup() {
	        driver = new FirefoxDriver();
	        driver.get("https://demo.guru99.com/test/flash-testing.html");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        
	    }
	   
	   @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }

}
