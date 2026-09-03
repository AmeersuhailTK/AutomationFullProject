package testset;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserSet.bankProject;

public class testBankproject extends bankProject {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"mngr123456", "password123", "invalid"},
            {"", "", "invalid"},
            {"mngr665910", "AjaqAhe", "valid"}
        };
    }
    
    @Test(dataProvider = "loginData", priority = 1)
    public void loginTest(String username, String password, String expectedType) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        
        driver.findElement(By.name("btnLogin")).click();
        
        String expectedURL = "https://demo.guru99.com/V1/html/Managerhomepage.php";

        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            
            System.out.println("Alert appeared: " + alertText);
            
            WebElement reset = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnReset")));
            Assert.assertTrue(reset.isEnabled(), "Reset button is not enabled");
            reset.click();

            Assert.assertEquals(expectedType, "invalid",
                    "Expected invalid login but alert appeared for valid credentials");

        } catch (NoAlertPresentException e) {

            String actualURL = driver.getCurrentUrl();
            System.out.println("Login success. URL: " + actualURL);

            Assert.assertEquals(expectedType, "valid",
                    "Expected valid login but no alert appeared");

           Assert.assertEquals(actualURL, expectedURL,
                    "Manager Home Page URL did NOT match!");
            
            System.out.println("Manager Home Page opened successfully!");
        }
    }

    @Test(priority = 2)
    public void newcustomer() {
        
        WebElement newcustomer = driver.findElement(By.linkText("New Customer"));
        newcustomer.click();
        
        WebElement reset = driver.findElement(By.xpath("//input[@type='reset']"));
        WebElement cname = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement radio = driver.findElement(By.name("rad1"));
        WebElement textarea = driver.findElement(By.name("addr"));
        WebElement street = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement pincode = driver.findElement(By.name("pinno"));
        WebElement telle = driver.findElement(By.name("telephoneno"));
        WebElement email = driver.findElement(By.name("emailid"));
        WebElement submit = driver.findElement(By.name("sub"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("arguments[0].click();", reset); 
        js.executeScript("arguments[0].value='Joesamuel';", cname);
        js.executeScript("arguments[0].click();", radio);
 
        js.executeScript("arguments[0].value='2002-12-13';", driver.findElement(By.id("dob")));

        js.executeScript("arguments[0].value='adresssssss....';", textarea);
        js.executeScript("arguments[0].value='bobay11';", street);
        js.executeScript("arguments[0].value='kerala';", state);
        js.executeScript("arguments[0].value='676767';", pincode);
        js.executeScript("arguments[0].value='1234567890';", telle);
        js.executeScript("arguments[0].value='joesamuel@gmail.com';", email);
        String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        js.executeScript("arguments[0].value='" + uniqueEmail + "';", email);

        js.executeScript("arguments[0].click();", submit);
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert appeared");
        }

        js.executeScript("window.history.back();");
        
         

    }

   
    @Test(priority = 3)
    public void editcustomer() {

    	driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
        driver.findElement(By.name("cusid")).sendKeys("1303");
        driver.findElement(By.name("AccSubmit")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.back();");
        WebElement reset = driver.findElement(By.xpath("//input[@type='reset']"));
        js.executeScript("arguments[0].click();", reset);
       
    }

   
    @Test(priority = 4)
    public void deletecustomer() {

        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[4]/a")).click();
        driver.findElement(By.name("cusid")).sendKeys("1303");
        driver.findElement(By.name("AccSubmit")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.history.back();");
        WebElement reset = driver.findElement(By.name("res"));
        js.executeScript("arguments[0].click();", reset);
    }

       @Test(priority = 5)
    public void newaccount() {

    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 
    	 WebElement newAcount = driver.findElement(By.linkText("New Account"));
         js.executeScript("arguments[0].scrollIntoView(true);", newAcount);
         js.executeScript("arguments[0].click();", newAcount);
        
        
        driver.findElement(By.name("cusid")).sendKeys("1303");

        WebElement type = driver.findElement(By.name("selaccount"));
        Select ty = new Select(type);
        ty.selectByValue("current");

        driver.findElement(By.name("inideposit")).sendKeys("5000");
        driver.findElement(By.name("button2")).click();
        
       
        js.executeScript("window.history.back();");
        
        WebElement reset = driver.findElement(By.name("reset"));
        js.executeScript("arguments[0].click();", reset);
        
    }

   
    @Test(priority = 6)
    public void deleteaccount() {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
        WebElement delete = driver.findElement(By.linkText("Delete Account"));
        js.executeScript("arguments[0].scrollIntoView(true);", delete);
        js.executeScript("arguments[0].click();", delete);
        driver.findElement(By.name("accountno")).sendKeys("1303");
        driver.findElement(By.name("AccSubmit")).click();
        
        js.executeScript("window.history.back();");
      
        WebElement reset = driver.findElement(By.name("res"));
        js.executeScript("arguments[0].click();", reset);
    }

   
    @Test(priority = 7)
    public void ministatement() {

    	JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement statement = driver.findElement(By.linkText("Mini Statement"));
        js.executeScript("arguments[0].scrollIntoView(true);", statement);
        js.executeScript("arguments[0].click();", statement);
        driver.findElement(By.name("accountno")).sendKeys("1303");
        driver.findElement(By.name("AccSubmit")).click();
        
        js.executeScript("window.history.back();");
        
        WebElement reset = driver.findElement(By.name("res"));
        js.executeScript("arguments[0].click();", reset);
    }
}