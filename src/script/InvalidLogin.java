package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.XL;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority=2,groups= {"login"})
	public void testInvalidLogin() {
		String un=XL.getcellValue(XL_PATH, "InvalidLogin", 1, 0);
		String pw=XL.getcellValue(XL_PATH, "InvalidLogin", 1, 1);
		
		LoginPage l=new LoginPage(driver);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		//verify error msg
		l.verifyMsgIsDisplayed(driver);
	}

}
