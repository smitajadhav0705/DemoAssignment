package app.qa.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.qa.base.TestBase;
import app.qa.pages.DashboardPage;
import app.qa.pages.ForgotPasswordPage2;
import app.qa.pages.LoginPage;
import app.qa.pages.LoginPage2;

public class LoginPage2Test extends TestBase {

	DashboardPage dashboardPage;
	LoginPage2 loginPage2;

	public LoginPage2Test() {
		super();
	}


	@BeforeMethod
	public void setup() {
		initialization();
		
	}


	@Test(priority = 1)
	public void checkTitleTest() {
		String s = loginPage2.checkTitle();
		System.out.println(s);
		Assert.assertEquals(s, "Kite - Zerodha's fast and elegant flagship trading platform.", "Title of 2nd Login Page is incorrect..");
	}

	@Test(priority = 2)
	public void checkPinTest() {
		dashboardPage = loginPage2.checkPin(prop.getProperty("pin"));
	}

	@Test(priority = 3)
	public void checkForgotPasswordLinkTest() {
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
