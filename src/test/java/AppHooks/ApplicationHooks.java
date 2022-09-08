package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.factory.DriverFactory;
import com.qa.pages.LoginPage;
import com.qa.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplicationHooks {
	WebDriver driver;

DriverFactory driverFactory;
ConfigReader configReader;
Properties prop;
	@Before(order = 0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		driverFactory=new DriverFactory();
		String browserName=prop.getProperty("browser");
		driver=driverFactory.init_driver(browserName);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
	}

	@After(order = 0)
	public void closeBrowser() {
		driver.close();
	}

	@After(order = 1)
	public void tearDown(Scenario sc) {
		if (sc.isFailed()) {
			String screenShotName = sc.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "img/png", screenShotName);
		}
	}
}
