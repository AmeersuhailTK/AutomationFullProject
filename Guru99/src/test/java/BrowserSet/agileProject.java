package BrowserSet;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class agileProject {

    public WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.get("https://demo.guru99.com/Agile_Project/Agi_V1/");
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
