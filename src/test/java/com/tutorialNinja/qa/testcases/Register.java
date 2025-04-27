package com.tutorialNinja.qa.testcases;
import com.tutorial.ninja.qa.pages.Accoutsuccess;
import com.tutorial.ninja.qa.pages.HomePage;
import com.tutorial.ninja.qa.pages.RegisterPage;
import com.tutorialNinja.qa.Base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import static utils.Utitlity.generateEmailWithTimeStamp;

public class Register extends Base {

    WebDriver driver;

    public Register() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp(){
        driver=initializeAndSetUpBrowser("Chrome");
        HomePage homePage=new HomePage(driver);
        homePage.clickOnAccountLink();
        homePage.clickOnRegisterLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1)
public void verifySignUpwithRequiredFields(){

        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.inputFirstName(testData.getProperty("firstName"));
        registerPage.inputLastName(testData.getProperty("lastName"));
        registerPage.inputEmail(generateEmailWithTimeStamp());
        registerPage.inputTelephone(testData.getProperty("phone"));
        registerPage.enterPassword(testData.getProperty("validPassword"));
        registerPage.enterConfirmPassword(testData.getProperty("validPassword"));
        registerPage.clickOnYesCheckBox();
        registerPage.clickOnContinueBtn();
        Accoutsuccess accoutsuccess=new Accoutsuccess(driver);
        String actualString=accoutsuccess.getSuccessMessage();
        String expectedString= testData.getProperty("successMessageOnAccountCreated");
        Assert.assertEquals(actualString,expectedString);



}

    @Test (priority = 2)
    public void verifySignUpWithAllFields(){

        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.inputFirstName(testData.getProperty("firstName"));
        registerPage.inputLastName(testData.getProperty("lastName"));
        registerPage.inputEmail(generateEmailWithTimeStamp());
        registerPage.inputTelephone(testData.getProperty("phone"));
        registerPage.enterPassword(testData.getProperty("validPassword"));
        registerPage.enterConfirmPassword(testData.getProperty("validPassword"));
        registerPage.clickOnYesNewsletterCheckBox();
        registerPage.clickOnYesCheckBox();
        registerPage.clickOnContinueBtn();
        Accoutsuccess accoutsuccess=new Accoutsuccess(driver);
        String actualString=accoutsuccess.getSuccessMessage();
        String expectedString= testData.getProperty("successMessageOnAccountCreated");
        Assert.assertEquals(actualString,expectedString);

    }

    @Test (priority = 2)
    public void verifySignUpFieldWithOutInputAnyField(){

        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnContinueBtn();
        String actualFirstNameMessage= registerPage.getFirstNameErrorMessage();
        String expectedFirstNameMessage= testData.getProperty("firstNameError");
        Assert.assertEquals(actualFirstNameMessage,expectedFirstNameMessage);
        String actualLastNameMessage= registerPage.getLastNameErrorMessage();
        String expectedLastNameMessage= testData.getProperty("lastNameError");
        Assert.assertEquals(actualLastNameMessage,expectedLastNameMessage);
        String actualTelephoneMessage= registerPage.getTelephoneErrorMessage();
        String expectedTelephoneMessage= testData.getProperty("telephoneError");
        Assert.assertEquals(actualTelephoneMessage,expectedTelephoneMessage);
        String actualPasswordMessage= registerPage.getPasswordErrorMessage();
        String expectedPasswordMessage= testData.getProperty("passwordError");
        Assert.assertEquals(actualPasswordMessage,expectedPasswordMessage);

    }

    @Test (priority = 4)
    public void verifySignUpWithAlreadySavedEmail(){

        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.inputFirstName(testData.getProperty("firstName"));
        registerPage.inputLastName(testData.getProperty("lastName"));
        registerPage.inputEmail(testData.getProperty("validEmailAddress"));
        registerPage.inputTelephone(testData.getProperty("phone"));
        registerPage.enterPassword(testData.getProperty("validPassword"));
        registerPage.enterConfirmPassword(testData.getProperty("validPassword"));
        registerPage.clickOnYesCheckBox();
        registerPage.clickOnContinueBtn();
        String actualError=registerPage.getEmailAlreadyText();
        String expectedError= testData.getProperty("emailAlreadyExistText");
        Assert.assertEquals(actualError,expectedError);


    }


}
