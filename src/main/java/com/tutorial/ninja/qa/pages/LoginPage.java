package com.tutorial.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "input-email")
    WebElement emailFieldLocator;

    @FindBy(id="input-password")
    WebElement passwordFieldLocator;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButtonLocator;

    @FindBy(xpath = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Password')]")
    WebElement noMatchForEmailAndPassText;

    public String returnWarningTextForEmailAndPassword(){
        String warningText=noMatchForEmailAndPassText.getText();
        return warningText;
    }

    public void inputEmailAddress(String email)
    {
        emailFieldLocator.sendKeys(email);
    }

    public void inputPassword(String password){
        passwordFieldLocator.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButtonLocator.click();
    }



}
