package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createNoteBook {

	WebDriver driver;

	// Locators
	
	// Click on Profile
	private By profile = By.xpath("(//*[@stroke=\"currentColor\"])[1]");
	// Click on Profile section Notebooks
	private By profileNotebook = By.xpath("//li[normalize-space()='Notebooks']");
	// Confirm the Page of Note Book
	private By notePageTittle = By.xpath("//h1[contains(@class,'text-gray-800 text-3xl font-bold')]");
	// Click on Create note book
	private By createNoteBooks = By.xpath("//strong[@class='flex items-center justify-center']");
	// Write tittle of note book
	private By noteBookTittle = By.xpath("//input[@id='title']");
	// click on submit submit button
	private By noteBookSubmit = By.xpath("//strong[normalize-space()='Submit']");
    //Verify Pop
	private By verifyPop = By.xpath("//body/div[@class='flex']/div[@class='flex-1 flex flex-col']/main[@class='mt-16 min-h-[95vh] ']/div[@class='p-8 bg-gray-100 min-h-screen']/section[@aria-label='Notifications Alt+T']/div[@class='Toastify__toast-container Toastify__toast-container--top-right']/div[1]");
	
	
	// Constructor
	public createNoteBook(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods
	
	public void clickOnProfile() {
		driver.findElement(profile).click();
	}
	
	public void clickProfileNoteBook() {
		driver.findElement(profileNotebook).click();
	}
	
	public void verifyNoteBookPage() {
		String accUrl = driver.getCurrentUrl();
		String expUrl = "https://notes-makers.vercel.app/pages/note-book";
		
		if(accUrl.equals(expUrl)) {
			System.out.println("<---------Successful in Create Note book Page--------->");
		}else {
			System.out.println("<---------Failed to Verify Note book page-------->");
		}
		
		driver.findElement(notePageTittle).isDisplayed();
	}
	
	public void clickOnCreateNoteBook() {
		driver.findElement(createNoteBooks).click();
	}
	
	public void writeTittle(String Tittle) {
		WebElement tittle = driver.findElement(noteBookTittle);
		tittle.click();
		tittle.sendKeys(Tittle);
	}
	
	public void submitNoteBook() {
		driver.findElement(noteBookSubmit).click();
	}
	
	public void verifyPopNoteBook() {
		driver.findElement(verifyPop).isDisplayed();
		
	}

}
