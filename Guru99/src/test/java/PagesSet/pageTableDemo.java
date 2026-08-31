package PagesSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageTableDemo {

	WebDriver driver;

	public pageTableDemo(WebDriver driver) {
		this.driver = driver;
	}

	public String getCellText(int row, int col) {
		try {
			WebElement tb = driver.findElement(By.xpath("(//table)[1]//tr[" + row + "]//td[" + col + "]"));

            String cell = tb.getText().trim();

            if (cell.isEmpty()) {
                return "[blank]";   
            }

            return cell;

        } 
		catch 
		(Exception e) {
            return "[missing]";     
        }
	}
	
	public void printTable(int rows, int cols) {
		System.out.println("=== TABLE DATA ===");

		for (int row = 1; row <= rows; row++) {
			for (int col = 1; col <= cols; col++) {
				System.out.print(getCellText(row, col) + " ");
			}
			System.out.println();
		}

		System.out.println("==================");
	}
}