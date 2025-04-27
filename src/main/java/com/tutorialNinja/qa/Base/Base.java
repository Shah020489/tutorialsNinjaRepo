package com.tutorialNinja.qa.Base;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Utitlity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public Properties testData;

    public Base() throws IOException {

        prop=new Properties();
        File propFile= new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorial\\ninja\\qa\\config\\config.properties");

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        }
        catch (Throwable e) {
        e.printStackTrace();
        }

        testData=new Properties();
        File testDataFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorial\\ninja\\qa\\testData\\testData.properties");

        try {
            FileInputStream dataFile=new FileInputStream(testDataFile);
            testData.load(dataFile);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public  WebDriver initializeAndSetUpBrowser(@NotNull String browserName){

        if (browserName.equals("Chrome")){
            driver=new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            driver=new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            driver=new EdgeDriver();
        } else if (browserName.equals("Safari")) {
            driver=new SafariDriver();
        }
        else {
            System.out.println("You had entered wrong browser name.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utitlity.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utitlity.PAGE_LOAD_TIME));
        driver.get(prop.getProperty("url"));
        return driver;
    }
}
