package testCases;

import org.testng.annotations.Test;

import pageObjectModel.Homepage;
import pageObjectModel.Login;
import pageObjectModel.SearchNewJob;

public class TC_02_SearchTest extends BaseClass{
	
	@Test(priority=1, groups={"regression", "sanity"})
	public void search() throws InterruptedException {
		
		//Login
		Homepage hp=new Homepage(driver);
		hp.Login();
		Login lp=new Login(driver);
		lp.username(p.getProperty("email"));
		Thread.sleep(3000);
		lp.password(p.getProperty("password"));
		Thread.sleep(3000);
		logger.info("provided username and password");
		//lp.showpassword();
		lp.login();
		logger.info("sucessfully logged into the naukari application");
		
		//This is searching
		logger.info("Started search functinality");
		
		SearchNewJob sn=new SearchNewJob(driver);
		sn.searching();
		Thread.sleep(3000);
		sn.searchdesig("Automation Tester");
		Thread.sleep(3000);
		sn.exp();
		logger.info("Location checking");
		Thread.sleep(3000);
		sn.loc("Bengalur");
		logger.info("Clicking search butto");
		Thread.sleep(3000);
		sn.serach();

//		// Wait for results to load (use explicit wait in real scenarios)
//		Thread.sleep(3000);
//
//// Find all job result elements (update the XPath/CSS selector as per actual HTML)
//		List<WebElement> jobResults = driver.findElements(By.xpath("//div[contains(@class, 'jobTuple')]"));
//
//// Get and print the count
//		int resultCount = jobResults.size();
//		System.out.println("Number of job results: " + resultCount);
//		logger.info("Number of job results: " + resultCount);
		
	
	}
	
	@Test(priority=2, dependsOnMethods= {"search"},  groups={"regression", "sanity"})
	public void Login_search() throws InterruptedException {
		
		//Login
		Homepage hp=new Homepage(driver);
//		hp.Login();
//		Login lp=new Login(driver);
//		lp.username(p.getProperty("email"));
//		lp.password(p.getProperty("password"));
//		logger.info("provided username and password");
//		lp.showpassword();
//		lp.login();
//		logger.info("sucessfully logged into the naukari application");
		
		//This is searching
		logger.info("Started search functinality");
		
		SearchNewJob sn=new SearchNewJob(driver);
		
		sn.prf_click();
		Thread.sleep(3000);
		
		sn.logout();
		
		Thread.sleep(5000);
		
		sn.logout_search();;
		sn.searchdesig("Automation Tester");
		sn.exp();
		logger.info("Location checking");
		sn.loc("Bengalur");
		logger.info("Clicking search butto");
		sn.serach();
		
	
	}
	
	

}
