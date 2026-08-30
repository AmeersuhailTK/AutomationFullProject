package TestPage;


import org.testng.annotations.Test;

import BrowserSetup.tableDemo;
import PageSetup.pageTableDemo;

public class testPageTable extends tableDemo {

	    @Test
	    public void printAndVerifyTable() {
	    	setup();
	    	
	    	pageTableDemo table = new pageTableDemo(driver);

	    	int rows = 5;
	    	int cols = 3;
	    		    	
	    	table.printTable(rows, cols);
	    	   
	    	tearDown();
	    }

}