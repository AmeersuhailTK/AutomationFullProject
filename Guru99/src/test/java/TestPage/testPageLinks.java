package TestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSetup.links;

public class testPageLinks extends links{
	
	
	@Test(priority = 1)
	public void firstiLink() {
		setup();
		
		WebElement flink = driver.findElement(By.xpath("(//a[text()='click here'])[1]"));
		flink.click();
		Assert.assertEquals(driver.getTitle().contains("Google"), true);
		
		driver.navigate().back();
		
		Closedown();
		
	}
	
	@Test(priority = 2)
	public void SecondiLink() {
		setup();
		
		WebElement Slink = driver.findElement(By.xpath("(//a[text()='click here'])[2]"));
		Slink.click();
		Assert.assertEquals(driver.getTitle().contains("Google"), false);
		
		driver.navigate().back();
		
		Closedown();
		
	}

}
