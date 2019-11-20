/**
* The class contains login data driven tests using visual AI approach
* @author Dimpy Adhikary
*/
package VisualAITests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTests;
import DataProviders.Login;
import DataProviders.LoginDataProvider;
import pages.LoginPage;


public class LoginDataDrivenTest extends BaseTests {
	LoginPage loginPage;
	
	/**
	 * Setting up tests
	 */
	@BeforeClass
    public void startVisualTest(){
		/** Setting batch name */
        eyesManager.setBatchName("Datadriven-Login");
        /** Initializing browser */
        initializeBrowser(".app.url");
        /** Initializing page objects */
    	loginPage = new LoginPage(driver);
    }
		  
    
	/**
	 * Login page functional validation - data driven
	 */
    @Test(enabled = true, dataProvider="loginData", dataProviderClass=LoginDataProvider.class)
    public void loginDataDrivenValidations(Login login) 
    {	/** Performing login operation */
    	loginPage.login(login.getUserName(), login.getPassword());
    	
    	/** Setting Applitool eye full page screenshot */
    	eyesManager.getEyes().setForceFullPageScreenshot(true);
    	
    	/** Validating  window using Applitool Eye*/
    	eyesManager.validateWindow(login.getTestName());		 
	} 
    
}
