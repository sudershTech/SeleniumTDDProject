package com.cloudfinder.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.cloudfinder.qa.base.TestBase;


public class LoginPage extends TestBase {

    // Page Factory Object repository
	
    @FindBy(id = "username")
    WebElement Username;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(xpath = "//*[@value='Login']")
    WebElement LoginBtn;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/section/div/div/div[1]/div/div[3]/div")
    WebElement LoginErrorMsg;

    // Constructor of LoginPage to initializing the page objects
    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    // Actions

    // Verify title of login page
    public void Verify_title_of_login_page(String LoginPageTitle) {
       // wait.until(ExpectedConditions.titleContains("Cloudfinder — Login"));
        String title = driver.getTitle();
        Assert.assertEquals(LoginPageTitle, title);
        System.out.println("Cloud Finder login page title verified successfully ");
    }

    // Login Method
    public void Login(String uname,String pwd){
        Username.sendKeys(uname);
        Password.sendKeys(pwd);
        LoginBtn.click();
        System.out.println("User name and password entered successfully");
    }

   // Unsuccessful login message verification
    public void Verify_login_error_msg(String errMsg) {
        // wait.until(ExpectedConditions.titleContains("Cloudfinder — Login"));
        String ErrorMessage = LoginErrorMsg.getText();
        Assert.assertEquals(ErrorMessage,errMsg);
        System.out.println("Login error message verified successfully ");
        //driver.close();
    }
    

    // Verify title of Home page after successful login
    public void Verify_Title_Homepage(String DashboardTitle){
        // Using explicit wait
        TestBase.wait.until(ExpectedConditions.titleContains("Cloudfinder — Dashboard"));
        String title = driver.getTitle();
        Assert.assertEquals(DashboardTitle, title);
        System.out.println("Cloud Finder post login dashboard page title is verified successfully ");
    }
    
    // This method returns home page object
    public HomePage login(String uname, String pwd)
     {
    	 Username.sendKeys(uname);
         Password.sendKeys(pwd);
         LoginBtn.click();
         
         return new HomePage();
    }
}
