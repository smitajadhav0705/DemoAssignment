package app.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import app.qa.listeners.WebEventListener;
import app.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	

//	Constructor for loading config.properties file
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\TestAutomation\\src\\main\\java\\app\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
		}
	}

	public static void initialization() {
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
			driver = new FirefoxDriver();
//		}

		
	
		
	

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}
}
}