package TestPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserSetup.LoginForRegistered;
import ExcelUtlity.pageExcelutils;
import PageSetup.PageLoginForRegistered;

public class TestLoginForRegistered extends LoginForRegistered {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws Exception {
        pageExcelutils.setExcelFile("testdata/LoginData.xlsx", "Sheet1");
        return pageExcelutils.getSheetData();
    }

    @Test
    public void verifyLoginPageUI() {
        PageLoginForRegistered lp = new PageLoginForRegistered(driver);

        Assert.assertTrue(lp.isEmailDisplayed());
        Assert.assertTrue(lp.isPasswordDisplayed());
        Assert.assertTrue(lp.isForgotPasswordDisplayed());
        Assert.assertTrue(lp.isSignInDisplayed());
    }

    @Test(dataProvider = "loginData")
    public void loginFunctionality(String email, String password) {
        PageLoginForRegistered lp = new PageLoginForRegistered(driver);
        lp.login(email, password);

        boolean isErrorDisplayed = driver.getPageSource().contains("Invalid");

        if (email.isEmpty() || password.isEmpty()) {
            Assert.assertTrue(isErrorDisplayed);
        } 
        else if (email.equals("valid@test.com") && password.equals("Valid123")) {
            Assert.assertFalse(isErrorDisplayed);
        }
        else {
            Assert.assertTrue(isErrorDisplayed);
        }
    }

    @Test
    public void verifyForgotPasswordNavigation() {
        PageLoginForRegistered lp = new PageLoginForRegistered(driver);
        lp.forgotPasswordLink.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("forgot"));
    }

    @Test
    public void verifyPasswordMasking() {
        PageLoginForRegistered lp = new PageLoginForRegistered(driver);
        lp.passwordField.sendKeys("Test123");

        Assert.assertEquals(lp.passwordField.getAttribute("type"), "passwd");
    }
}
