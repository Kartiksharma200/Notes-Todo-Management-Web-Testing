package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageObjects.signupPage;
import com.utils.driverManager;

public class SignupTest {
	
	 private WebDriver driver;
	 private signupPage signup;
	    
	    @BeforeMethod
	    public void setUp() {
	        driver = driverManager.getDriver();
	        driver.get("https://notes-makers.vercel.app/pages/signup");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        signup = new signupPage(driver);
	    }
	    
	    @Test(priority = 1)
	    public void testValidSignup() throws InterruptedException {
	        signup.enterName("Kartik Sharma");
	        signup.enterEmail("Kartiksharma1@gmail.com");
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
	    public void testInvalidSignup() throws InterruptedException {
	        signup.enterName("         ");
	        signup.enterEmail("invalidemail@gmail.com");
	        signup.enterPassword("123");
	        signup.enterConfirmPass("123");
	        Thread.sleep(3000);
	        signup.clickSignup();
	        Thread.sleep(2000);
	        WebElement signupError = driver.findElement(By.xpath("//div[@id='3']"));
	        if(signupError.isDisplayed()) {
	        	System.out.println("<----------Sign Failed!----------->");
	        }else {
	        	System.out.println("<---------Failed to catch error---------->");
	        }
	        
	       
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        driverManager.quitDriver();
	    }

}
