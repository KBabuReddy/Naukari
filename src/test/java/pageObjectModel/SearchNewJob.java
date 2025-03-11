package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchNewJob extends BasePage{
	
	public SearchNewJob(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//span[text()='Search jobs here']")
	WebElement seaching;
	
	@FindBy(xpath="//input[@placeholder='Enter keyword / designation / companies']")
	WebElement serach_designation;
	
	@FindBy(xpath="//input[@id='experienceDD']")
	WebElement experience;
	
	@FindBy(xpath="//input[@placeholder='Enter location']")
	WebElement location;
	
	@FindBy(xpath="//span[text()='Search']")
	WebElement search;
	
	@FindBy(xpath="//img[@alt='naukri user profile img']")
	WebElement profile_click;
	
	@FindBy(xpath="//div//a[@title=\"Logout\"]")
	WebElement Logout;
	
	@FindBy(xpath="//div[text()=\"Search\"]")
	WebElement Logout_search;
	
	
	public void searching() {
		seaching.click();
	}
	
	public void searchdesig(String ss) {
		 serach_designation.click();
		 serach_designation.sendKeys(ss);
	}

	public void exp() {
		experience.click();
		
	}
	
	public void loc(String rr) {
		location.click();
		location.sendKeys(rr);
	}
	
	public void serach() {
		search.click();
	}
	
	public void prf_click() {
		profile_click.click();
	}
	
	public void logout() {
		Logout.click();
	}
	
	public void logout_search() {
		Logout_search.click();
	}
}
