package testCases;

import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Login;

public class TC_01_LoginTest extends BaseClass {
	
	
	
	@Test(groups="sanity")
   public void login() throws InterruptedException {
		
		logger.info("starting test cases");
		
		Homepage hp=new Homepage(driver);
		hp.Login();
		Thread.sleep(5000);
		logger.info("Clicked on log button");
		
		Login lp=new Login(driver);
		
		lp.username(p.getProperty("email"));
		Thread.sleep(3000);
		lp.password(p.getProperty("password"));
		Thread.sleep(3000);
		logger.info("provided username and password");
		
		//lp.showpassword();
		
		
		lp.login();
		logger.info("sucessfully logged into the naukari application");
		
		
	}

}
