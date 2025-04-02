package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObjects.loginPage;

import com.utils.driverManager;

public class LoginTest {
	 WebDriver driver;
	    loginPage login;
	    

	    @BeforeMethod
	    public void setup() {
	        driver = driverManager.getDriver();
	        driver.get("https://notes-makers.vercel.app/pages/login");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        login = new loginPage(driver);
	        
	    }

	    @Test(priority = 1)
	    public void testValidLogin() throws InterruptedException {
	        
	        login.enterEmail("Kartiksharma@gmail.com");
	        login.enterPassword("Password123");
	        login.clickLogin();
	        Assert.assertTrue(driver.getCurrentUrl().contains("notes"));
	        Thread.sleep(3000);
	    }

	    @Test(priority = 2)
	    public void testInvalidLogin() {
	        login.enterEmail("kartik@gmalcom");
	        login.enterPassword("wrongpass");
	        login.clickLogin();
	        //Assert.assertTrue(driver.getPageSource().contains("Login Failed!"));
	    }

	    @AfterMethod
	    public void tearDown() {
	    	driverManager.quitDriver();
	    }


}
