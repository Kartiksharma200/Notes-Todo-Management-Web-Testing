package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class createNotes {

	WebDriver driver;

	// Constructor
	public createNotes(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	
	// Click on Profile
	private By profile = By.xpath("(//*[@stroke=\"currentColor\"])[1]");
	// Click on Notes
	private By profileNotes = By.xpath("//li[normalize-space()='Notes']");
	// Home Page write Notes
	private By writeNotesBtn = By.xpath("//strong[normalize-space()='Write Notes']");
	// Note Tittle
	private By writeNoteTittle = By.xpath("//input[contains(@placeholder,'Notes Title')]");
	// Description
	private By writeDescription = By.xpath("//div[@class='ql-editor ql-blank']");
	// Select NoteBook
	private By selectNoteBook = By.xpath("//div[@class='css-19bb58m']");
	//Select add reminder
	private By addReminder = By.xpath("//strong[normalize-space()='Add Reminder']");
	
	
	public void clickOnProfileSection() {
		driver.findElement(profile).click();
	}
	
	public void clickOnProfileNotes() {
		driver.findElement(profileNotes).click();
	}
	
	public void verifyNotePage() {
		if(driver.findElement(writeNotesBtn).isDisplayed()) {
			System.out.println("<--------Verify Note Page Tittle-------->");
		}else {
			System.out.println("<--------Failed to verify note page tittle--------->");
		}
		
		
	}
	
	public void clickOnNotebtn() {
		driver.findElement(writeNotesBtn).click();
	}
	
	public void writeTittleofNote(String NoteTittle) {
		driver.findElement(writeNoteTittle).sendKeys(NoteTittle);
	}
	
	public void writeDescripationOfNotes(String NoteDescripation) {
		driver.findElement(writeDescription).sendKeys(NoteDescripation);
	}

	public void selectNoteBook() {
		WebElement dropdown = driver.findElement(selectNoteBook);
		Select select = new Select(dropdown);
		select.selectByVisibleText("Software Testing Life Cycle");
	}
	
	public void clickOnAddreminder() {
		driver.findElement(addReminder).click();
	}
}
