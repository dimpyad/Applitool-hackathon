/**
* The class contains canvas chart tests using traditional approach
* @author Dimpy Adhikary
*/
package TraditionalTests;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTests;
import pages.ChartPage;
import pages.HomePage;
import pages.LoginPage;


public class CanvasChartTest extends BaseTests {
	
	LoginPage loginPage;
	HomePage homePage;
	ChartPage chartPage;
	SoftAssert softAssertion;
	
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
		 chartPage = new ChartPage(driver);
	     softAssertion= new SoftAssert();
	}
	
       
	/**
	 * Home page expenses validation on canvas
	 */
    @Test(enabled = true)
    public void testExpensesCanvasValidations() {
    	throw new SkipException("Skipping this exception since unable to validate dynamic content in canvas using traditional approach!");
    	
		/*
		 * loginPage.login(System.getProperty("valid_user"),
		 * System.getProperty("valid_password")); homePage.clickOnCompareExpenses();
		 * softAssertion.assertTrue(chartPage.compareCanvas("Canvas_1.png"),
		 * "Expenses chart for 2017 and 18 not as expected!");
		 * chartPage.clickOnShowData();
		 * softAssertion.assertTrue(chartPage.compareCanvas("Canvas_2.png"),
		 * "Expenses chart for 2019 not as expected!"); softAssertion.assertAll();
		 */
	}  
        
}
