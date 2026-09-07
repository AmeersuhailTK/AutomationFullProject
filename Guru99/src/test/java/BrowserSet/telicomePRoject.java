package BrowserSet;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class telicomePRoject {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}