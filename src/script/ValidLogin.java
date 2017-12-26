package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{
	@Test(priority=1,groups= {"smoke","login"})
	public void testValidLogin() {
		String un=XL.getcellValue(XL_PATH, "ValidLogin", 1, 0);
		String pw=XL.getcellValue(XL_PATH, "ValidLogin", 1, 1);
		String eTitle=XL.getcellValue(XL_PATH, "ValidLogin", 1, 2);
		
		//Enter Valid username
		LoginPage l=new LoginPage(driver);
		l.setUsername(un);
		
		//Enter Valid password
		l.setPassword(pw);
		
		//Click Login 
		l.clickLogin();
		
		//verify the home page
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.verifyTitle(driver, eTitle);
		
	}

}
