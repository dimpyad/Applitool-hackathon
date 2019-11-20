/**
* This is the base test class, all the test classes should be 
* derived from this class
* @author Dimpy Adhikary
*/
package base;

import core.ExtentManager;
import core.EyesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import java.io.FileInputStream;
import java.util.Properties;


public abstract class BaseTests {

	protected static String appVersion;
	protected static String testType;

	/** The extent report object */
	protected static ExtentReports extent = ExtentManager.createInstance();
	 

	String configPath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";

	protected static WebDriver driver = null;
	protected static EyesManager eyesManager = null;

	/**
	 * @throws Exception
	 */
	private void LoadConfigFile() throws Exception {

		Properties props = System.getProperties();
		try {
			props.load(new FileInputStream(configPath));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Sets test suite.
	 *
	 * @param context the new up
	 * @throws InterruptedException the interrupted exception
	 */
	@BeforeSuite 
	public void setup(ITestContext context) throws InterruptedException {

		try 
		{
			/**
			 *Loading test properties from config.properties file
			 */
			LoadConfigFile();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Reading test app version(v1 or v2) from testng.xml file while executing as suite
		 */
		String testngAppVersion = context.getCurrentXmlTest().getParameter("appVersion");
		
		/**
		 * Reading test type (tradition/visualai) from testng.xml file while executing as suite
		 */
		String testngTestType = context.getCurrentXmlTest().getParameter("testType");
		
		/**
		 * If we are executing the tests from testng.xml get the app version from testng.xml
		 * otherwise get it from config.properties file
		 */
		if (testngAppVersion != null) {
			appVersion = testngAppVersion;
		} 
		else 
		{
			appVersion = System.getProperty("app.version");
		}
		
		/**
		 * If we are executing the tests from testng.xml get the testtype from testng.xml
		 * otherwise get it from config.properties file
		 */
		if(testngTestType != null)
		{
			testType = testngTestType; 
		}
		else
		{
			testType = System.getProperty("app.test.type");
		}
		
		/**
		 * Setting up extent report if test type is traditional
		 */
		if(testType.equals("TRD"))
		{
			extent = ExtentManager.createInstance();
		}
		

	}

	/**
	 * Cleaning up extent reporter after test suite
	 */
	@AfterSuite
	public void afterSuite() {

		if(testType.equals("TRD"))
		{
			if(extent!= null)
				extent = null;
		}
	}

	/**
	 * Setup test - Setting up webdriver instance and eyemanager instance
	 */
	@BeforeClass
	public void setUp(ITestContext context) {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		if(testType.equals("VAI"))
		{
			if (eyesManager == null) {
				eyesManager = new EyesManager(driver, "Hackathon-dimpy");
			}
		}

	}

	/**
	 * Tear down test - cleaning up webdriver instance and eyemanager instance
	 */
	@AfterClass
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}

		if(testType.equals("VAI"))
		{
			if (eyesManager != null) 
			{
				eyesManager.abort();
				eyesManager = null;
			}
		}
	}

	
	/**
	 * Initializing the browser - maximizing the window and
	 * opening the url
	 * @param url
	 */
	protected void initializeBrowser(String url) {
		driver.manage().window().maximize();
		driver.get(System.getProperty(appVersion + url));
	}		 

}
