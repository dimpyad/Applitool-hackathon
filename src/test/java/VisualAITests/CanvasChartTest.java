/**
* The class contains canvas chart tests using visual AI approach
* @author Dimpy Adhikary
*/
package VisualAITests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTests;
import pages.ChartPage;
import pages.HomePage;
import pages.LoginPage;


/**
 * @author Dimpy Adhikary
 *
 */
public class CanvasChartTest extends BaseTests {
	
	LoginPage loginPage;
	HomePage homePage;
	ChartPage chartPage;
	
	/**
	 * Setting up tests before class
	 */
	@BeforeClass
    public void startVisualTests(){
		/** Setting batch name */
        eyesManager.setBatchName("Canvas validations");
        /** Maximizing browser window */
        driver.manage().window().maximize();
        /** Initializing page objects */
        loginPage = new LoginPage(driver);
    	homePage = new HomePage(driver);
    	chartPage = new ChartPage(driver);
    }
	
       
	/**
	 * Home page expenses validation on canvas - year 2017 and 2018
	 */
	@Test(enabled = true)
    public void testExpensesData2017And2018(){
		/** Opening URL under test in browser */
		driver.get(System.getProperty(appVersion + ".app.url"));
		
		/** Performing login operation */
		loginPage.login(System.getProperty("valid_user"), System.getProperty("valid_password"));			  
	    
		/** Clicking on compare expenses link */
		homePage.clickOnCompareExpenses(); 
		
		/** Setting full page screenshot */
	    eyesManager.getEyes().setForceFullPageScreenshot(true);
	    
	    /** Validating  window using Applitool Eye*/
	    eyesManager.validateWindow();
    }
	
	/**
	 * Home page expenses validation on canvas - year 2019
	 */
	@Test(enabled = true)
    public void testExpensesData2019(){
		driver.get(System.getProperty(appVersion + ".app.url"));
    	loginPage.login(System.getProperty("valid_user"), System.getProperty("valid_password"));			  
	    homePage.clickOnCompareExpenses();    
	    chartPage.clickOnShowData();
	    eyesManager.getEyes().setForceFullPageScreenshot(true);
	    eyesManager.validateWindow();
    }
	
    
}
