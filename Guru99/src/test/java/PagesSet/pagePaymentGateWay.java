package PagesSet;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pagePaymentGateWay {

    WebDriver driver;
    WebDriverWait wait;

    public pagePaymentGateWay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   
//  PAGE ELEMENTS – PRODUCT SECTION    
    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[@id='three']/div/form/div/div[1]/p/img")
    private WebElement productImage;

    @FindBy(name = "quantity")
    private WebElement quantity;

    @FindBy(linkText = "Cart")
    private WebElement cartPage;

    @FindBy(xpath = "//input[@value='Buy Now']")
    private WebElement buyNowButton;
    
//    ACTION METHODS – PRODUCT
    public String getPageTitle() {
    	return pageTitle.getText();
    }

    public boolean isProductImageDisplayed() {
    	return productImage.isDisplayed();
    }

    public void setQuantity(String qty) { 
    	quantity.sendKeys(qty);
    }

    public void clickBuyNow() {
    	buyNowButton.click();
    }

 public void openCart() {
     cartPage.click();
 }
 
 // new window open for took value on creditCard 
 	@FindBy(linkText = "Generate Card Number")
    WebElement creditbalncepage;

    @FindBy(xpath = "(//h4)[1]")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "(//h4)[2]")
    private WebElement cvvLabel;

    @FindBy(xpath = "(//h4)[3]")
    private WebElement expDateLabel;
    
    @FindBy(linkText = "Cart")
    WebElement cartpage;
    
//  EXTRACT CARD DATA FROM PAGE NEW WINDOW
    String mainTab;
    String cardTab;
    public void clickGenerateCard() {
        mainTab = driver.getWindowHandle();
        creditbalncepage.click();

        // Wait for new tab to open
//        wait.until(driver -> driver.getWindowHandles().size() > 1);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        cardTab = tabs.get(1);

        driver.switchTo().window(cardTab);
    }

    public void switchBackToMainTab() {
        driver.switchTo().window(mainTab);
    }

 public String getDisplayedCardNumber() {
     return cardNumberLabel.getText()
             .replace("Card Number:- ", "")
             .trim();
 }

 public String getDisplayedCVV() {
     return cvvLabel.getText()
             .replace("CVV:- ", "")
             .trim();
 }

 public String getDisplayedExpMonth() {
     String exp = expDateLabel.getText()
             .replace("Exp:- ", "")
             .trim();
     return exp.split("/")[0];
 }

 public String getDisplayedExpYear() {
     String exp = expDateLabel.getText()
             .replace("Exp:- ", "")
             .trim();
     return exp.split("/")[1];
 }

//    PAGE ELEMENTS – PAYMENT DETAILS
 	@FindBy(id = "card_nmuber")
 	private WebElement cardNumberInput;

 	@FindBy(id = "cvv_code")
 	private WebElement cardCVV;

 	@FindBy(id = "month")
 	private WebElement cardMonth;

 	@FindBy(id = "year")
 	private WebElement cardYear;

 	@FindBy(name = "submit")
 	private WebElement payButton;

 	public void fillPaymentForm(String number, String cvv, String month, String year) {
 		cardNumberInput.sendKeys(number);
 		cardCVV.sendKeys(cvv);

 		new Select(cardMonth).selectByVisibleText(month);
 		new Select(cardYear).selectByVisibleText(year);
 	}
    
    public void clickPay() {
        payButton.click();
    }
 
//  AUTO-FILL PAYMENT FROM CARD PAGE
    public void autoFillPaymentDetails() {

      clickGenerateCard();

      String number = getDisplayedCardNumber();
      String cvv = getDisplayedCVV();
      String month = getDisplayedExpMonth();
      String year = getDisplayedExpYear();

      switchBackToMainTab();
      
      fillPaymentForm(number, cvv, month, year);

  }
    @FindBy(tagName = "h2")
    WebElement id;
    
    public void paymentSucessful() {

        if (id.isDisplayed()) {
            System.out.println("Payment Successful Message: " + id.getText());
        } else {
            System.out.println("Payment message is NOT visible");
        }
    }

}