package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage{
	
	public Homepage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@id=\"login_Layer\"]") WebElement Login_button;
	
	
	public void Login() {
		Login_button.click();
	}

}
