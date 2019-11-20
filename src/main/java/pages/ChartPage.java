/**
 * Page object class for Chart page 
 * @author Dimpy Adhikary
 *
 */
package pages;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChartPage{
	
	WebDriver driver;
	
	@FindBy(id="addDataset")
	private WebElement showDataNextYear;
	
	private By canvas = By.id("canvas");
	
		
	/**
	 * @param driver
	 */
	public ChartPage(WebDriver driver) { 
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	/**
	 * Gets the by object for canvas element
	 * @return
	 */
	public By getCanvasLocator() {
		return canvas;
	}
	
	/**
	 * Click on Show Data for Next yeat button
	 */
	public void clickOnShowData()
	{
		showDataNextYear.click();
	}
	
	
	/**
	 * Reads the content of image from web page and compares with an static image
	 * @param filename
	 * @return
	 */
	public boolean compareCanvas(String filename)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;         
		js.executeScript("return document.title");
		String actualImage = (String) js.executeScript("return arguments[0].toDataURL('image/png').substring(21);", 
				driver.findElement(canvas));
		byte[] actualImageAsByte = Base64.decodeBase64(actualImage); 
		
		String expectedImagePath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\screenshots\\" + filename;
		byte[] expectedImageAsByte = null;
		try 
		{
			expectedImageAsByte = FileUtils.readFileToByteArray(new File(expectedImagePath));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		boolean result = Arrays.equals(actualImageAsByte, expectedImageAsByte);
		return result;		
	}
	
	
	
		
}