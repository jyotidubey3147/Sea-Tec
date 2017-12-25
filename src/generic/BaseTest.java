package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst {
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(String browser) {
		if(browser.equals("chrome")) {
		driver=new ChromeDriver();
		}
		else {
			driver=new FirefoxDriver();
		}
		
		
		String url="";
		driver.get(url);
		//String strIto=AL.getProperty(SETTINGS_PATH,"ITO");
		//long Ito=Long.parseLong(strIto);
		//driver.manage().timeouts().implicitlyWait(Ito, TimeUnit.SECONDS);
		
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult res) {
		String reslt = res.getName();
		int status = res.getStatus();
		if(status==2) {
			//String imgPath=AL.getPhoto(driver,PHOTO_PATH,name);
			//Reporter.log("Image path:" +imgPath,true);
		}
		driver.close();
	}

}
