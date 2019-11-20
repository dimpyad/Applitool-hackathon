/**
 * Page object class for Login page 
 * @author Dimpy Adhikary
 *
 */
package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='logo-w']//a//img")
	private WebElement header_logo;
 
	@FindBy(xpath="//h4[@class='auth-header']")
	private WebElement header_text;
	
	@FindBy(id="username")
	private WebElement userNameField;
	
	@FindBy(xpath="//label[contains(text(),'Username')]")
	private WebElement usernameLabel;
	
	@FindBy(xpath="//div[@class='pre-icon os-icon os-icon-user-male-circle']")
	private WebElement usernameIcon;
		
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(xpath="//label[contains(text(),'Password')]")
	private WebElement passwordLabel;
	
	@FindBy(xpath="//div[@class='pre-icon os-icon os-icon-fingerprint']")
	private WebElement passwordIcon;
	
	@FindBy(id="log-in")
	private WebElement logIn;
	
	@FindBy(xpath="//input[@class='form-check-input']")
	private WebElement remembermeCheckbox;
	
	@FindBy(xpath="//*[contains(@src,'twitter')]")
	private WebElement twitterImage;
	
	@FindBy(xpath="//*[contains(@src,'facebook')]")
	private WebElement facebookImage;
	
	@FindBy(xpath="//*[contains(@src,'linkedin')]")
	private WebElement linkedinImage;

	@FindBy(xpath="//*[contains(@id,'random_id') and @role='alert']")
	private WebElement loginFailure;
	

	
	/**
	 * Login page constructor
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {    
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Performing login operation
	 * @param username
	 * @param password
	 */
	public void login(String username, String password)
	{
		userNameField.clear();
		userNameField.sendKeys(username);
		
		passwordField.clear();
		passwordField.sendKeys(password);
		
		logIn.click();
	}
	
	/**
	 * Get login error message
	 * @return
	 */
	public String getLoginError()
	{
		if(loginFailure.isDisplayed())
			return loginFailure.getText();
		else
			return "";
	}
	
	/**
	 * Creating a map by capturing the login page web elements 
	 * visibility status
	 * @return
	 */
	public Map<String, Boolean> getUIElementStates()
	{
		 Map<String, Boolean> map = new HashMap<String, Boolean>(); 
		 map.put("header_logo", getElementVisibility(header_logo));
		 map.put("header_text", getElementVisibility(header_text));
		 map.put("userNameField", getElementVisibility(userNameField));
		 map.put("userNameLabel", getElementVisibility(usernameLabel));
		 map.put("userNameIcon", getElementVisibility(usernameIcon));
		 map.put("passwordField", getElementVisibility(passwordField));
		 map.put("passwordLabel", getElementVisibility(passwordLabel));
		 map.put("passwordIcon", getElementVisibility(passwordIcon));
		 map.put("login", getElementVisibility(logIn));
		 map.put("remembermeCheckbox", getElementVisibility(remembermeCheckbox));
		 map.put("twitterImage", getElementVisibility(twitterImage));
		 map.put("facebookImage", getElementVisibility(facebookImage));
		 map.put("linkedinImage", getElementVisibility(linkedinImage)); 
		 
		 return map;
	}
	
	/**
	 * Get the web element visibility status
	 * @param element
	 * @return
	 */
	private boolean getElementVisibility(WebElement element)
	{
		try
		{
			return element.isDisplayed();
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	/**
	 * Get username placeholder text
	 * @return string
	 */
	public String getUserNamePlaceholder()
	{
		return userNameField.getAttribute("placeholder");
	}
	
	/**
	 * Get password placeholder text
	 * @return string
	 */
	public String getPasswordPlaceholder()
	{
		return passwordField.getAttribute("placeholder");
	}
		
}