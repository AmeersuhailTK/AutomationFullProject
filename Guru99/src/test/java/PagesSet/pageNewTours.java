package PagesSet;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageNewTours {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 
	public pageNewTours(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="userName") WebElement loginUser;
    @FindBy(name="password") WebElement loginPass;
    @FindBy(name="submit") WebElement loginBtn;
    @FindBy(xpath = "//h3[text()='Login Successfully']") WebElement loginSuccessMsg;
    
    public void login() {
        loginUser.sendKeys("1303");
        loginPass.sendKeys("Guru99");
        loginBtn.click();
        
    }

    public String getLoginSuccessMessage() {
        return loginSuccessMsg.getText();
    }
    
    @FindBy(linkText="REGISTER") WebElement registerLink;
    @FindBy(name="firstName") WebElement firstName;
    @FindBy(name="lastName") WebElement lastName;
    @FindBy(name="phone") WebElement phone;
    @FindBy(id ="userName") WebElement email;
    @FindBy(name="address1") WebElement address;
    @FindBy(name="city") WebElement city;
    @FindBy(name="state") WebElement state;
    @FindBy(name="postalCode") WebElement postalCode;
    @FindBy(name= "country") WebElement country;
    @FindBy(name="email") WebElement regUser;
    @FindBy(name="password") WebElement regPass;
    @FindBy(name="confirmPassword") WebElement regConfirm;
    @FindBy(name="submit") WebElement regSubmit;
    
    public void registerForm() {
    	registerLink.click();
    	firstName.sendKeys("JOE");
    	lastName.sendKeys("Samuel");
    	phone.sendKeys("1234567890");
    	email.sendKeys("andres@gmail.com");
    	address.sendKeys("rome");
    	city.sendKeys("Scecili");
    	state.sendKeys("Italy");
    	postalCode.sendKeys("223344");
    	
    	Select sl = new Select(country);
    	sl.selectByValue("BARBADOS");
    	regUser.sendKeys("1303");
    	
    	regPass.sendKeys("Guru99");
    	regConfirm.sendKeys("Guru99");
    	regSubmit.click();
    	WebElement submitBtn = wait.until(
    	        ExpectedConditions.elementToBeClickable(regSubmit)
    	);

    	submitBtn.click();
    	
    }
    
    public boolean titleContains(String expectedText) {
        wait.until(ExpectedConditions.titleContains(expectedText));
        return driver.getTitle().contains(expectedText);
    }
   
    @FindBy(linkText = "Flights") WebElement flights;
    @FindBy(xpath = "//input[@value='roundtrip']") WebElement oneway;
    @FindBy(name="passCount") WebElement passengers;
    @FindBy(name="fromPort") WebElement fromPort;
    @FindBy(name="fromMonth") WebElement fromMonth;
    @FindBy(name="fromDay") WebElement fromDay;
    @FindBy(name="toPort") WebElement toPort;
    @FindBy(name="toMonth") WebElement toMonth;
    @FindBy(name="toDay") WebElement toDay;
    @FindBy(name= "toMonth") WebElement Mon;
    @FindBy(name= "toDay") WebElement Day;
    @FindBy(xpath= "//input[@name='servClass'][2]") WebElement radio;
    @FindBy(name="airline") WebElement airline;
    @FindBy(name="findFlights") WebElement continueBtn;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/a")WebElement home;


    public void fillFlightFinder() {
        
        flights.click();

        oneway.click();

        Select count = new Select(passengers);
        count.selectByIndex(3);

        Select dep = new Select(fromPort);
        dep.selectByValue("Frankfurt");

        Select mon = new Select(fromMonth);
        mon.selectByIndex(3);   // ✔️ FIXED

        Select day = new Select(fromDay);
        day.selectByIndex(23);

        Select arrive = new Select(toPort);
        arrive.selectByValue("London");

        Select mon2 = new Select(Mon);
        mon2.selectByIndex(3);

        Select day2 = new Select(Day);
        day2.selectByIndex(26);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", continueBtn);

        Select air = new Select(airline);
        air.selectByContainsVisibleText("Blue Skies Airlines");

       
        js.executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        js.executeScript("arguments[0].click();", continueBtn);
        
      
        
        }

        public void back(WebDriver driver) {
        	driver.navigate().back();
            
        }
}
