package testCases;

import org.testng.annotations.Test;
import pageObjectModel.Homepage;
import pageObjectModel.Login;
import pageObjectModel.SearchNewJob;

public class TC_05_Apply_Jobs extends BaseClass{

    @Test(groups="sanity")
    public void applyall() throws InterruptedException {


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

        SearchNewJob sn = new SearchNewJob(driver);

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


        int jobCount = sn.getJobCount();
        int applied = 0;

        for (int i = 0; i < jobCount && applied < 70; i++) {
            try {
                String title = sn.getJobTitle(i);
                sn.applyJob(i);
                applied++;
                System.out.println("Job " + (i + 1) + ": " + title);
            } catch (Exception e) {
                System.out.println("Failed to apply at index " + i + " : " + e.getMessage());
            }
        }

        System.out.println("Total applied jobs: " + applied);
    }

}
