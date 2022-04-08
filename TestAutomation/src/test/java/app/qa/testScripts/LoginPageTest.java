package app.qa.testScripts;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.qa.base.TestBase;
import app.qa.pages.ForgotPasswordPage;
import app.qa.pages.LoginPage;
import app.qa.pages.LoginPage2;
import app.qa.pages.SignUpPage;
import app.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	LoginPage2 loginPage2;


	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void checkTitleTest() {
		String title = loginPage.checkTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform",
				"Wrong Title, Try again later");
	}

	@Test(priority = 2)
	public void checkLogoTest() {
		Boolean b = loginPage.checkLogo();
		System.out.println(b);
		Assert.assertTrue(b);
	}

	
	@Test(priority = 3)
	public void checkLoginTest() {
		loginPage2 = loginPage.checkLogin(prop.getProperty("user"), prop.getProperty("pass"));
	}

	

	@AfterMethod
	public static void takeScreenshot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}