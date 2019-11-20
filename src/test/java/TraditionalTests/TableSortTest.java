/**
* The class contains Table sort tests using traditional approach
* @author Dimpy Adhikary
*/
package TraditionalTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.Collections;
import java.util.List;
import base.BaseTests;
import pages.HomePage;
import pages.LoginPage;
import pages.TransactionsPage;


public class TableSortTest extends BaseTests {
	
	LoginPage loginPage;
	HomePage homePage;
	TransactionsPage transactionsPage;
	
	/**
	 * Setting up tests
	 */
	@BeforeClass
	public void setUpTests()
	{
		/** Initializing browser */
		initializeBrowser(".app.url");
		 /** Initializing page objects */
		loginPage = new LoginPage(driver);
    	homePage = new HomePage(driver);
    	transactionsPage = new TransactionsPage(driver);
	}
	
     
    /**
	 * Home page sorting of transactions - Amount column
	 */
    @Test(enabled = true)
    public void  testSortingAmount() {
    	/** Performing login operation */
    	loginPage.login(System.getProperty("valid_user"), System.getProperty("valid_password"));
    	
    	/** Extracting the data from Amount column in Recent transactions table  */
    	List<Double> expectedAmountList = transactionsPage.getColumnData(5);
    	
    	/** Sorting the Amounts data */
    	Collections.sort(expectedAmountList);
    	
    	/** Clicking on Amounts column header */
    	transactionsPage.clickOnAmount();
    	
    	/** Extracting the actual data after sorting performed by application */
    	List<Double> actualAmountList = transactionsPage.getColumnData(5);
    	
    	/** Comparing expected and actual list of amounts */
	    assertEquals(expectedAmountList, actualAmountList, "Amount column is not sorted in assending order. "
	    		+ "Expected list : " + expectedAmountList + " and actual list : " + actualAmountList);
	}  
}
