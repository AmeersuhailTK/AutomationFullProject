package testset;

import java.net.URL;
import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserSet.agileProject;
import ExceleSet.excelAgileProject;
import PagesSet.pageAgileProject;

public class testAgileProject extends agileProject {

    @DataProvider(name = "AgileTest")
    public Object[][] getData() throws Exception {

        String path = "C:\\Users\\Smart Axis\\git\\repository\\Guru99App\\new\\git\\Guru99\\src\\test\\resources\\agileTest.xlsx";

        excelAgileProject.setExcelFile(path, "Sheet1");

        int rowCount = excelAgileProject.getRowCount();
        Object[][] data = new Object[rowCount][2];

        for (int i = 1; i <= rowCount; i++) {
            data[i - 1][0] = excelAgileProject.getCellData(i, 0);
            data[i - 1][1] = excelAgileProject.getCellData(i, 1);
        }

        return data;
    }

    @Test(dataProvider = "AgileTest", priority = 1)
    public void loginTest(String userId, String password) {

        pageAgileProject loginPage = new pageAgileProject(driver);

        loginPage.setUserId(userId);
        loginPage.setPassword(password);
        loginPage.clickLogin();

        String alertText = loginPage.handleAlertIfPresent();

        if (alertText != null) {
            System.out.println("Alert: " + alertText);
            Assert.assertTrue(alertText.toLowerCase().contains("user") ||
                              alertText.toLowerCase().contains("password"),
                    "Unexpected alert message: " + alertText);
        } else {
            String title = loginPage.getTitle();
            System.out.println("Page title after login: " + title);
            Assert.assertTrue(title.toLowerCase().contains("manager"),
                    "Login might have failed, title: " + title);
        }
    }
    
    @Test(priority = 2)
    public void textvalidation() {
    	
    	driver.findElement(By.name("uid")).sendKeys("1303");
    	driver.findElement(By.name("password")).sendKeys("Guru99");
    	driver.findElement(By.name("btnLogin")).click();
    	
    	WebElement marquee = driver.findElement(By.className("heading3"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;

    	String text = marquee.getText();
    	Assert.assertEquals(text, "Welcome To Customer's Page of Guru99 Bank");

    	// initial position
    	Long x1 = (Long) js.executeScript("return arguments[0].offsetLeft;", marquee);

    	//explicit wait use to check movements
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	Boolean moved = wait.until(driverObj -> {
    	    Long x2 = (Long) js.executeScript("return arguments[0].scrollAmount;", marquee);
    	    return !x1.equals(x2);
    	    }
    	);

    	Assert.assertTrue(moved, "Marquee is not moving");
    }
    
    @Test(priority = 3)
    public void imge() {

    	List<WebElement> images = new ArrayList<>();

    	images.add(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/center/img[1]")));
    	images.add(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/center/img[2]")));
    	images.add(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/center/img[3]")));

    	for (WebElement img : images) {
    	    String url = img.getAttribute("src");

    	    try {
    	        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
    	        connection.setRequestMethod("GET");
    	        connection.connect();

    	        int code = connection.getResponseCode();

    	        if (code == 200) {
    	            System.out.println("200 OK: " + url);
    	        } else {
    	            System.out.println("BROKEN (" + code + "): " + url);
    	        }

    	    } catch (Exception e) {
    	        System.out.println("ERROR: " + url);
    	    }
    	}

    }
    
    	@Test(dependsOnMethods = "imge")
    	public void switchToMiniStatement() {

    	    driver.get("https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php");

    	    
    	    driver.navigate().to("https://demo.guru99.com/Agile_Project/Agi_V1/customer/MiniStatementInput.php");

    	    
    	    String currentURL = driver.getCurrentUrl();
    	    Assert.assertEquals(currentURL,
    	        "https://demo.guru99.com/Agile_Project/Agi_V1/customer/MiniStatementInput.php");
    	    
    	    if (currentURL.contains("MiniStatementInput.php")) {
    	        WebElement drop = driver.findElement(By.name("accountno"));
    	        drop.click();
    	        Select sel = new Select(drop);
    	        sel.selectByContainsVisibleText("3308");
    	        driver.findElement(By.name("AccSubmit")).click();
    	        driver.navigate().back();
    	        driver.findElement(By.name("res")).click();
    	        driver.findElement(By.xpath("/html/body/table/tbody/tr/td/p/a")).click();
    	        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
    	    }		 	
    	}
}
