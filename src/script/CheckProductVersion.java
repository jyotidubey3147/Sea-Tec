package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest {
	private String eVersion;

	@Test(priority=1,groups= {"Product"})
	public void testProductVersion() {
		
		String un=XL.getcellValue(XL_PATH, "ValidLogin", 1, 0);
		String pw=XL.getcellValue(XL_PATH, "ValidLogin", 1, 1);
		
		
		//enter valid username
		LoginPage l=new LoginPage(driver);
		l.setUsername(un);
		
		//enter valid password
		l.setPassword(pw);
		
		//click login button
		l.clickLogin();
		
		
		//click on help menu
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickHelp();
		
				
		//click about your actitime
		e.clickAboutActiTime();
		
		
		//verify product version
		e.verifyVersion(eVersion);;
		
		//click close button
		e.clickCloseButton();
		
		
		//click logout
		e.clickLogout();
	}

}
