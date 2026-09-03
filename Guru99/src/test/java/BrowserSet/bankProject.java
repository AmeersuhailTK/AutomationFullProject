package BrowserSet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class bankProject {

	    protected WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://demo.guru99.com/V1/index.php");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @AfterClass
	    public void tearDown() {
	       
	            driver.quit();
	        
	    }
	}