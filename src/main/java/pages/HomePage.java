/**
 * Page object class for Home page 
 * @author Dimpy Adhikary
 *
 */
package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	
	WebDriver driver;
	
	@FindBy(css = ".logo-label")
	private WebElement loginSuccess;
	
	@FindBy(id="showExpensesChart")
	private WebElement compareExpenses;
	
	@FindBy(xpath = "//div[@id='flashSale']//img")
	private WebElement flashSale1;
	
	@FindBy(xpath = "//div[@id='flashSale2']//img")
	private WebElement flashSale2;
	

	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @return
	 */
	public boolean isLoginSuccessFull()
	{
		
		return loginSuccess.isDisplayed();
	}
	
	/**
	 * Click on Compare expenses link in home page
	 */
	public void clickOnCompareExpenses()
	{
		compareExpenses.click();
	}
	
	/**
	 * Check if flash sale1 gif is displayed
	 * @return true or false
	 */
	public boolean isflashSale1Displayed()
	{
		try
		{
			return flashSale1.isDisplayed();
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}
	
	/**
	 * Check if flash sale2 gif is displayed
	 * @return true or false
	 */
	public boolean isflashSale2Displayed()
	{
		try
		{
			return flashSale2.isDisplayed();
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}
		
}