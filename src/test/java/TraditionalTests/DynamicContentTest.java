/**
* The class contains dynamic content tests using traditional approach
* @author Dimpy Adhikary
*/
package TraditionalTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.BaseTests;
import pages.HomePage;
import pages.LoginPage;


public class DynamicContentTest extends BaseTests {
	
	LoginPage loginPage;
	HomePage homePage;
	SoftAssert softAssertion;
	
	/**
	 * Setting up tests
	 */
	@BeforeClass
	public void setUpTests()
	{
		/** Initializing browser */
		initializeBrowser(".dynamic.url");
		 /** Initializing page objects */
		loginPage = new LoginPage(driver);
    	homePage = new HomePage(driver);
    	softAssertion= new SoftAssert();
	}
	
	/**
	 * Home page dynamic content validation
	 */
	@Test(enabled = true) 
	public void flashSaleAdsValidations() 
	{ 
		/** Performing login operation */
		loginPage.login(System.getProperty("valid_user"), System.getProperty("valid_password"));
		
		/** Validating Flashsale1 gif is present or not in home page  */
		softAssertion.assertTrue(homePage.isflashSale1Displayed(), "Flashsale1 element not displayed!"); 
		
		/** Validating Flashsale1 gif is present or not in home page  */
		softAssertion.assertTrue(homePage.isflashSale2Displayed(), "Flashsale2 element not displayed!"); 
		
		softAssertion.assertAll();
	}

		
	
    
}
