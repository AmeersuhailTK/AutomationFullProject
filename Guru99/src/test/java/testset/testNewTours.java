package testset;

import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSet.newTours;
import PagesSet.pageNewTours;

public class testNewTours extends newTours{

    @Test(priority = 1)
    public void login() {
    	pageNewTours page = new pageNewTours(driver);
    	page.login();
    	
    	String expected = "Login Successfully";
    	String actual = page.getLoginSuccessMessage();

    	Assert.assertEquals(actual, expected, "Login success message mismatch!");
    	System.out.println(actual);
    	page.back(driver);
    }


    @Test(priority = 2)
    public void testRegisterForm() {
    	pageNewTours page = new pageNewTours(driver);
    	page.registerForm();
    	page.back(driver);

    	
    }

    @Test(priority = 3)
    public void flightFinder () {
        pageNewTours page = new pageNewTours(driver);
        
        page.fillFlightFinder();
        page.back(driver);
        
   }
}
