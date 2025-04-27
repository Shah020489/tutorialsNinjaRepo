package com.tutorial.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "input-firstname")
    WebElement firstNameLocator;

    @FindBy(id = "input-lastname")
    WebElement lastNameLocator;

    @FindBy(id = "input-email")
    WebElement emailAddress;

    @FindBy(id="input-telephone")
    WebElement telephoneLocator;

    @FindBy(id = "input-password")
    WebElement passwordLocator;

    @FindBy(id = "input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement agreeCheckBox;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    WebElement newsletterYesField;

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    WebElement firstNameErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
    WebElement lastNameErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
    WebElement telephoneErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
    WebElement passwordErrorMessage;


    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    WebElement emailAlreadyExistMessage;

    public String getFirstNameErrorMessage(){
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessage(){
        return lastNameErrorMessage.getText();
    }

    public String getTelephoneErrorMessage(){
        return telephoneErrorMessage.getText();
    }

    public String getPasswordErrorMessage(){
        return passwordErrorMessage.getText();
    }

    public String getEmailAlreadyText(){
        return emailAlreadyExistMessage.getText();
    }


    public void inputFirstName(String str){
        firstNameLocator.sendKeys(str);
    }

    public void inputLastName(String str){
        lastNameLocator.sendKeys(str);
    }

    public void inputEmail(String str){
        emailAddress.sendKeys(str);
    }

    public void inputTelephone(String str){
        telephoneLocator.sendKeys(str);
    }

    public void enterPassword(String str){
        passwordLocator.sendKeys(str);
    }
    public void enterConfirmPassword(String str){
        confirmPassword.sendKeys(str);
    }

    public void clickOnYesCheckBox(){
        agreeCheckBox.click();
    }

    public void clickOnContinueBtn(){
        continueButton.click();
    }

    public void clickOnYesNewsletterCheckBox(){
        newsletterYesField.click();
    }




}
