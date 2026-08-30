package TestPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserSetup.radio_Checkbox;
import PageSetup.pageRadio_Checkbox;

public class testRadio_Checkbox extends radio_Checkbox{
	
	@Test
    public void testRadioSelection() {
		setup();
	
        pageRadio_Checkbox rc = new pageRadio_Checkbox(driver);

        rc.clickOption1();
        Assert.assertTrue(rc.option1.isSelected());

        rc.clickOption2();
        Assert.assertTrue(rc.option2.isSelected());
        
        rc.clickOption3();
        Assert.assertTrue(rc.option3.isSelected());
        
        
        tearDown();
    }
	 @Test
	    public void testCheckboxSelection() {
		 setup();
		 
	        pageRadio_Checkbox rc = new pageRadio_Checkbox(driver);

	        rc.selectCheckbox1();
	        Assert.assertTrue(rc.checkbox1.isSelected());
	        
	        rc.selectCheckbox2();
	        Assert.assertTrue(rc.checkbox2.isSelected());
	        
	        rc.selectCheckbox3();
	        Assert.assertTrue(rc.checkbox3.isSelected());
	       
	        
	        
	        tearDown();
	 }
	 @Test
	 public void multtipleSelection() {
		 	setup();
		 	
		 	pageRadio_Checkbox rc = new pageRadio_Checkbox(driver);
		 	
		 	//Checkbox
		 	rc.selectCheckbox1();
	        rc.selectCheckbox2();
	        Assert.assertTrue(rc.checkbox2.isSelected());
	        Assert.assertTrue(rc.checkbox1.isSelected());
	        
	        //Radiobutton
	        rc.clickOption2();
	        Assert.assertTrue(rc.option2.isSelected());
	        Assert.assertFalse(rc.option1.isSelected());
	        
	        tearDown();
		 
	 }
	 
}
