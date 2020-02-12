package com.cloudfinder.qa.testcases;

import com.cloudfinder.qa.base.TestBase;
import com.cloudfinder.qa.pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	
	public LoginPageTest() {
		super(); // Super keyword call super class(TestBase) constructor containing Properties file code
	}
	
	
   @BeforeMethod
   public void setUp() {
	   initialization();
	   loginPage= new LoginPage();
   }
   
   @Test(priority=1)
   public void loginPageTitleTest() {
	   loginPage.Verify_title_of_login_page("Cloudfinder — Login");
   }
   
   @Test(priority=2)
   public void loginFailedTest() {
	   loginPage.Login(prop.getProperty("username"), prop.getProperty("passwordF"));
	   
   }
   
   @Test(priority=3)
   public void loginSuccessTest() {
	   loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	   loginPage.Verify_Title_Homepage("Cloudfinder — Dashboard");
	   
   }
   
   
   
   @AfterMethod
   public void tearDown() {
	   driver.quit();
   }

}
