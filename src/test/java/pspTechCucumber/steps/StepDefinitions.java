package pspTechCucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pspTechCucumber.baseClass.BaseClass;
import pspTechCucumber.browserFactory.BrowserFactory;
import pspTechCucumber.pages.Registration;
import pspTechCucumber.utilities.CommonMethods;

public class StepDefinitions extends BaseClass {


	public StepDefinitions() {
		super(driver);
	}
	
	Registration registration;
	
	@Given("User enters correct url of the Mercury Tours application")
	public void user_enters_correct_url_of_the_mercury_tours_application() {
		driver= BrowserFactory.initiateBrowser();
		logger.info("Browser is getting initialized - Opening Home Page");
		registration = PageFactory.initElements(driver, Registration.class);
		CommonMethods.maximizeBrowser();
		CommonMethods.getTitle(driver, "Welcome: Mercury Tours");
		CommonMethods.getCurrentUrl(driver, "https://demo.guru99.com/test/newtours/");
	}
	
	@Given("Clicks on Registration")
	public void clicks_on_registration() {
		logger.info("Clicks on Registration");
	    CommonMethods.click(registration.homeRegnPageLinkClick, driver);
	    CommonMethods.getCurrentUrl(driver, "https://demo.guru99.com/test/newtours/register.php");
	}
	
	@And("User navigates to the registration page")
	public void user_navigates_to_the_registration_page() {
		logger.info("Navigating to Registration Page");
	    CommonMethods.click(registration.homeRegnPageLinkClick, driver);
	    CommonMethods.getTitle(driver, "Register: Mercury Tours");
	    
	}
	@When("User enters the all required data")
	public void user_enters_the_all_required_data() {
		CommonMethods.sendData(registration.regnFirstName, driver, "Mirza");
		CommonMethods.sendData(registration.regnLastName, driver, "Awal");
		CommonMethods.sendData(registration.regnPhone, driver, "1(800) 123 2345");
		CommonMethods.sendData(registration.regnEmail, driver, "psptech@gmail.com");
		CommonMethods.sendData(registration.regnAddress, driver, "1234 NW 1st Ave, Hollywood.");
		CommonMethods.sendData(registration.regnCity, driver, "Hollywood");
		CommonMethods.sendData(registration.regnState, driver, "Florida");
		CommonMethods.sendData(registration.regnPostalCode, driver, "33024");
		CommonMethods.sendData(registration.regnCountry, driver, "United States");
		CommonMethods.sendData(registration.regnUserName, driver, "psptech1");
		CommonMethods.sendData(registration.regnPassword, driver, "Tech#123");
		CommonMethods.sendData(registration.regnCfmPassword, driver, "Tech#123");
	}
	@And("User clicks on the submit button")
	public void user_clicks_on_the_submit_button() {
	  logger.info("Submit button clicked");
	  CommonMethods.click(registration.regnSubmit, driver);
	}
	@Then("User successfully registers into the Murcury Tours application")
	public void user_successfully_registers_into_the_murcury_tours_application() {
		logger.info("Registration Successfull");
		CommonMethods.getCurrentUrl(driver, "https://demo.guru99.com/test/newtours/register_sucess.php");
	}
	
	@When("User does not enter all required data")
	public void user_does_not_enter_all_required_data() {
		logger.info("Incomplete data entered");
		CommonMethods.sendData(registration.regnFirstName, driver, "Mirza");
		CommonMethods.sendData(registration.regnLastName, driver, "Awal");
		CommonMethods.sendData(registration.regnPhone, driver, "1(800) 123 2345");
		CommonMethods.sendData(registration.regnEmail, driver, "psptech@gmail.com");
		CommonMethods.sendData(registration.regnAddress, driver, "1234 NW 1st Ave, Hollywood.");
	
	}
	@When("User clicks on the submit button without all data")
	public void user_clicks_on_the_submit_button_without_all_data() {
		logger.info("Submit button clicked without data");
		CommonMethods.click(registration.regnSubmit, driver);
	}
	@Then("User fails to registers into the Murcury Tours application")
	public void user_fails_to_registers_into_the_murcury_tours_application() {
		logger.info("Registration Unsuccessfull");
		CommonMethods.getTitle(driver, "Register: Mercury Tours");
	}
	
	@Given("User enters the url of the Mercury Tours application")
	public void user_enters_the_url_of_the_mercury_tours_application() {	    
		driver= BrowserFactory.initiateBrowser();
		logger.info("Browser is getting initialized - Opening Home Page");
		registration = PageFactory.initElements(driver, Registration.class);
		CommonMethods.maximizeBrowser();		
		CommonMethods.getCurrentUrl(driver, "https://demo.guru99.com/test/newtours/");
	}
	
	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() {
		System.out.println("Navigated to Login Page");
		String actualPageTitle = driver.getTitle();
		System.out.println("Actual Title of the page is: " + actualPageTitle);
		String expectedPageTitle = "Welcome: Mercury Tours";
		Assert.assertEquals(actualPageTitle, expectedPageTitle);	
	    
	}
	@When("User enters the valid username and valid password")
	public void user_enters_the_valid_username_and_valid_password() {
		driver.findElement(By.name("userName")).sendKeys("psptech1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Tech#123"); 
	}
	@When("User clicks on the submit button in home page")
	public void user_clicks_on_the_submit_button_in_home_page() {
		driver.findElement(By.name("submit")).click();
	}
	@Then("User successfully login into the Murcury Tours application")
	public void user_successfully_login_into_the_murcury_tours_application() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://demo.guru99.com/test/newtours/login_sucess.php";
		Assert.assertEquals(actualUrl, expectedUrl); 
	}
	
	@When("User enters the invalid credentials")
	public void user_enters_the_invalid_credentials() {
		driver.findElement(By.name("userName")).sendKeys("psptech1");
		driver.findElement(By.name("password")).sendKeys("Tech"); 
	}
	@When("User clicks on the submit button in home page with invalid credentials")
	public void user_clicks_on_the_submit_button_in_home_page_with_invalid_credentials() {
		driver.findElement(By.name("submit")).click();
	}
	@Then("User failed login into the Murcury Tours application")
	public void user_failed_login_into_the_murcury_tours_application() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://demo.guru99.com/test/newtours/index.php";
		Assert.assertEquals(actualUrl, expectedUrl);
	
	}
	
//	@Given("User navigates to the login page")
//	public void user_navigates_to_the_login_page() {
//		System.out.println("Navigated to Login Page");
//		String actualPageTitle = driver.getTitle();
//		System.out.println("Actual Title of the page is: " + actualPageTitle);
//		String expectedPageTitle = "Welcome: Mercury Tours";
//		Assert.assertEquals(actualPageTitle, expectedPageTitle);	
//	}
//	@When("User enters the valid username and valid password")
//	public void user_enters_the_valid_username_and_valid_password() {
//		driver.findElement(By.name("userName")).sendKeys("psptech1@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("Tech#123");
//		
//	}
//	@When("User clicks on the submit button in home page")
//	public void user_clicks_on_the_submit_button_in_home_page() {
//		driver.findElement(By.name("submit")).click();
//	}
//	@Then("User successfully login into the Murcury Tours application")
//	public void user_successfully_login_into_the_murcury_tours_application() {
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "https://demo.guru99.com/test/newtours/login_sucess.php";
//		Assert.assertEquals(actualUrl, expectedUrl);
//	
//	}
//	@When("User enters the invalid credentials")
//	public void user_enters_the_invalid_credentials() {
//		driver.findElement(By.name("userName")).sendKeys("psptech1");
//		driver.findElement(By.name("password")).sendKeys("Tech");
//	}
//	@When("User clicks on the submit button in home page with invalid credentials")
//	public void user_clicks_on_the_submit_button_in_home_page_with_invalid_credentials() {
//		driver.findElement(By.name("submit")).click();
//	}
//	@Then("User failed login into the Murcury Tours application")
//	public void user_failed_login_into_the_murcury_tours_application() {
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "https://demo.guru99.com/test/newtours/index.php";
//		Assert.assertEquals(actualUrl, expectedUrl);
//	}
}
