package PagesSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageBankProject {  

    WebDriver driver;

    // ---------------- LOGIN PAGE ----------------
    @FindBy(name = "uid") WebElement username;
    @FindBy(name = "password") WebElement password;
    @FindBy(name = "btnLogin") WebElement loginBtn;
    @FindBy(name = "btnReset") WebElement resetBtn;

    // ---------------- MANAGER HOME LINKS ----------------
    @FindBy(linkText = "New Customer") WebElement newCustomerLink;
    @FindBy(linkText = "Edit Customer") WebElement editCustomerLink;
    @FindBy(linkText = "Delete Customer") WebElement deleteCustomerLink;
    @FindBy(linkText = "New Account") WebElement newAccountLink;
    @FindBy(linkText = "Delete Account") WebElement deleteAccountLink;
    @FindBy(linkText = "Mini Statement") WebElement miniStatementLink;

    // ---------------- NEW CUSTOMER PAGE ----------------
    @FindBy(name = "name") WebElement custName;
    @FindBy(name = "rad1") WebElement genderMale;
    @FindBy(name = "dob") WebElement dob;
    @FindBy(name = "addr") WebElement address;
    @FindBy(name = "city") WebElement city;
    @FindBy(name = "state") WebElement state;
    @FindBy(name = "pinno") WebElement pin;
    @FindBy(name = "telephoneno") WebElement phone;
    @FindBy(name = "emailid") WebElement email;
    @FindBy(name = "sub") WebElement submitCustomer;
    @FindBy(name = "res") WebElement resetCustomer;

    // ---------------- EDIT CUSTOMER PAGE ----------------
    @FindBy(name = "cusid") WebElement customerID;
    @FindBy(name = "AccSubmit") WebElement accSubmit;

    // ---------------- NEW ACCOUNT PAGE ----------------
    @FindBy(name = "selaccount") WebElement accountType;
    @FindBy(name = "inideposit") WebElement initialDeposit;
    @FindBy(name = "button2") WebElement submitAccount;
    @FindBy(name = "reset") WebElement resetAccount;

    // ---------------- DELETE ACCOUNT PAGE ----------------
    @FindBy(name = "accountno") WebElement accountNo;

    public pageBankProject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---------------- LOGIN ACTIONS ----------------
    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public void clickReset() {
        resetBtn.click();
    }

    // ---------------- NAVIGATION ACTIONS ----------------
    public void openNewCustomer() { newCustomerLink.click(); }
    public void openEditCustomer() { editCustomerLink.click(); }
    public void openDeleteCustomer() { deleteCustomerLink.click(); }
    public void openNewAccount() { newAccountLink.click(); }
    public void openDeleteAccount() { deleteAccountLink.click(); }
    public void openMiniStatement() { miniStatementLink.click(); }

    // ---------------- NEW CUSTOMER ACTIONS ----------------
    public void fillNewCustomerForm(String cname, String dobValue, String addr,
                                    String cityValue, String stateValue,
                                    String pinValue, String phoneValue, String emailValue) {

        custName.sendKeys(cname);
        genderMale.click();
        dob.sendKeys(dobValue);
        address.sendKeys(addr);
        city.sendKeys(cityValue);
        state.sendKeys(stateValue);
        pin.sendKeys(pinValue);
        phone.sendKeys(phoneValue);
        email.sendKeys(emailValue);
    }

    public void submitNewCustomer() { submitCustomer.click(); }
    public void resetNewCustomer() { resetCustomer.click(); }

    // ---------------- EDIT CUSTOMER ACTIONS ----------------
    public void editCustomer(String id) {
        customerID.sendKeys(id);
        accSubmit.click();
    }

    // ---------------- NEW ACCOUNT ACTIONS ----------------
    public void createNewAccount(String id, String type, String deposit) {
        customerID.sendKeys(id);
        new Select(accountType).selectByValue(type);
        initialDeposit.sendKeys(deposit);
        submitAccount.click();
    }

    public void resetNewAccount() { resetAccount.click(); }

    // ---------------- DELETE ACCOUNT ACTIONS ----------------
    public void deleteAccount(String acc) {
        accountNo.sendKeys(acc);
        accSubmit.click();
    }
}