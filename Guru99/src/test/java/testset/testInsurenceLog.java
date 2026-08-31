package testset;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSet.loginPageInsurence;

public class testInsurenceLog extends loginPageInsurence{
	
	@Test(priority = 1)
	public void register() {
		WebElement clickreg = driver.findElement(By.xpath("/html/body/div[3]/a"));
		clickreg.click();
		
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("register"), "URL does not contain expected text!");
	   
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");   // scroll down
		driver.findElement(By.id("resetform")).click();
		js.executeScript("window.scrollBy(0, -500);");  // scroll up
		
		WebElement dropdown = driver.findElement(By.id("user_title"));
		dropdown.click();
		Select act = new Select(dropdown);
		act.selectByValue("Mr");
		
		driver.findElement(By.id("user_firstname")).sendKeys("Joe");
		driver.findElement(By.id("user_surname")).sendKeys("samuel");
		driver.findElement(By.id("user_phone")).sendKeys("1234567890");
		
		WebElement dobY = driver.findElement(By.id("user_dateofbirth_1i"));
		dobY.click();
		Select actY = new Select(dobY);
		actY.selectByValue("1986");
		
		WebElement dobM = driver.findElement(By.id("user_dateofbirth_2i"));
		dobM.click();
		Select actM = new Select(dobM);
		actM.selectByValue("5");
		
		WebElement dobD = driver.findElement(By.id("user_dateofbirth_3i"));
		dobD.click();
		Select actD = new Select(dobD);
		actD.selectByValue("14");
		
		WebElement Tyear = driver.findElement(By.id("user_licenceperiod"));
		Tyear.click();
		
		WebElement radiobtn = driver.findElement(By.id("licencetype_f"));
		radiobtn.click();
		
		Select tY = new Select(Tyear);
		tY.selectByValue("10");
		
		driver.findElement(By.id("user_address_attributes_street")).sendKeys("text me");
		driver.findElement(By.id("user_address_attributes_city")).sendKeys("text me");
		driver.findElement(By.id("user_address_attributes_county")).sendKeys("text me");
		driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("223344");
		driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("joesamuel123@email.com");
		driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("Joe123");
		driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("Joe123");
		
		driver.findElement(By.name("submit")).click();
	}
	
	@Test(priority = 2)
	public void Login() {
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("joesamuel123@email.com");
		
		WebElement pswd = driver.findElement(By.id("password"));
		pswd.sendKeys("Joe123");
		
		WebElement login = driver.findElement(By.name("submit"));
		login.click();
	}
	
	@Test(priority = 3)
	public void dashboard() {
		
		WebElement login = driver.findElement(By.name("submit"));
		login.click();
		
		String actualUrl2 = driver.getCurrentUrl();
		Assert.assertTrue(actualUrl2.contains("header"), "URL does not contain expected text!");
		
		driver.findElement(By.id("ui-id-1")).click();
		
		WebElement title = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/h2"));
		Assert.assertTrue(title.getText().contains("Broker Insurance WebPage"),"Title does not contain expected text!");
		
		driver.findElement(By.id("ui-id-2")).click();
		
		WebElement bdrop = driver.findElement(By.id("quotation_breakdowncover"));
		Select brkd = new Select (bdrop);
		brkd.selectByValue("3");
		brkd.selectByValue("4");

		driver.findElement(By.xpath("//*[@id=\"quotation_windscreenrepair_t\"]")).click();
		
		driver.findElement(By.id("quotation_incidents")).sendKeys("crashes");
		driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys("kl11 q 3434");
		driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys("32000");
		driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys("10000");

		WebElement pal = driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
		Select pl = new Select (pal);
		pl.selectByContainsVisibleText("Public Place");
		
		driver.findElement(By.name("submit")).click();
		
		driver.navigate().back();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -300);");   
		
		WebElement mup = driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]")); 
		mup.click();
		
		WebElement btn = driver.findElement(By.id("resetquote"));
		btn.click();
		
		js.executeScript("window.scrollBy(0, -300);");   
		
		driver.findElement(By.id("ui-id-3")).click();
		
		WebElement mc = driver.findElement(By.id("ui-id-5"));
		Actions ac = new Actions(driver);
		ac.moveToElement(mc).pause(500).click().build().perform();
		
		driver.findElement(By.id("ui-id-5")).click();
		
		driver.findElement(By.id("user_title")).sendKeys("Jo");
		driver.findElement(By.id("user_firstname")).sendKeys("sam");
		driver.findElement(By.id("user_phone")).sendKeys("0987654321");
		
		WebElement dobY1 = driver.findElement(By.id("user_dateofbirth_1i"));
		dobY1.click();
		Select actY1 = new Select(dobY1);
		actY1.selectByValue("1986");
		
		WebElement dobM1 = driver.findElement(By.id("user_dateofbirth_2i"));
		dobM1.click();
		Select actM1 = new Select(dobM1);
		actM1.selectByValue("5");
		
		WebElement dobD1 = driver.findElement(By.id("user_dateofbirth_3i"));
		dobD1.click();
		Select actD1 = new Select(dobD1);
		actD1.selectByValue("14");
		
		driver.findElement(By.id("user_address_attributes_street")).sendKeys("text me");
		driver.findElement(By.id("user_address_attributes_city")).sendKeys("text me");
		driver.findElement(By.id("user_address_attributes_county")).sendKeys("text me");
		driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("221144");
		
		driver.findElement(By.name("commit")).click();
		
	}
}