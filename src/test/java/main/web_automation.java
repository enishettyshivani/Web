package main;

import java.io.IOException;
import common.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.PageObject;
import org.testng.log4testng.Logger;

public class web_automation {
    Utility strUtil = new Utility();
    public static WebDriver driver = new ChromeDriver();
    static Logger LOG= Logger.getLogger(web_automation.class);
    @Test
    public void login() throws IOException
    {
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
            WebDriverWait wait = new WebDriverWait(driver,30);
            driver.get(strUtil.reading_properties("url"));
            driver.manage().window().maximize();
            driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='sp_message_iframe_657795']")));
            PageObject vs = new PageObject(driver);
            //Accepting terms
            vs.akkoord().click();
            wait.until(ExpectedConditions.visibilityOf(vs.login_button()));
            //Searching for an article and clicking on it
            vs.search().click();
            vs.search_article().sendKeys(strUtil.reading_properties("search"));
            vs.search_button().click();
            vs.article().click();
            //tapping on the mainpage
            vs.mainpage().click();
            wait.until(ExpectedConditions.visibilityOf(vs.text()));
            //checking for a text to be displayed in the main page
            String text = vs.text().getText();
            if(text.equals(strUtil.reading_properties("text")))
            {
                System.out.println(text+":Text is displayed");
            }
            else
            {
                System.out.println(text+":Text is not displayed");
            }
            //tapping on the main tile
            vs.main_tile().click();
            //tapping again on the mainpage
            vs.mainpage().click();
            //Logging into dpgmedia
            wait.until(ExpectedConditions.visibilityOf(vs.login_button()));
            vs.login_button().click();
            vs.email().sendKeys(strUtil.reading_properties("email"));
            vs.ga_verder().click();
            vs.password().sendKeys(strUtil.reading_properties("password"));
            wait.until(ExpectedConditions.visibilityOf(vs.login()));
            vs.login().click();
            driver.close();
        }
        catch (Exception e)
        {
            strUtil.Screenshot();
            LOG.info("Exception  ||  Error Message:  "+e.getMessage());
            Assert.fail("Exception  ||  Error Message:  "+e.getMessage());
        }
    }
}

