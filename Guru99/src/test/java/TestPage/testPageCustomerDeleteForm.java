package TestPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserSetup.customerDeletionForm;

public class testPageCustomerDeleteForm extends customerDeletionForm {

    
    @DataProvider(name = "customerIds")
    public Object[][] customerIds() {
        return new Object[][]{
                {"1001"},
                {"12345"},
                {"99999"}
        };
    }

    @Test(dataProvider = "customerIds", priority = 1)
    public void deleteCustomer(String id) throws InterruptedException {
    	
    	
    	driver.findElement(By.name("res")).click();
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	WebElement uname = driver.findElement(By.name("cusid"));
        js.executeScript("arguments[0].value = arguments[1];", uname, id);
          
        //shadow elements locator
        WebElement submit = (WebElement) js.executeScript(
        	    "return document.querySelector('input[type=submit]');"); 
        submit.click();
        

        Alert alert = driver.switchTo().alert();
        Thread.sleep(4000);
        alert.accept();
       
    }
    
    @Test(priority = 2)
    public void yahoo(){
    	
    	WebElement seleniumnext  = driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a"));
    	seleniumnext.click();
    	
    	WebElement yahooclick = driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[8]/a"));
    	yahooclick.click();
    	
    }
    
    
    private final String baseUrl = "https://demo.guru99.com/test/yahoo.html";
    
    @Test(priority = 3)
    public void verifyPageTitleAndUrl() {
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        Assert.assertFalse(title.contains("Selenium Webdriver Test"), "Title does not contain expected text.");
        Assert.assertEquals(currentUrl, baseUrl, "URL is not as expected.");
    }

    @Test(priority = 4)
    public void verifyDemoBannerText() {
        WebElement banner = driver.findElement(By.xpath("//strong[text()='This is DEMO site for TESTING purpose']"));
        Assert.assertTrue(banner.isDisplayed(), "Demo banner is not displayed.");
    }

    @Test(priority = 5)
    public void verifyHeroSection() {
        WebElement logo = driver.findElement(By.xpath("(//img[contains(@alt,'Yahoo! Messenger')])[1]"));
        WebElement slogan = driver.findElement(By.id("hdr2"));
        WebElement downloadButton = driver.findElement(By.xpath("//a[contains(text(),'Download Now')]"));

        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed.");
        Assert.assertTrue(slogan.isDisplayed(), "Slogan is not displayed.");
        Assert.assertTrue(downloadButton.isDisplayed(), "Download button is not displayed.");
        Assert.assertTrue(downloadButton.isEnabled(), "Download button is not enabled.");
    }

    @Test(priority = 6)
    public void verifyMainHeading() {
        WebElement heading = driver.findElement(By.xpath("//*[@id=\"yCarousel\"]/ol/li[1]/h3"));
        Assert.assertTrue(heading.isDisplayed(), "Main heading is not displayed.");
    }

}
