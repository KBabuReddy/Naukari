package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	
public static WebDriver driver;
public Logger logger;
public Properties p;
	
	@BeforeClass (groups= {"regression", "sanity"})
	@Parameters({"os","browser"})
   //public void setup(String os, String br) throws IOException {
	public void setup(@Optional("windows") String os, @Optional("chrome") String br) throws IOException {
		
    //log4j2 file	
	 logger= LogManager.getLogger(this.getClass());
	 

//   private void initializeDriver(String os, String br) throws IOException {
//       
//       String executionEnvironment = p.getProperty("execution_environment");
//
//       if (executionEnvironment.equalsIgnoreCase("remote")) {
//           DesiredCapabilities dc = new DesiredCapabilities();
//
//           // Set OS (Operating systems)
//           if (os.equalsIgnoreCase("windows")) {
//               dc.setPlatform(Platform.WINDOWS);
//           } else if (os.equalsIgnoreCase("mac")) {
//               dc.setPlatform(Platform.MAC);
//           } else {
//               System.out.println("No Matching OS");
//               return;
//           }
//
//           // Browser configuration
//           if (br.equalsIgnoreCase("chrome")) {
//               dc.setBrowserName("chrome");
//           } else if (br.equalsIgnoreCase("edge")) {
//               dc.setBrowserName("MicrosoftEdge");
//           } else {
//               System.out.println("No Browser found");
//               return;
//           }
//
//           // RemoteWebDriver initialization with Selenium Grid
//           driver = new RemoteWebDriver(new URL("YOUR_SELENIUM_GRID_URL"), dc);
//
//       } else if (executionEnvironment.equalsIgnoreCase("local")) {
	 
	 switch(br.toLowerCase()) {
	 
	 case "chrome" :
		 driver=new ChromeDriver();
		 break;
		 
	 case "edge" :
		 driver=new EdgeDriver();
		 break;
		 
	 case "firefox" :
		 driver=new FirefoxDriver();
		 break;
		 
		default:
			System.out.println("Invalid browsers");
		return;
		 
	 
	 }
	//}
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	  //driver.get("https://www.naukri.com/");
	  
		//loading config.properities file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
	   driver.get(p.getProperty("app_url"));
	   driver.manage().window().maximize();
		
	}
	
	@AfterClass (groups= {"regression", "sanity"})
   public void teardown() throws InterruptedException {
	   
	Thread.sleep(5000);
	   driver.quit();
		
	}
	
	public String captureScreen(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile= ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + " _" + timestamp + ".png";
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}

}
