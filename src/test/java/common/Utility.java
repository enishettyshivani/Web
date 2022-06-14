package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import static main.web_automation.driver;

public class Utility {
    public void Screenshot() throws IOException
    {
        //Getting the date of present day
        Date date = new Date();
        //Getting the time and date in a format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        //Capturing the screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        //Adding the filepath and saving the screenshot in jpg format
        File file = new File(dateFormat.format(date) + ".jpg");
        //Getting the captured screenshot file
        File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
        //Saving the screenshot in the specified path
        FileUtils.copyFile(screenshotAs, new File("Screenshot."+file));
    }

    public String reading_properties(String sKey) throws IOException
    {
        FileInputStream fis= new FileInputStream(new File("url.properties"));

        Properties prop = new Properties();
        prop.load(fis);

        return prop.getProperty(sKey);
    }
}


