package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

	@FindBy (xpath="//ul//li[@title='3 years']")
	WebElement exp1;
	
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

	@FindBy(xpath="//div[@class='srp-jobtuple-wrapper'][1]")
	WebElement First_job;

	@FindBy(xpath = "(//div//button[@id=\"apply-button\"])[1]")
	WebElement apply_button;

	@FindBy(xpath = "(//button[@id='company-site-button' and text()='Apply on company site'])[1]")
	WebElement company_apply;

	@FindBy(xpath = "//*[@id='jobs-list-header']/div[1]/span")
	private List<WebElement> jobCards;

	// Job title inside each card
	@FindBy(xpath = "//a[contains(@class,'title')]")
	private List<WebElement> jobTitles;

	@FindBy(xpath = "//button[contains(text(),'Apply')]")
	private List<WebElement> applyButtons;
	
	public void searching() {
		seaching.click();
	}
	
	public void searchdesig(String ss) {
		 serach_designation.click();
		 serach_designation.sendKeys(ss);
	}

	public void exp() {
		experience.click();
		exp1.click();
		
	}

	public void apply_button() {
		//apply_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Get current window handle (parent)
			String parentWindow = driver.getWindowHandle();

			// Switch to new window
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					break;
				}
			}

			// Wait for element presence
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div//button[@id=\"apply-button\"])[1]")));

			// Wait until clickable
			wait.until(ExpectedConditions.elementToBeClickable(apply_button));

			// Scroll and click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", apply_button);
			js.executeScript("arguments[0].click();", apply_button);

			System.out.println("✅ Company Site button clicked successfully!");

		} catch (Exception e) {
			System.out.println("❌ Still not able to click: " + e.getMessage());
		}
	}

	public void company_site() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Get current window handle (parent)
			String parentWindow = driver.getWindowHandle();

			// Switch to new window
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					break;
				}
			}

			// Wait for element presence
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//button[@id='company-site-button' and text()='Apply on company site'])[1]")));

			// Wait until clickable
			wait.until(ExpectedConditions.elementToBeClickable(company_apply));

			// Scroll and click
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", company_apply);
			js.executeScript("arguments[0].click();", company_apply);

			System.out.println("✅ Company Site button clicked successfully!");

		} catch (Exception e) {
			System.out.println("❌ Still not able to click: " + e.getMessage());
		}
	}

	public void firstjob() {
		First_job.click();
	}
	public void loc(String rr) {
		location.click();
		location.sendKeys(rr);


	}

	public int getJobCount() {
		return jobCards.size();
	}

	public String getJobTitle(int index) {
		//return jobTitles.get(index).getText();
		WebElement title = jobCards.get(index).findElement(By.xpath(".//a[contains(@class,'title')]"));
		return title.getText();
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

	public void applyJob(int index) {
		//applyButtons.get(index).click();
		WebElement applyBtn = jobCards.get(index).findElement(By.xpath(".//button[contains(text(),'Apply')]"));
		applyBtn.click();
	}
}
