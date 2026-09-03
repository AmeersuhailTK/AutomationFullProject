package testset;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserSet.securityProject;
import PagesSet.pageSecurityProject;

public class testSecurityProject extends securityProject{

    pageSecurityProject page;

    @Test(priority = 1)
    public void loginTest() {

        page = new pageSecurityProject(driver, wait);

        boolean loginStatus = page.login("1303", "Guru99");

        Assert.assertTrue(loginStatus, "Valid login failed!");
    }

    @Test(priority = 2)
    public void dashboardValidationTest() {

        Assert.assertTrue(page.validateWelcomeMessage(), "Welcome message missing!");
        Assert.assertTrue(page.validateSpecificImages(), "One of the 3 dashboard images is missing!");
    }

    @Test(priority = 3)
    public void balanceEnquiryTest() {

        page.openBalanceEnquiry();
        page.selectBalanceAccount("3309");
        page.submitBalanceEnquiry();   // includes goBack()
    }

    @Test(priority = 4)
    public void miniStatementTest() {

        page.openMiniStatement();
        page.selectMiniAccount("3309");
        page.submitMiniStatement();    // includes goBack()
    }

    @Test(priority = 5)
    public void contactUsTest() {

        page.openContactUs();
        page.fillContactForm("Joesamuel", "andres@gmail.com", "12345678990", "adress.....");
        page.uploadContactFile("D:\\Automation Testing sessions\\Entri Assighnments\\Manual & Automation Test Project");
        page.submitContactForm();      // includes goBack()
        
        page.logout();
    }
}