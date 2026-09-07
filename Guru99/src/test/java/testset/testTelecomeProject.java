package testset;

import org.testng.annotations.Test;

import BrowserSet.telicomePRoject;
import PagesSet.pageTelicomeProject;

public class testTelecomeProject extends telicomePRoject{
	
	public static String customerId;
	
	@Test(priority = 1)
	public void addCustomerTest() {
		pageTelicomeProject page = new pageTelicomeProject(driver);

		Boolean status = page.isButtonClickable(page.resetbutton());
		if(status) {
			System.out.println("Button Clicked");
		}else {
			System.out.println("Button not working");
		}
	
		String title = page.getPagetitles();
		System.out.println("Page Title: " + title);

		if (page.isLogoDisplayed()) {
			System.out.println("Logo image is displayed.");
		} else {
			System.out.println("Logo image is NOT displayed.");
		}
	        
		page.addcustomer();
		page.selectBackground("Pending");
		page.fillCustomerForm("Joe", "Samuel", "andres@test.com",
	                          "Kochi", "1234567890");
		page.submitCustomerForm();
	        
		customerId = page.idget().trim();
		System.out.println("Generated Customer ID: " + customerId);
	        
		page.home();
	          
	}
	
	@Test(priority = 2)
	public void addTariffPlanTest() {
		pageTelicomeProject page = new pageTelicomeProject(driver);

		page.tariffplan();
		page.resetTariffPlan();
	    page.fillTariffPlan("600", "350", "50", "100", "1", "5", "1");
	    page.submitTariffPlan();
	    
	    String validationtext = page.textvalidation();
	    System.out.println(validationtext);
	    page.backHome();
	    
	}

	@Test(priority = 3)
	public void addTariffToCustomerTest() {
		pageTelicomeProject page = new pageTelicomeProject(driver);

		page.addTariffToCus();
		
		if(customerId == null || customerId.isEmpty()) {
		    throw new RuntimeException("Customer ID was not generated!");
		}
		
	    page.enterCustomerIdForTariff(customerId);
	    
	    String applied = page.customerIdAddTariff.getAttribute("value");
	    System.out.println("Applied ID: " + applied);

	    page.submitCustomerTariff();
	    
	    page.printTableWithHeadings("//*[@id='main']/div/div/table/tbody");
    
	}
	@Test(priority = 4)
	public void payBillingTest() {
		pageTelicomeProject page = new pageTelicomeProject(driver);

		page.bills();
	    page.enterBillingCustomerId(customerId);
	    page.submitBilling();
	    
	    page.printBillingTable("//*[@id='main']/div/div/table/tbody");

	}

}