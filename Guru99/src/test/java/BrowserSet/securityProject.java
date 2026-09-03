package BrowserSet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class securityProject {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setup() {
    	
        driver = new EdgeDriver();
        driver.get("https://demo.guru99.com/Security/SEC_V1/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
