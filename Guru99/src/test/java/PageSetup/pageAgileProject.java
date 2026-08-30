package PageSetup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pageAgileProject {

    private WebDriver driver;

    private By userIdField = By.name("uid");
    private By passwordField = By.name("password");
    private By loginButton = By.name("btnLogin");
    private By resetButton = By.name("btnReset");

    public pageAgileProject(WebDriver driver) {
        this.driver = driver;   // FIXED
    }

    public void setUserId(String userId) {
        driver.findElement(userIdField).clear();
        driver.findElement(userIdField).sendKeys(userId);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickReset() {
        driver.findElement(resetButton).click();
    }

    public String handleAlertIfPresent() {
        try {
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (Exception e) {
            return null;
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
