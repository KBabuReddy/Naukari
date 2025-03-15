package testCases;

import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Login;

public class TC_01_LoginTest extends BaseClass {
	
	
	
	@Test(groups="sanity")
   public void login() {
		
		logger.info("starting test cases");
		
		Homepage hp=new Homepage(driver);
		hp.Login();
		logger.info("Clicked on log button");
		
		Login lp=new Login(driver);
		
		lp.username(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		logger.info("provided username and password");
		
		//lp.showpassword();
		
		
		lp.login();
		logger.info("sucessfully logged into the naukari application");
		
		
	}

}
