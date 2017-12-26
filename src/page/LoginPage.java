package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[contain(.,'invalid')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//methods to enter the username in UN text box
	public void setUsername(String un) {
		unTB.sendKeys(un);
		
	}
	//methods to enter the password in  text box
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	
	//methods to click on login button
	public void clickLogin() {
		loginBTN.click();
	}
	
	//methods to verify the error msg
	public void verifyMsgIsDisplayed(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("PASS:Error msg is displayed",true);
		}
		catch(Exception e) {
			Reporter.log("FAIL:Error msg NOT displayed",true);
			Assert.fail();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
