package PagesSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLoginForRegistered {

    public WebDriver driver;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    public WebElement signInBtn;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    public PageLoginForRegistered(WebDriver driver) {
        this.driver = driver;   // FIXED
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);

        signInBtn.click();   // FIXED (removed forgotPassword click)
    }

    public boolean isEmailDisplayed() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isForgotPasswordDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isSignInDisplayed() {
        return signInBtn.isDisplayed();
    }
}
