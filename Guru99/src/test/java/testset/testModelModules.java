package testset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSet.moduleodels;

public class testModelModules extends moduleodels {


	    @Test(priority = 1)
	    public void verifySocialIcons() {

	    	
	    	WebElement email = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[1]"));
	    	Assert.assertEquals(email.getAttribute("href"), 
	                    "https://www.guru99.com/newsletters.html");
	    	email.click();
	    	driver.navigate().back();
	   
	        
	    	WebElement google = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[2]"));
	    	Assert.assertEquals(google.getAttribute("href"), 
	                    "https://www.guru99.com/");
	    	google.click();
	    	driver.navigate().back();

	    	
	    	WebElement youtube = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[3]"));
	    	Assert.assertEquals(youtube.getAttribute("href"), 
	                    "https://www.youtube.com/user/guru99com");
	    	youtube.click();
	    	driver.navigate().back();

	    	
	    	WebElement github = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[4]"));
	    	Assert.assertEquals(github.getAttribute("href"), 
	    			"https://www.guru99.com/");
	    	github.click();
	    	driver.navigate().back();

	    	
	    	WebElement facebook = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[5]"));
	    	Assert.assertEquals(facebook.getAttribute("href"), 
	    			"https://www.facebook.com/Guru99Official");
	    	facebook.click();
	    	driver.navigate().back();

	       
	    	WebElement rss = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[6]"));
	    	Assert.assertEquals(rss.getAttribute("href"), 
	                    "https://www.guru99.com/");
	    	rss.click();
	    	driver.navigate().back();
	    }
	    
	    @Test(priority = 2)
	    public void dragNdrop() {
	    	
	    	WebElement click = driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/a"));
	    	click.click();
	    	
	    	WebElement dragTo = driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[19]/a"));
	    	dragTo.click();
	    	
	    	Actions act = new Actions(driver);
	  	  
	  	  driver.navigate().to("https://demo.guru99.com/test/drag_drop.html");
	  	  WebElement fromD = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
	  	  WebElement toD = driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
	  	  
	  	  act.dragAndDrop(fromD, toD).perform();
	  	  
	  	  WebElement fromC = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
	  	  WebElement toC = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
	  	  
	  	  act.dragAndDrop(fromC, toC).perform();
	  	 
	  	  WebElement from1 = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
	  	  WebElement to1 = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
	  	  
	  	  act.dragAndDrop(from1, to1).perform();
	  	  
	  	  WebElement from2 = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
	  	  WebElement to2 = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
	  	  
	  	  act.dragAndDrop(from2, to2).perform();
	  	
		}
}