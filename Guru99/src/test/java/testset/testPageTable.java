package testset;


import org.testng.annotations.Test;

import BrowserSet.tableDemo;
import PagesSet.pageTableDemo;

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