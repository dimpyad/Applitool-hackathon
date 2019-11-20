/**
* The class contains login data driven tests using traditional approach
* @author Dimpy Adhikary
*/
package TraditionalTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import base.BaseTests;
import DataProviders.Login;
import DataProviders.LoginDataProvider;
import pages.HomePage;
import pages.LoginPage;


public class LoginDataDrivenTest extends BaseTests {
	
	LoginPage loginPage;
	HomePage homePage;
	
	/**
	 * Setting up tests
	 */
	@BeforeClass
	public void setUpTests()
	{		
		 /** Initializing page objects */
		loginPage = new LoginPage(driver);
    	homePage = new HomePage(driver);
	}
	  
	/**
	 * Login page functional validation - data driven
	 */
    @Test(enabled = true, dataProvider="loginData", dataProviderClass=LoginDataProvider.class)
    public void loginPageFunctionalValidations(Login login)
    {
    	 /** Initializing browser */
    	 initializeBrowser(".app.url");
    	 
    	 /** Performing login operation */
    	 loginPage.login(login.getUserName(), login.getPassword());
		  
    	 /** Validating whether login is successful or not */
		 if(login.getStatus().equals("Success")) 
		  {
			   assertEquals(homePage.isLoginSuccessFull(), true, 
					  "Login is not successful"); 
		  } 
		 else 
		  {
			   assertEquals(loginPage.getLoginError(), login.getMessage(),
			  "Error message is not as expected!"); 
		  }		 
	}     
}
