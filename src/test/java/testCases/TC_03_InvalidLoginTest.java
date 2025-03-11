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

        // Initialize login page and enter invalid credentials
        Login lp = new Login(driver);
        lp.username(p.getProperty("email_invalid"));
        lp.password(p.getProperty("password_invalid"));
        logger.info("Provided invalid username and password");

        lp.showpassword();
        
        lp.login();
        logger.info("Attempted login with invalid credentials");

      
        String actualErrorMessage = lp.getErrorMessage(); // Assuming getErrorMessage() returns the error message text
        String expectedErrorMessage = "Invalid details. Please check the Email ID - Password combination.";
        
        // Assert if the error message is displayed as expected
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected.");
    }
}
