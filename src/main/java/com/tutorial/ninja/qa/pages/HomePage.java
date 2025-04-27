package com.tutorial.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    @FindBy(linkText = "Login")
    WebElement loginLinkLocator;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchTextField;

    @FindBy(xpath = "//div[@id='search']//button[@type='button']")
    WebElement searchButton;

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement accountLink;

    @FindBy(linkText = "Register")
    WebElement registerLinkLocator;

    public void clickOnRegisterLink(){
        registerLinkLocator.click();
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void inputTextInSearchField(String text){
        System.out.println(text);
        searchTextField.sendKeys(text);
    }

    public void clickOnLoginLink(){
        loginLinkLocator.click();
    }


    public void clickOnAccountLink(){
        accountLink.click();
    }

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
