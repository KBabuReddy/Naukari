package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReport implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    
    String repName;
    
    public void onStart(ITestContext testContext) {
    	
    	//Scenario-1
    	/*SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Date dt=new Date();
    	String currentdatetimestamp=df.format(dt);*/
    			
    //scenarios-1 we can write in another way also in below we can check
    	String timestamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "TestReport-" + timestamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); // Specify report location
        
        sparkReporter.config().setDocumentTitle("Naukari Automation Report");
        sparkReporter.config().setReportName("Naukari Testing");
        sparkReporter.config().setTheme(Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Naukari");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customer");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os); // Corrected this line
        
        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);
        
        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Group", includedGroups.toString());
        }
    }
    
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " got successfully executed");
    }
    
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable().getMessage());
        
        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        
        test.log(Status.SKIP, result.getName() + " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }
    
    public void onFinish(ITestContext testContext) {
        extent.flush();
        
        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReports = new File(pathOfExtentReport);
        
        try {
            Desktop.getDesktop().browse(extentReports.toURI());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
