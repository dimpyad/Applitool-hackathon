/**
* The class contains table sort tests using visual AI approach
* @author Dimpy Adhikary
*/
package VisualAITests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    public void startVisualTestSuite(){
    	/** Setting batch name */
        eyesManager.setBatchName("Sort Table by Amount");
        /** Initializing browser */
        initializeBrowser(".app.url");
    	loginPage = new LoginPage(driver);
    	homePage = new HomePage(driver);
    	transactionsPage = new TransactionsPage(driver);
    }
    
    
    /**
	 * Home page sorting of transactions - Amount column
	 */
    @Test(enabled = true)
    public void testSortingAmount()
    {
    	/** Performing login operation */
    	loginPage.login(System.getProperty("valid_user"), System.getProperty("valid_password"));
    	
    	/**Clicking on Amount column in recent trasection section */
    	transactionsPage.clickOnAmount();
    	
    	/** Setting Applitool eye full page screenshot */
        eyesManager.getEyes().setForceFullPageScreenshot(true);
        
        /** Validating  window using Applitool Eye*/
        eyesManager.validateWindow();
    }
   
    
}
