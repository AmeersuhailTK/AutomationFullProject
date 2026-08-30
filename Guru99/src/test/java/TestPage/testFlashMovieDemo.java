package TestPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSetup.flahDemo;
import PageSetup.pageFlashDemo;

public class testFlashMovieDemo extends flahDemo {

    @Test
    public void verifyTexts() {
        setup();
        pageFlashDemo fp = new pageFlashDemo(driver);
        
        Assert.assertEquals(true, true,"Flash Movie Demo");
        Assert.assertTrue(fp.JShMessage().isDisplayed(), "Flash unsupported message not displayed");
        Assert.assertTrue(fp.HeadText().isDisplayed(), "DEMO Flash Movie");
        Assert.assertTrue(fp.footer().isDisplayed(),"Copyright text displayed - PASS");
        
        tearDown();
        
    }

    @Test
    public void verifyButtonsClickable() {
       setup();      
       pageFlashDemo fp = new pageFlashDemo(driver);

        fp.playBtn().click();
        fp.stopBtn().click();
        fp.zoomInBtn().click();
        fp.zoomOutBtn().click();

        tearDown();
    }
    
    @Test
    public void validateLinks() {
    	setup();
    	
    	 pageFlashDemo fp = new pageFlashDemo(driver);
    	
    	Assert.assertNotNull(fp.footer(), "LinkedIn element is null");
        
    	Assert.assertEquals(fp.linkedin().getAttribute("href"),
                "https://www.linkedin.com/company/guru99/",
                "LinkedIn URL mismatch");
        
        Assert.assertNotNull(fp.twitter(), "Twitter element is null");
        
        Assert.assertEquals( fp. newsletter().getAttribute("href"), 
        		"https://www.guru99.com/newsletters.html", "Newsletter URL mismatch"  );
        
        
        
        tearDown();
    }
    
    @Test
    public void validateImageDisplayed() {
    	setup();
    	pageFlashDemo fp = new pageFlashDemo(driver);

        Assert.assertTrue((fp.getallImage(0)).isDisplayed(), "Image is NOT displayed");
        System.out.println("Image is displayed - PASS");
        
        tearDown();
            
        }

}
