/**
* The class contains login UI tests using traditional approach
* @author Dimpy Adhikary
*/
package TraditionalTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Map;
import base.BaseTests;
import pages.HomePage;
import pages.LoginPage;

public class LoginUITest extends BaseTests {
	
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
		 initializeBrowser(".app.url");
		 /** Initializing page objects */
		 loginPage = new LoginPage(driver);
    	 softAssertion= new SoftAssert();
	}
	
	
	/**
	 * Login page UI elements validation
	 */
    @Test(enabled = true)
    public void loginPageUIValidations() 
    {
    	 /** Validating UI elements in login screen */	 
    	 for (Map.Entry<String,Boolean> entry : loginPage.getUIElementStates().entrySet()) 
    	 {
             softAssertion.assertTrue(entry.getValue(), "The element " + entry.getKey() + " is not displayed!");
       	 } 
    	 
    	 softAssertion.assertEquals(loginPage.getUserNamePlaceholder(), "Enter your username", "Username placeholder text is not as expected.");
    	 softAssertion.assertEquals(loginPage.getPasswordPlaceholder(), "Enter your password", "Password placeholder text is not as expected.");
    	 
    	 softAssertion.assertAll();	 
	}  
   
    
}
