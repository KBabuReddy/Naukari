package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage{
	
	public Login(WebDriver driver) {
		
		super(driver);
	}

	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='showhide blue-text']")
	WebElement show_password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement login_button;
	
	@FindBy(xpath="//span[text()='Invalid details. Please check the Email ID - Password combination.']")
	WebElement errorMessageLocator;
	
	
	public void username(String un) {
		username.sendKeys(un);
	}
	
	public void password(String pn) {
		password.sendKeys(pn);
	}
	
	public void showpassword() {
		show_password.click();
	}
	
	public void login() {
		login_button.click();
		
		//multiple methods to click on button
		
		//-> login_button.submit();
		
		//-> Actions act=new Actions(driver);
		//act.movetoElement(login_button).click().perform();
		
		//javascriptExecutor js=(javascriptExecutor)driver;
		//js.executeScript("argument[0].click;", login_button);
		
		//login_button.sendkeys(keys.RETURN);
		
		//Explicit wait method to click
	}
	
	public String getErrorMessage() {
		return errorMessageLocator.getText();
    }
}
