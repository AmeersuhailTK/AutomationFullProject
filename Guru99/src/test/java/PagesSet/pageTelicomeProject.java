package PagesSet;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageTelicomeProject {
	
    WebDriver driver;

    public pageTelicomeProject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ADD CUSTOMER PAGE    
    @FindBy(linkText = "Guru99 telecom")
    WebElement pagetitle;
    
    @FindBy(xpath = "//*[@id=\"one\"]/div/div[2]")
    WebElement telecomLogo;
    
    @FindBy(xpath = "//*[@id=\"header\"]/nav/a[1]")
	public
    WebElement clickMenu;
    
    @FindBy(linkText = "Add Customer")
    WebElement addcustomerpage;

    @FindBy(xpath = "//label[text()='Done']")
    WebElement bgDone;

    @FindBy(xpath = "//label[text()='Pending']")
    WebElement bgPending;

    @FindBy(id = "fname")
    WebElement firstName;

    @FindBy(id = "lname")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(name = "addr")
    WebElement address;

    @FindBy(id = "telephoneno")
    WebElement mobile;

    @FindBy(name = "submit")
    WebElement addCustomerSubmit;
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/table/tbody/tr[1]/td[2]")
    WebElement idNew;
    
    @FindBy(className = "button")
    WebElement returnHome;

    @FindBy(name = "reset")
    WebElement addCustomerReset;
    
    public boolean isButtonClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();   
            return true;       
        } catch (Exception e) {
            return false;      
        }
    }
 
    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    
    public void clickWithWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.click();
    }

    public String getPagetitles() {
        return driver.getTitle();
    }
    
    public boolean isLogoDisplayed() {
        return telecomLogo.isDisplayed();
    }
    
    public void menuclick() {
    	clickMenu.click();
    }
    
    public void addcustomer() {
    	addcustomerpage.click();
    }
    
    public void home() {
    	returnHome.click();
    }

    public String idget() {
    	return idNew.getText();
    }
    
    public void selectBackground(String status) {
        if (status.equalsIgnoreCase("Done"))
            bgDone.click();
        else
            bgPending.click();
    }

    public void fillCustomerForm(String fname, String lname, String mail,
                                 String addr, String mob) {

    	
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        email.sendKeys(mail);
        address.sendKeys(addr);
        mobile.sendKeys(mob);
    }

    public void submitCustomerForm() {
        addCustomerSubmit.click();
    }
    public WebElement resetbutton() {
    	return addCustomerReset;
    }

    // ADD TARIFF PLAN PAGE
    
    @FindBy(linkText = "Add Tariff Plan")
    WebElement addTariff;
    
    @FindBy(id = "rental1")
    WebElement monthlyRental;

    @FindBy(id = "local_minutes")
    WebElement freeLocalMinutes;

    @FindBy(id = "inter_minutes")
    WebElement freeInterMinutes;

    @FindBy(id = "sms_pack")
    WebElement freeSmsPack;

    @FindBy(id = "minutes_charges")
    WebElement localCharges;

    @FindBy(id = "inter_charges")
    WebElement interCharges;

    @FindBy(id = "sms_charges")
    WebElement smsCharges;

    @FindBy(name = "submit")
    WebElement tariffSubmit;

    @FindBy(className = "alt")
    WebElement tariffReset;
    
    @FindBy(tagName = "h2")
    WebElement getverify;
    
    @FindBy(className = "button")
    WebElement home1;
    
    public void tariffplan() {
    	addTariff.click();
	}

    public void fillTariffPlan(String rental, String local, String inter,
                               String smsPack, String localC, String interC,
                               String smsC) {

        monthlyRental.sendKeys(rental);
        freeLocalMinutes.sendKeys(local);
        freeInterMinutes.sendKeys(inter);
        freeSmsPack.sendKeys(smsPack);
        localCharges.sendKeys(localC);
        interCharges.sendKeys(interC);
        smsCharges.sendKeys(smsC);
    }

    public void submitTariffPlan() {
        tariffSubmit.click();
    }

    public void resetTariffPlan() {
        tariffReset.click();
    }
    
    public String textvalidation() {
    	return getverify.getText();
    }
    
    public void backHome() {
    	home1.click();
    }

    // ADD TARIFF PLAN TO CUSTOMER PAGE
    
    @FindBy(linkText = "Add Tariff Plan to Customer")
    WebElement addTariffToCustomer;
    
    @FindBy(id = "customer_id")
    public WebElement customerIdAddTariff;

    @FindBy(name = "submit")
    WebElement addTariffToCustomerSubmit;
    
    public void addTariffToCus() {
    	addTariffToCustomer.click();
    }

    public void enterCustomerIdForTariff(String id) {
        customerIdAddTariff.sendKeys(id);
    }

    public void submitCustomerTariff() {
        addTariffToCustomerSubmit.click();
    }
    public void printTableWithHeadings(String tableXpath) {

    	// Print headings
    	List<WebElement> headings = driver.findElements(By.xpath(tableXpath + "/tr/th"));
        System.out.println("===== TABLE HEADINGS =====");
        for (WebElement h : headings) {
            System.out.print(h.getText() + "   ");
        }
        System.out.println("\n==========================");

        // Print rows + columns
        List<WebElement> rows = driver.findElements(By.xpath(tableXpath + "/tr"));
        int rowCount = rows.size();

        System.out.println("===== TABLE DATA =====");
        for (int r = 2; r <= rowCount; r++) {   // start from row 2 (row 1 = headings)

            List<WebElement> cols = driver.findElements(By.xpath(tableXpath + "/tr[" + r + "]/td"));
            int colCount = cols.size();

            for (int c = 1; c <= colCount; c++) {
                String cellText = driver.findElement(By.xpath(tableXpath + "/tr[" + r + "]/td[" + c + "]")).getText();
                System.out.print(cellText + "   ");
            }

            System.out.println();
        }
        System.out.println("=======================");
    }

    // PAY BILLING PAGE
    
    @FindBy(linkText = "Pay Billing")
    WebElement payBill;
    
    @FindBy(id = "customer_id")
    WebElement billingCustomerId;

    @FindBy(name = "submit")
    WebElement billingSubmit;
    
    public void bills() {
    	payBill.click();
    }

    public void enterBillingCustomerId(String id) {
        billingCustomerId.sendKeys(id);
    }

    public void submitBilling() {
        billingSubmit.click();
    }
    
    public void printBillingTable(String tableXpath) {

        // Print headings
        List<WebElement> headings = driver.findElements(By.xpath(tableXpath + "/tr/th"));
        System.out.println("===== BILLING TABLE HEADINGS =====");
        for (WebElement h : headings) {
            System.out.print(h.getText() + "   ");
        }
        System.out.println("\n==================================");

        // Print rows
        List<WebElement> rows = driver.findElements(By.xpath(tableXpath + "/tr"));
        int rowCount = rows.size();

        System.out.println("===== BILLING TABLE DATA =====");
        for (int r = 2; r <= rowCount; r++) {   // row 1 = headings

            List<WebElement> cols = driver.findElements(By.xpath(tableXpath + "/tr[" + r + "]/td"));
            int colCount = cols.size();

            for (int c = 1; c <= colCount; c++) {
                String cellText = driver.findElement(By.xpath(tableXpath + "/tr[" + r + "]/td[" + c + "]")).getText();
                System.out.print(cellText + "   ");
            }

            System.out.println();
        }
        System.out.println("==================================");
    }

}
