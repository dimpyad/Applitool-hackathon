package DataProviders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.testng.annotations.DataProvider;


public class LoginDataProvider{
	
	
	/**
	 * Data provider for login test data
	 * @return login data object
	 * @throws IOException
	 */
	@DataProvider(name = "loginData")
    public Object[][] createLoginData() throws IOException {
 
        Object[][] arr = new Object[getLoginData().size()][1];
        for(int i =0; i < getLoginData().size();i++){
            arr[i][0] = getLoginData().get(i);
        }
 
        return arr;
    }
 
     
    /**
     * @return login test data from data/login.csv file
     * @throws IOException
     */
    private List<Login> getLoginData() throws IOException {
        List<Login> loginData = new ArrayList<Login>();
 
        BufferedReader bReader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/data/login.csv")));
 
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(bReader);
        int recordCount = 1;
        for (CSVRecord record : records) {
        	if(recordCount == 1)
        	{
        		recordCount ++;
        		continue;
        	}
            Login login = new Login();
            login.setUserName(record.get(0));
            login.setPassword(record.get(1));
            login.setStatus(record.get(2));
            login.setMessage(record.get(3));
            login.setTestName(record.get(4));
            loginData.add(login);
        }
        return loginData;
    }
}