/**
* This is the pojo class for setting and getting login test data
* @author Dimpy Adhikary
*/
package DataProviders;

public class Login
{
    public String userName; 
    public String passWord;
    public String staus;
    public String message;
    public String testName;
    
    /**
     * @return username
     */
    public String getUserName() {
        return userName;
    }
 
    
    /**Sets username
     * @param username
     */
    public void setUserName(String username) {
        this.userName = username;
    }
    
    
    /**
     * @return password
     */
    public String getPassword() {
        return passWord;
    }
 
    
    /** Sets password
     * @param password
     */
    public void setPassword(String password) {
        this.passWord = password;
    }
    
    
    /**
     * @return status
     */
    public String getStatus() {
        return staus;
    }
 
    
    /** Sets test status
     * @param status
     */
    public void setStatus(String status) {
        this.staus = status;
    }
    
    
    /**
     * @return login error message
     */
    public String getMessage() {
        return message;
    }
 
    
    /** Sets login error message
     * @param msg
     */
    public void setMessage(String msg) {
        this.message = msg;
    }
    
    
    /**
     * @return test name
     */
    public String getTestName() {
        return testName;
    }
 
    
    /**Sets test name
     * @param testname
     */
    public void setTestName(String testname) {
        this.testName = testname;
    }
    
}