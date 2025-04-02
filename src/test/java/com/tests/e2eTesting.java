package com.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.dashboardPage;
import com.pageObjects.loginPage;
import com.pageObjects.signupPage;
import com.utils.driverManager;

public class e2eTesting {
	
	private WebDriver driver;
    private loginPage login;
    private signupPage signup;
    private dashboardPage home;
    
    @BeforeTest
    public void setup() {
        driver = driverManager.getDriver();
        driver.get("https://notes-makers.vercel.app/pages/signup");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signup = new signupPage(driver);
        login = new loginPage(driver);
        home = new dashboardPage(driver);
        
    }
    
    @Test(priority = 1)
    public void testValidSignup() throws InterruptedException {
        signup.enterName("Kartik Sharma");
        signup.enterEmail("Kartiksharma7@gmail.com");
        signup.enterPassword("Password123");
        signup.enterConfirmPass("Password123");
        signup.clickSignup();
        Thread.sleep(3000);
        String accUrl = driver.getCurrentUrl();
        String expUrl = "https://notes-makers.vercel.app/pages/login";
        if(accUrl.equals(expUrl)) {
        	System.out.println("<---------Successful Sign Up--------->");
        }else {
        	System.out.println("<---------Failed to Sign Up---------->");
        }
        
    }

    @Test(priority = 2)
    public void testValidLogin() throws InterruptedException {
        Thread.sleep(3000);
        login.enterEmail("Kartiksharma7@gmail.com");
        login.enterPassword("Password123");
        login.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("notes"));
        Thread.sleep(3000);
    }
    
    @Test(priority = 3)
    public void createAnNotes() throws InterruptedException {
    	Thread.sleep(2000);
    	home.writeNotes();
    	home.verifyNotesPage();
    	home.makeNotesTittle("Introduction");
    	home.makenotes("Hey Everyone, My name is Kartik Sharma");
    	home.saveNotes();
    	home.redirectToHomepage();
    	
    }
    @Test(priority = 4)
    public void createNoteBooks() throws InterruptedException {
    	Thread.sleep(2000);
    	home.clickOnCreateNoteBook();
    	home.writeNoteBookTittle("Hello World!");
    	home.submitCreateNoteBook();
    	Thread.sleep(2000);
    	home.verifyCreateNoteBook();
    }
    @Test(priority = 5)
    public void logoutAccountSuccessfuly() throws InterruptedException {
    	home.clickOnProfile();
    	home.logoutAccount();
    	home.verifyLogout();
    	
    }
    
    @AfterTest
    public void tearDown() {
    	driverManager.quitDriver();
    }

}
