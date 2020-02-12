package com.cloudfinder.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cloudfinder.qa.base.TestBase;
import com.cloudfinder.qa.pages.HomePage;
import com.cloudfinder.qa.pages.LoginPage;
import com.cloudfinder.qa.util.TestUtil;

public class HomePageTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
	String sheetName="homepage";
	
	public HomePageTest() {
		super(); //Super keyword call super class(TestBase) constructor containing Properties file code
	}
	
   @BeforeMethod
   public void setUp() {
	  initialization();
	  loginPage= new LoginPage();
	  homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 }
   
   /**Good approach--Test cases should be independent/separated with each other
    * before each test case -- launch the browser and login
    * after each test case -- close the browser
    */
   
   @DataProvider
   public Object[][] getHomePageTestData() {
	   Object data[][]= TestUtil.getTestData(sheetName);
	   return data;
   }
   
   @Test(description="Search and restore user", priority= -1,dataProvider="getHomePageTestData")
   public void restoreUser(String user,String user1) {
	   
	   homePage.Enter_name_of_user(user);
	   homePage.Item_found_text();
	   homePage.Click_CheckBox();
	   homePage.Click_action_button();
	   homePage.Click_restore();
	   homePage.Select_restore_user(user1);
	   homePage.Click_proceed();
	   homePage.Click_restore_button();   
   }
   
  
   
  
   @AfterMethod
   public void tearDown() {
	   driver.quit();
   }
}
