package pspTechCucumber.browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import pspTechCucumber.baseClass.BaseClass;
import pspTechCucumber.utilities.ConfigReader;

public class BrowserFactory extends BaseClass{

	static ConfigReader cf = PageFactory.initElements(driver, ConfigReader.class); 
	public BrowserFactory() {
		super(driver);		
	}
	
public static WebDriver initiateBrowser() {
	driver = BaseClass.getDriver();
	if(cf.getTestData("browser").equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe" );
	
	driver = new ChromeDriver();
	}
	else if(cf.getTestData("browser").equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\Drivers\\IEdriverServer.exe" );
	driver = new InternetExplorerDriver();
	}
	else if(cf.getTestData("browser").equalsIgnoreCase("fireFox")) {
		System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Drivers\\geckodriver.exe" );
	driver = new FirefoxDriver();
	}
	else if(cf.getTestData("browser").equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver", ".\\src\\test\\resources\\drivers\\msedgedriver.exe" );
	driver = new EdgeDriver();
	}else {
		System.out.println("Invalid Browser Selected");
	}
	
	driver.get(cf.getTestData("URL"));
	return driver;
	}
}
