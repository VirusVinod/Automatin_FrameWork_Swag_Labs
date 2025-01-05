package SwagLabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.io.FileHandler;

import org.junit.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Base {
	public static Properties prop;
	public static WebDriver driver;
	static long timeout = 10;

	static {
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();	
		}

	}
	
	@Before
	public void Initalization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
		} else if (browserName.equals("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--incognito");
			driver = new FirefoxDriver(option);
		} else if (browserName.equals("edge")) {
			EdgeOptions opetion = new EdgeOptions();
			opetion.addArguments("--incognito");
			driver = new EdgeDriver(opetion);
		}

		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@After
	public void tearDown(Scenario s) throws IOException {

		if (s.isFailed()) {
			// Take screenshot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("screenshots/" + s.getName() + ".png"));
		}
		driver.quit();
	}
	
	public void CleanAndEnterText(WebElement ele, String Value) {
		ele.clear();
		ele.sendKeys(Value);

	}
	
	public void validateText(WebElement ele, String expectedValue) {
		String acctualvalue = ele.getText();
		Assert.assertEquals(expectedValue, acctualvalue);

	}

}
