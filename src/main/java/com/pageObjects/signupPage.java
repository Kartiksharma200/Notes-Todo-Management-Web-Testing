package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signupPage {
	 private WebDriver driver;
	    
	    //Constructors
	    public signupPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    
	    //Locators
	    private By nameField = By.xpath("//input[@id='name']");
	    private By emailField = By.xpath("//input[@id='email']");
	    private By passwordField = By.xpath("//input[@id='password']");
	    private By confirmPassField = By.xpath("//input[@id='confirmPassword']");
	    private By signupButton = By.xpath("//body//div//div//main//div//div//div//div//div//button//strong[contains(text(),'Sign Up')]");
	    private By signupLoginLink = By.xpath("//a[contains(@class,'text-primary-950 font-semibold')]");
	    
	    
	    //Methods
	    public void enterName(String name) {
	        driver.findElement(nameField).sendKeys(name);
	    }
	    
	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }
	    
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }
	    
	    public void enterConfirmPass(String confirmpass) {
	    	driver.findElement(confirmPassField).sendKeys(confirmpass);
	    }
	    
	    public void clickSignup() {
	        driver.findElement(signupButton).click();
	    }
	    
	    public void clickOnLoginLink() {
	    	driver.findElement(signupLoginLink).click();
	    }
	    
	    

}
