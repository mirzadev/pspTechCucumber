package pspTechCucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

	@FindBy(xpath = "(//*[@href='register.php'])[1]")
	public WebElement homeRegistrationLink;
	
	@FindBy(name= "userName")
	public WebElement homeUserName;
	
	@FindBy(name= "password")
	public WebElement homePassword;
	
	@FindBy(name= "submit")
	public WebElement homeSubmitButton;

}
