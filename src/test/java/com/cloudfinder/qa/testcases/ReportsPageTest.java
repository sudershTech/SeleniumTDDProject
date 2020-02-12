package com.cloudfinder.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cloudfinder.qa.base.TestBase;
import com.cloudfinder.qa.pages.HomePage;
import com.cloudfinder.qa.pages.LoginPage;
import com.cloudfinder.qa.pages.ReportsPage;

public class ReportsPageTest extends TestBase {
    
	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportsPage;
	public ReportsPageTest() {
		super(); //Super keyword call super class(TestBase) constructor containing Properties file code
	}
	
   @BeforeMethod
   public void setUp() {
	  initialization();
	  reportsPage= new ReportsPage();
	  loginPage= new LoginPage();
	  homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 }
	 
	 @Test(description="Tracking progress of restore")
	   public void restoreStatus() throws InterruptedException {
		   homePage.Click_reports_tab();
		   reportsPage.Click_restore_tab();
		   reportsPage.Get_status_restore();
	   }
	   
	 @AfterMethod
	   public void tearDown() {
		   driver.quit();
	   }
}
