package com.cloudfinder.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cloudfinder.qa.base.TestBase;

public class ReportsPage extends TestBase {

	    @FindBy(xpath = "//a[contains(text(),'Restore')]")
	    WebElement RestoreTab;

	    @FindBy(xpath = "//tr[1]//td[6]//p[1]//span[1]")
	    WebElement RestoreStatus;

	    // Initializing the page objects
	    public ReportsPage() {

	        PageFactory.initElements(driver, this);
	    }

	    // Actions

	    public void Click_restore_tab() throws InterruptedException{
	    	//wait.until(ExpectedConditions.visibilityOf(RestoreTab));
	        Thread.sleep(4000);
	        RestoreTab.click();
	        System.out.println("Clicked restore header tab successfully");
	    }

	    public void Get_status_restore() throws InterruptedException {
	    	//wait.until(ExpectedConditions.elementToBeClickable(RestoreStatus));
	    	Thread.sleep(4000);
	        RestoreStatus.getText();
	        System.out.println("Get restore status text successfully");
	    }

}
