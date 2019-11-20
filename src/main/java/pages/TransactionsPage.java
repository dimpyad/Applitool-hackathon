/**
 * Page object class for Home page 
 * @author Dimpy Adhikary
 *
 */
package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage{
	
	WebDriver driver;
	
	@FindBy(xpath="//th[@class='text-right']")
	private WebElement amountColumn;
	
	String columnLocator = "tr td:nth-child(INDEX)";
	
	
	/**
	 * Transaction page constructor
	 * @param driver
	 */
	public TransactionsPage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	/**
	 * Click on Amount web element
	 */
	public void clickOnAmount()
	{
		amountColumn.click();
	}
	
	/**
	 * Gets Transaction Amount column data
	 * @return ArrayList
	 */
	
	public ArrayList<Double> getColumnData(int index)
	{
		columnLocator = columnLocator.replace("INDEX", Integer.toString(index));
		List<WebElement> elementList = driver.findElements(By.cssSelector(columnLocator));
		ArrayList<String> originalList = new ArrayList<String>();
		
		for(int i=0; i< elementList.size(); i++)
		{
			String value = elementList.get(i).getText();
			value = value.replace("USD", "");
			value = value.replace("+", "");
			value = value.replace(",", "");
			value = value.replace(" ", "");
			originalList.add(value.trim());
		}
		
				
		ArrayList<Double> copiedList = new ArrayList<Double>(); 
		for(int i=0; i<originalList.size(); i++) 
		{ 
			copiedList.add(Double.parseDouble(originalList.get(i))); 
		}
		return copiedList;
	}
		
}