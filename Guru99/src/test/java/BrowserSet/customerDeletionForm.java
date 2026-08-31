package BrowserSet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class customerDeletionForm {
	
	public WebDriverWait wait;
	public WebDriver driver;
	
	 @BeforeClass
	    public void setup() {
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        driver.get("https://demo.guru99.com/test/delete_customer.php");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}
