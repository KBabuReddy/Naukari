package testCases;

import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Login;
import pageObjectModel.SearchNewJob;

public class TC_02_SearchTest extends BaseClass{
	
	@Test(priority=1, groups={"regression", "sanity"})
	public void search() {
		
		//Login
		Homepage hp=new Homepage(driver);
		hp.Login();
		Login lp=new Login(driver);
		lp.username(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		logger.info("provided username and password");
		lp.showpassword();
		lp.login();
		logger.info("sucessfully logged into the naukari application");
		
		//This is searching
		logger.info("Started search functinality");
		
		SearchNewJob sn=new SearchNewJob(driver);
		sn.searching();
		sn.searchdesig("Automation Tester");
		sn.exp();
		logger.info("Location checking");
		sn.loc("Bengalur");
		logger.info("Clicking search butto");
		sn.serach();
		
	
	}
	

}
