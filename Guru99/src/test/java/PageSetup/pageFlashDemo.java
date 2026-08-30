package PageSetup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageFlashDemo {

    WebDriver driver;

    public pageFlashDemo(WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public String Title() {
		return driver.getTitle();
    	
    }
    public WebElement JShMessage() {
        return driver.findElement(By.xpath("//*[contains(text(),'JavaScript Controller')]"));
    }

    public WebElement HeadText() {
		return driver.findElement(By.xpath("//font[contains(text(),'DEMO Flash Movie')]"));
    
    }
    public WebElement playBtn() {
        return driver.findElement(By.xpath("/html/body/form/center/input[1]"));
    }

    public WebElement stopBtn() {
        return driver.findElement(By.xpath("/html/body/form/center/input[2]"));
    }

    public WebElement zoomInBtn() {
        return driver.findElement(By.xpath("/html/body/form/center/input[3]"));
    }

    public WebElement zoomOutBtn() {
        return driver.findElement(By.xpath("/html/body/form/center/input[4]"));
    }
    
    public WebElement footer() {
    	return driver.findElement(By.xpath("//span[contains(text(),'© Copyright - Demo Guru99 2026')]"));
    }
    
    public WebElement linkedin() {
		return driver.findElement(By.xpath("//a[contains(@href,'linkedin.com')]"));
    }
    
    public WebElement facebook() {
    	WebElement Facebook = driver.findElement(By.xpath("//a[contains(@href,'facebook.com')]"));
		return Facebook;
    }
    
    public WebElement twitter() {
    	return driver.findElement(By.xpath("//a[contains(@href,'twitter.com')]"));
    }

	public WebElement newsletter() {
		return driver.findElement(By.xpath("//a[contains(@href,'newsletters.html')]"));
	}
	
	public WebElement getallImage(int index) {
	    List<WebElement> images = driver.findElements(By.tagName("img"));
	    return images.get(index);
	}


	
   
}
