package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BaseTest {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    //Spisak lokatora za kartice na pocetnoj strani
    @FindBy(xpath = "//*[@id='app']//*[text()='Elements']")
    public WebElement Elements;
    @FindBy(xpath = "//*[@id='app']//*[text()='Forms']")
    public WebElement Forms;
//    @FindBy(xpath = "//*[@id='app']//*[text()='Alerts, Frame & Windows']")
//    public WebElement Alerts;
//    @FindBy(xpath = "//*[@id='app']//*[text()='Widgets']")
//    public WebElement Widgets;
//    @FindBy(xpath = "//*[@id='app']//*[text()='Interactions']")
//    public WebElement Interactions;
//    @FindBy(xpath = "//*[@id='app']//*[text()='Book Store Application']")
//    public WebElement Bookstore;

    //pravljenje liste kartica koje se nalaze u lokatoru className
    public List<WebElement> getCards(){
        return driver.findElements(By.className("card-body"));
    }

//----------------------------------------------------------------------
    //Uzimanje teksta iz lokatora za poredjenje da li se odredjeni tekst nalazi na stranici
    public String elements() {

        waitForClickability(Elements);
        return Elements.getText();
    }
    //Proveravanje da li je lokator vidljiv na stranici
    public boolean visibilityOfElements(){
        boolean elements = false;
        try {
            waitForVisibility(Elements);
            elements = true;
        }catch (Exception e){
        }
        return elements;
    }
    //Klik na karticu ciji naziv upisujemo u objekat na test stranici
    public void clickOnCard(String cardName) {
        for (int i = 0; i < getCards().size(); i++) {
            if (getCards().get(i).getText().equals(cardName)) {
                getCards().get(i).click();
                break;
            }
        }
    }
    //Uzimanje URL-a trenutne stranice za poredjenje
    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
}