package com.tutorial.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accoutsuccess {
    WebDriver driver;


    public Accoutsuccess(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement successMessageHeading;


    public String getSuccessMessage(){
        return successMessageHeading.getText();
    }




}
