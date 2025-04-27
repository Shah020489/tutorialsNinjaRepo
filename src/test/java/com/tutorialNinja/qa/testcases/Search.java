package com.tutorialNinja.qa.testcases;
import com.tutorial.ninja.qa.pages.HomePage;
import com.tutorial.ninja.qa.pages.SearchPage;
import com.tutorialNinja.qa.Base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class Search extends Base {

    WebDriver driver;


    public Search() throws IOException {
            super();
    }

    @BeforeMethod
    public void setup(){
        driver=initializeAndSetUpBrowser("Chrome");
    }

    @Test
    public void verifySearchWithValidText(){

        HomePage homePage=new HomePage(driver);
        homePage.inputTextInSearchField(testData.getProperty("validKeyword"));
        homePage.clickOnSearchButton();
        SearchPage searchPage=new SearchPage(driver);
        String actualString=searchPage.returnSearchSuceessTextHeading();
        String expectedString= testData.getProperty("searchProductCriteria");
        Assert.assertEquals(actualString,expectedString);
        Assert.assertTrue(searchPage.clickOnSearchedProduct());
    }

    @Test
    public void verifySearchWithInvalidText(){
        HomePage homePage=new HomePage(driver);
        homePage.inputTextInSearchField(testData.getProperty("invalidKeyword"));
        homePage.clickOnSearchButton();
        SearchPage searchPage=new SearchPage(driver);
        String actualString=searchPage.getNoProductMatchData();
        String expectedString= testData.getProperty("noProductAtSearchCriteria");
        Assert.assertEquals(actualString,expectedString);


    }

    @Test
    public void verifySearchWithOutAnyText(){

        HomePage homePage=new HomePage(driver);
        homePage.clickOnSearchButton();
        SearchPage searchPage=new SearchPage(driver);
        String actualString=searchPage.getNoProductMatchData();
        String expectedString= testData.getProperty("noProductAtSearchCriteria");
        Assert.assertEquals(actualString,expectedString);


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
