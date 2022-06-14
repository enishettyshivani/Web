package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObject {
    public WebDriver driver;
    public PageObject(WebDriver driver) { PageFactory.initElements(driver, this);}

    //accepting the terms
    @FindBy(xpath="//div[@id='notice']/div[3]/button[1]")
    WebElement akkoord;
    public WebElement akkoord() { return akkoord;}

    //tapping on email address
    @FindBy(xpath="//div[@id='pexi-tm-17059__stage']/div[2]/a[1]")
    WebElement login_button;
    public WebElement login_button() { return login_button;}

    //sending text email address
    @FindBy(id="username")
    WebElement email;
    public WebElement email() { return email;}

    //tapping on ga_verder button
    @FindBy(xpath="//*[@id='sel-identify-form']/button")
    WebElement ga_verder;
    public WebElement ga_verder() { return ga_verder;}

    //sending password
    @FindBy(id="password")
    WebElement password;
    public WebElement password() { return password;}

    //tapping on login button
    @FindBy(xpath="//*[@id='sel-login-form']/button")
    WebElement login;
    public WebElement login() { return login;}

    //tap on search
    @FindBy(xpath="/html/body/header/div[3]/a[1]")
    WebElement search;
    public WebElement search() { return search;}

    //send text to search an article
    @FindBy(xpath="//*[@id='main-content']/form/input[1]")
    WebElement search_article;
    public WebElement search_article() { return search_article;}

    //tap on search for an article
    @FindBy(xpath="//*[@id='main-content']/form/input[2]")
    WebElement search_button;
    public WebElement search_button() { return search_button;}

    //tap on article
    @FindBy(xpath="//*[@id='main-content']/div/article[1]/a/header/h4")
    WebElement article;
    public WebElement article() { return article;}

    //tap on main page
    @FindBy(xpath="/html/body/nav[1]/div/ul/li[1]/div/a")
    WebElement mainpage;
    public WebElement mainpage() { return mainpage;}

    //tap on tile
    @FindBy(xpath="//*[@id=\"main-content\"]/section[1]/div/article[1]/a/header")
    WebElement main_tile;
    public WebElement main_tile() { return main_tile;}

    //checking if de Volkskrant text is displayed
    @FindBy(xpath="/html/body/header/div[2]/a")
    WebElement text;
    public WebElement text() { return text;}
}
