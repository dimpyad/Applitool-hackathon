/**
* The class contains dynamic content tests using visual AI approach
* @author Dimpy Adhikary
*/
package VisualAITests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.applitools.eyes.MatchLevel;
import base.BaseTests;
import pages.HomePage;
import pages.LoginPage;


public class DynamicContentTest extends BaseTests {
	
	LoginPage loginPage;
	HomePage homePage;
	
	/**
	 * Setting up tests
	 */
	@BeforeClass
	public void startVisualTests()
	{
		 /** Initializing browser */
		 initializeBrowser(".dynamic.url");
		 /** Initializing page objects */
		 loginPage = new LoginPage(driver);
	     homePage = new HomePage(driver);
	}
	       
	/**
	 * Home page dynamic content validation
	 */
	@Test(enabled = true) 
	public void testdynamicContent() 
	{ 
		/** Performing login operation */
		loginPage.login(System.getProperty("valid_user"), System.getProperty("valid_password"));	
		
		/** Setting Applitools Eye match level as Layout*/
    	eyesManager.getEyes().setMatchLevel(MatchLevel.LAYOUT);
    	  
    	/** Validating  window using Applitool Eye*/
    	eyesManager.validateWindow();
	}
    
}
