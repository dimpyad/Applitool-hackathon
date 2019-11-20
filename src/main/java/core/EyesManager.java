/**
 * Applitool Eye related operations are done by this class. 
 * @author dimpyad
 *
 */
package core;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class EyesManager {

    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    /**
     * @param driver
     * @param appName
     */
    public EyesManager(WebDriver driver, String appName){
        this.driver = driver;
        this.appName = appName;

        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    /**
     * Setting batch name
     * @param batchName
     */
    public void setBatchName(String batchName){
        eyes.setBatch(new BatchInfo(batchName));
    }

   
    /**
     * Validating window
     */
    public void validateWindow(){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }
    
    /**
     * Validating page window
     * @param testname
     */
    public void validateWindow(String testname){
        eyes.open(driver, appName, testname);
        eyes.checkWindow();
        eyes.close();
    }
    
        
    /**
     * Aborting eye 
     */
    public void abort(){
        eyes.abortIfNotClosed();
    }

    /**
     * Gets eye object
     * @return
     */
    public Eyes getEyes(){
        return eyes;
    }
    
    /**
     * Validing web element
     * @param element
     */
    public void validateElement(By locator, String testname){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName() + "_"+testname);
        eyes.checkElement(locator);
        eyes.close();
    }
    
      
}
