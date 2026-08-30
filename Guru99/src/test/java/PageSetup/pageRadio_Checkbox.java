package PageSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageRadio_Checkbox {

	    WebDriver driver;

	    public pageRadio_Checkbox(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(id = "vfb-7-1")
	    public WebElement option1;

	    @FindBy(id = "vfb-7-2")
	    public WebElement option2;

	    @FindBy(id = "vfb-7-3")
	    public WebElement option3;
	    
	    @FindBy(id = "vfb-6-0")
	    public WebElement checkbox1;

	    @FindBy(id = "vfb-6-1")
	    public WebElement checkbox2;

	    @FindBy(id = "vfb-6-2")
	    public WebElement checkbox3;
	    
	    public void clickOption1() { option1.click(); }
	    public void clickOption2() { option2.click(); }
	    public void clickOption3() { option3.click(); }

	    public void selectCheckbox1() { checkbox1.click(); }
	    public void selectCheckbox2() { checkbox2.click(); }
	    public void selectCheckbox3() { checkbox3.click(); }

	   
	    
	    
	}

