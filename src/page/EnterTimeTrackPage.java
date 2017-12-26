package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	@FindBy(xpath="//div[contains(.,'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement abtactiTime;
	
	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement version;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//method for verifying the title
	public void verifyTitle(WebDriver driver,String eTitle) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("PASS:Home page is displayed",true);
		}
		catch(Exception e) {
			Reporter.log("FAIL:Home page NOT displayed",true);
			Assert.fail();
		}
	}
	
	//method to click help menu
	public void clickHelp() {
		help.click();
	}
	
	//method to click on about your actiTIME menu
	public void clickAboutActiTime() {
		abtactiTime.click();
		
	}
	
	//method to verify the product version
	public void verifyVersion(String eVersion) {
		String aVersion=version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	//click close button
	public void clickCloseButton() {
		closeBTN.click();
	}
	
	//click on logout button
	public void clickLogout() {
		logout.click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
