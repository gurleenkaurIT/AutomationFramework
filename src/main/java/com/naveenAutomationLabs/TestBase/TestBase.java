package com.naveenAutomationLabs.TestBase;

import java.time.Duration;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.BeforeClass;

import com.naveenAutomationLabs.Browsers.Browsers;
import com.naveenAutomationLabs.Listeners.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver originalDriver;
	private final String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	public WebDriverEvents events;
	public static WebDriver driver;

	// Method to initialise the driver
	public void initialise() {
		initializeBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	private void initializeBrowser() {
		String browser = System.getProperty("browser", Browsers.CHROME.toString());

		switch (Browsers.valueOf(browser)) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			logger.info("Launching Chrome Browser");
			originalDriver = new ChromeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			logger.info("Launching Firefox Browser");
			originalDriver = new FirefoxDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			logger.info("Launching Edge Browser");
			originalDriver = new EdgeDriver();
			break;

		default:
			throw new InvalidArgumentException("Pass the correct browser");
		}

		events = new WebDriverEvents();
		driver = new EventFiringDecorator<WebDriver>(events).decorate(originalDriver);
	}

	// Method to close the browser
	public void teardown() {
		driver.quit();
	}
}
