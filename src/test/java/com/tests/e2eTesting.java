package com.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.createNoteBook;
import com.pageObjects.createNotes;
import com.pageObjects.dashboardPage;
import com.pageObjects.loginPage;
import com.pageObjects.signupPage;
import com.pageObjects.todoListMaker;
import com.utils.driverManager;

public class e2eTesting {
	
	private WebDriver driver;
    private loginPage login;
    private signupPage signup;
    private dashboardPage home;
    private createNoteBook notebook;
    private createNotes notes;
    private todoListMaker todo;
    
    @BeforeTest
    public void setup() {
        driver = driverManager.getDriver();
        driver.get("https://notes-makers.vercel.app/pages/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signup = new signupPage(driver);
        login = new loginPage(driver);
        home = new dashboardPage(driver);
        notebook = new createNoteBook(driver);
        notes = new createNotes(driver);
        todo = new todoListMaker(driver);
        
    }
    
    //@Test(priority = 1)
    public void testValidSignup() throws InterruptedException {
        signup.enterName("Kartik Sharma");
        signup.enterEmail("Kartiksharma16@gmail.com");
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

//    @Test(priority = 2, dependsOnMethods = "testValidSignup")
    @Test(priority = 2)
    public void testValidLogin() throws InterruptedException {
        Thread.sleep(3000);
        login.enterEmail("Kartiksharma16@gmail.com");
        login.enterPassword("Password123");
        login.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("notes"));
        Thread.sleep(3000);
    }
    
    @Test(priority = 3, dependsOnMethods = "testValidLogin")
    public void createNoteBooks() throws InterruptedException {
    	Thread.sleep(2000);
    	notebook.clickOnProfile();
    	notebook.clickProfileNoteBook();
    	Thread.sleep(2000);
    	notebook.verifyNoteBookPage();
    	notebook.clickOnCreateNoteBook();
    	notebook.writeTittle("Demo");
    	notebook.submitNoteBook();
    	
    	notebook.verifyPopNoteBook();
    	Thread.sleep(2000);
    	WebElement pop = driver.findElement(By.xpath("//p[@class='text-[20px] font-bold']"));
    	pop.isDisplayed();
    	pop.click();
    	
    }
    
    
    @Test(priority = 4, dependsOnMethods = "createNoteBooks")
    public void createAnNotes() throws InterruptedException {
    	Thread.sleep(2000);
    	notes.clickOnProfileSection();
    	notes.clickOnProfileNotes();
    	notes.verifyNotePage();
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    	notes.verifyNotePage();
    	notes.clickOnNotebtn();
    	notes.writeTittleofNote("Manual Testing");
    	Thread.sleep(2000);
    	notes.writeDescripationOfNotes("Manual testing is the process of manually checking software for defects by a tester. "
    			+ "Unlike automated testing, which uses tools to run tests, manual testing involves human intervention to execute test cases,"
    			+ " evaluate results, and report bugs. Manual testing helps in verifying the functionality, usability, and reliability of a software application from an end-user perspective.\r\n"
    			+ "");
    	//notes.selectNoteBook();
    	Thread.sleep(2000);
    	//notes.clickOnAddreminder();
    }
    
    @Test(priority = 5, dependsOnMethods = "createAnNotes")
    public void todoMaker() throws InterruptedException {
    	home.clickOnProfile();
    	todo.clickOnProfileTodoList();
    	Thread.sleep(2000);
    	
    	todo.makeTittleOfTodo("Complete Api");
    	todo.selectPriority("High");
    	todo.clickOnAddBtn();
    	Thread.sleep(1000);
    	
    	todo.makeTittleOfTodo("Correction in Project");
    	todo.selectPriority("Low");  	
    	todo.clickOnAddBtn();
    	Thread.sleep(1000);
    	
    	todo.makeTittleOfTodo("Revise Manual Testing");
    	todo.selectPriority("Medium");
    	todo.clickOnAddBtn();
    	Thread.sleep(1000);
    }
    
    
    @Test(priority = 6, dependsOnMethods = "todoMaker")
    public void logoutAccountSuccessfuly() throws InterruptedException {
    	Thread.sleep(3000);
    	home.clickOnProfile();
    	home.logoutAccount();
    	home.verifyLogout();
    	
    }
    
    @AfterTest
    public void tearDown() {
    	driverManager.quitDriver();
    }

}
