package com.tutorialNinja.qa.testcases;
import com.tutorial.ninja.qa.pages.HomePage;
import com.tutorial.ninja.qa.pages.LoginPage;
import com.tutorialNinja.qa.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;


import static utils.Utitlity.generateEmailWithTimeStamp;

public class Login extends Base {

    public Login() throws IOException {
        super();
    }

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver=initializeAndSetUpBrowser("Chrome");
        HomePage homePage=new HomePage(driver);
        homePage.clickOnAccountLink();
        homePage.clickOnLoginLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test (priority = 1)
    public void verifyLoginWithValidCredentials(){
            LoginPage loginPage=new LoginPage(driver);
            loginPage.inputEmailAddress(testData.getProperty("validEmailAddress"));
            loginPage.inputPassword(testData.getProperty("validPassword"));
            loginPage.clickOnLoginButton();
            Assert.assertTrue(driver.findElement(By.linkText(testData.getProperty("editYourAccountText"))).isDisplayed());
    }

    @Test (priority = 2)
    public void verifyLoginWithInvalidCredentials(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.inputEmailAddress(generateEmailWithTimeStamp());
        loginPage.inputPassword(testData.getProperty("invalidPassword"));
        loginPage.clickOnLoginButton();
        String actualWarningMessage= loginPage.returnWarningTextForEmailAndPassword();
        String expectedWarningMessage= testData.getProperty("noMatchForEmail&Password");
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);


    }

    @Test (priority = 2)
    public void verifyLoginWithInvalidEmailAndValidPasswordCredentials(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.inputEmailAddress(generateEmailWithTimeStamp());
        loginPage.inputPassword(testData.getProperty("validPassword"));
        loginPage.clickOnLoginButton();
        String actualWarningMessage= loginPage.returnWarningTextForEmailAndPassword();
        String expectedWarningMessage= testData.getProperty("noMatchForEmail&Password");
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);

    }

    @Test (priority = 4)
    public void verifyLoginWithvalidEmailAndInvalidPasswordCredentials(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.inputEmailAddress(generateEmailWithTimeStamp());
        loginPage.inputPassword(testData.getProperty("invalidPassword"));
        loginPage.clickOnLoginButton();
        String actualWarningMessage= loginPage.returnWarningTextForEmailAndPassword();
        String expectedWarningMessage= testData.getProperty("noMatchForEmail&Password");
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);



    }

    @Test (priority = 5)
    public void verifyLoginWithoutCredentials(){

        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickOnLoginButton();
        String actualWarningMessage= loginPage.returnWarningTextForEmailAndPassword();
        String expectedWarningMessage= testData.getProperty("noMatchForEmail&Password");
        Assert.assertEquals(actualWarningMessage,expectedWarningMessage);


    }

}
