package PagesSet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageSecurityProject {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public pageSecurityProject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    // LOGIN LOCATORS
    By userId = By.name("uid");
    By pswd = By.name("password");
    By loginBtn = By.name("btnLogin");
    By resetBtn = By.name("btnReset");

    public boolean login(String ID, String password) {
        driver.findElement(userId).sendKeys(ID);
        driver.findElement(pswd).sendKeys(password);
        driver.findElement(loginBtn).click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.findElement(resetBtn).click();
            return false;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }

    // DASHBOARD LOCATORS
    By welcomeMsg = By.xpath("//marquee[@class='heading3']");
    By dashboardImages = By.xpath("//img");

    // SPECIFIC 3 IMAGES
    By imgOne = By.xpath("/html/body/table/tbody/tr/td/center/img[1]");
    By imgTwo = By.xpath("/html/body/table/tbody/tr/td/center/img[2]");
    By imgThree = By.xpath("/html/body/table/tbody/tr/td/center/img[3]");

    public boolean validateWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));
        return driver.findElement(welcomeMsg).isDisplayed();
    }

    public boolean validateSpecificImages() {
        return driver.findElement(imgOne).isDisplayed() &&
               driver.findElement(imgTwo).isDisplayed() &&
               driver.findElement(imgThree).isDisplayed();
    }

    // NAVIGATION
    public void goBack() {
        driver.navigate().back();
    }

    public void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void scrollTo(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // BALANCE ENQUIRY
    By balanceMenu = By.linkText("Balance Enquiry");
    By balanceAccount = By.name("accountno");
    By balanceSubmit = By.name("AccSubmit");

    public void openBalanceEnquiry() {
        scrollTo(balanceMenu);
        jsClick(balanceMenu);
    }

    public void selectBalanceAccount(String acc) {
        driver.findElement(balanceAccount).sendKeys(acc);
    }

    public void submitBalanceEnquiry() {
        driver.findElement(balanceSubmit).click();
        goBack();   // REQUIRED
    }

    // MINI STATEMENT
    By miniMenu = By.linkText("Mini Statement");
    By miniAccount = By.name("accountno");
    By miniSubmit = By.name("AccSubmit");

    public void openMiniStatement() {
        scrollTo(miniMenu);
        jsClick(miniMenu);
    }

    public void selectMiniAccount(String acc) {
        driver.findElement(miniAccount).sendKeys(acc);
    }

    public void submitMiniStatement() {
        driver.findElement(miniSubmit).click();
        goBack();   // REQUIRED
    }

    // CONTACT US
    By contactMenu = By.linkText("Contact Us");
    By contactName = By.name("name");
    By contactEmail = By.name("emailid");
    By contactMobile = By.name("telephoneno");
    By contactMessage = By.name("addr");
    By contactUpload = By.name("fileToUpload");
    By contactSubmit = By.name("sub");
    By resetbtn = By.name("reset");

    public void uploadContact(String filePath) {

        WebElement upload = wait.until(
                ExpectedConditions.presenceOfElementLocated(contactUpload)
        );

        upload.sendKeys(filePath);
    }
    public void openContactUs() {
        scrollTo(contactMenu);
        jsClick(contactMenu);
        
    }

    public void fillContactForm(String name, String email, String mobile, String msg) {
        driver.findElement(contactName).sendKeys(name);
        driver.findElement(contactEmail).sendKeys(email);
        driver.findElement(contactMobile).sendKeys(mobile);
        driver.findElement(contactMessage).sendKeys(msg);
    }

    public void uploadContactFile(String filePath) {
       driver.findElement(contactUpload)
       .sendKeys(filePath);
    }

    public void submitContactForm() {
        driver.findElement(contactSubmit).click();
        goBack();   // REQUIRED
    }
    public void resetclick() {
    	driver.findElement(resetBtn).click();
    }
     public void logout() {
    	 By logout= By.linkText("Log out");
		 driver.findElement(logout).click();
     }
}
