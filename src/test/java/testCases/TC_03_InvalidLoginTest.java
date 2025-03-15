package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjectModel.Homepage;
import pageObjectModel.Login;

public class TC_03_InvalidLoginTest extends BaseClass {

    @Test(groups = "sanity")
    public void login() {
        logger.info("Starting test case: Invalid login credentials");

        
        Homepage hp = new Homepage(driver);
        hp.Login();
        logger.info("Clicked on the login button");

        
        Login lp = new Login(driver);
        lp.username(p.getProperty("email_invalid"));
        lp.password(p.getProperty("password_invalid"));
        logger.info("Provided invalid username and password");

        lp.showpassword();
        
        lp.login();
        logger.info("Attempted login with invalid credentials");

      
        String actualErrorMessage = lp.getErrorMessage(); 
        String expectedErrorMessage = "Invalid details. Please check the Email ID - Password combination.";
        
        
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected.");
    }
}
