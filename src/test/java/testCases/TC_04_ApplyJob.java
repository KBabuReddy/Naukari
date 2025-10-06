package testCases;

import org.testng.annotations.Test;
import pageObjectModel.Homepage;
import pageObjectModel.Login;
import pageObjectModel.SearchNewJob;

public class TC_04_ApplyJob extends BaseClass{


    //here i want to open the naukari application
    //Login
    //Search with required data and apply one of the job
    @Test(groups = "sanity")
    public void applyjob() throws InterruptedException {

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
        sn.searchdesig("devops");
        Thread.sleep(3000);
        sn.exp();
        logger.info("Location checking");
        Thread.sleep(3000);
        sn.loc("Bengalur");
        logger.info("Clicking search butto");
        Thread.sleep(3000);
        sn.serach();

        //Thread.sleep(5000);

        sn.firstjob();
        Thread.sleep(5000);

        try{
            sn.apply_button();
        } catch (Exception e) {
            sn.company_site();
            throw new RuntimeException(e);

        }





    }

}
