/**
* The class contains login UI tests using visual AI approach
* @author Dimpy Adhikary
*/
package VisualAITests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTests;

public class LoginUITest extends BaseTests {
	
	/**
	 * Setting up tests
	 */
	@BeforeClass
    public void startVisualTest(){
		/** Initializing browser */
        initializeBrowser(".app.url");
    }
	
	
	/**
	 * Login page UI elements validation
	 */
    @Test(enabled = true)
    public void loginPageUIValidations() {
    	/** Setting Applitool eye full page screenshot */
    	eyesManager.getEyes().setForceFullPageScreenshot(true);
    	
    	/** Validating  window using Applitool Eye*/
    	eyesManager.validateWindow();    	
	}  
    
    
}
