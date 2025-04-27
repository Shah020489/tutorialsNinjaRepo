package com.tutorial.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath  ="//h2[normalize-space()='Products meeting the search criteria']")
    WebElement searchTextHeading;

    public String returnSearchSuceessTextHeading(){
        String text=searchTextHeading.getText();
        return text;
    }

    @FindBy(linkText = "HP LP3065")
    WebElement successProductLinkText;

    public boolean clickOnSearchedProduct(){
        successProductLinkText.click();
        return true;
    }

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criteria.')]")
    WebElement noProductText;

    public String getNoProductMatchData(){
        return noProductText.getText();
    }




}
