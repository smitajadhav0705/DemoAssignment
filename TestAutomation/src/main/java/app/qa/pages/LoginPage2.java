package app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import app.qa.base.TestBase;

public class LoginPage2 extends TestBase {
	
//	Object Repository
	@FindBy(xpath = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/input")
	WebElement pin;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueButton;

	
//	Initializing Page Objects
	public LoginPage2() {
		PageFactory.initElements(driver, this);
	}

//	Actions/Methods
	public String checkTitle() {
		return driver.getTitle();
	}

	public DashboardPage checkPin(String pinpass) {
		pin.sendKeys(pinpass);
		continueButton.click();
		return new DashboardPage();
	}
	
}