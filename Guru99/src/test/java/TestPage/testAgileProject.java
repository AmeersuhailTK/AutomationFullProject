package TestPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserSetup.agileProject;
import ExcelUtlity.excelAgileProject;
import PageSetup.pageAgileProject;

public class testAgileProject extends agileProject {

    @DataProvider(name = "AgileTest")
    public Object[][] getData() throws Exception {

        String path = "C:\\Users\\Smart Axis\\eclipse-workspace\\Guru99\\src\\test\\resources\\agileTest.xlsx";

        excelAgileProject.setExcelFile(path, "Sheet1");

        int rowCount = excelAgileProject.getRowCount();
        Object[][] data = new Object[rowCount][2];

        for (int i = 1; i <= rowCount; i++) {
            data[i - 1][0] = excelAgileProject.getCellData(i, 0);
            data[i - 1][1] = excelAgileProject.getCellData(i, 1);
        }

        return data;
    }

    @Test(dataProvider = "AgileTest")
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
}
