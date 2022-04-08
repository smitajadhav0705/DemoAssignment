package app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.qa.base.TestBase;

public class LoginPage extends TestBase {
	
//	Object Repository
	@FindBy(xpath = "//a[@class='logo kite-logo']")
	WebElement logo;

	@FindBy(xpath = "//input[@type='text']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;



//	Intitializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	Actions/Methods
	public String checkTitle() {
		return driver.getTitle();
	}

	public Boolean checkLogo() {
		return logo.isDisplayed();
	}
	
	public LoginPage2 checkLogin(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		return new LoginPage2();
	}
	

}
