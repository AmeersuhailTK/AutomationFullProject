package testset;

import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSet.paymentGateWay;
import PagesSet.pagePaymentGateWay;

public class testPaymentGateWay extends paymentGateWay{

    pagePaymentGateWay pg;

    @Test(priority = 2)
    public void verifyProductImageDisplayed() {
    	 pg = new pagePaymentGateWay(driver);

         Assert.assertTrue(pg.isProductImageDisplayed(),
                 "Product image is NOT displayed on the product page");
       
    }
    
    @Test(priority = 1)
    public void credicard() {
    	pg = new pagePaymentGateWay(driver);
    	pg.clickGenerateCard();
    	pg.switchBackToMainTab();
    	
    }

    @Test(priority = 3)
    public void verifyBuyNowProcess() {
    	pg = new pagePaymentGateWay(driver);
    	
        pg.setQuantity("2");
        pg.clickBuyNow();
    }

    @Test(priority = 4)
    public void verifyCardDetailsAutoFill() {
        pg = new pagePaymentGateWay(driver);

        // This method:
        // 1. Opens Generate Card tab
        // 2. Extracts card number, CVV, expiry
        // 3. Switches back to main tab
        // 4. Fills payment form
        pg.autoFillPaymentDetails();
        pg.clickPay();
    }

    @Test(priority = 5)
    public void verifyPaymentSubmission() {
        pg = new pagePaymentGateWay(driver);

        pg.clickPay();
        pg.paymentSucessful();
    }
}
