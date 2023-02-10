package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class LinksPage extends BaseTest {

    public LinksPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-header")
    public WebElement PageHeader;
    @FindBy(id = "simpleLink")
    public WebElement Home;
    @FindBy(id="dynamicLink")
    public WebElement Dynamic;
    @FindBy(id="created")
    public WebElement Created;
    @FindBy(id="no-content")
    public WebElement NoContent;
    @FindBy(id="moved")
    public WebElement Moved;
    @FindBy(id="bad-request")
    public WebElement BadRequest;
    @FindBy(id="unauthorized")
    public WebElement Unauthorized;
    @FindBy(id="forbidden")
    public WebElement Forbidden;
    @FindBy(id="invalid-url")
    public WebElement NotFound;
    @FindBy(id="linkResponse")
    public WebElement LinkResponse;

    //--------------------------------------------------------
    public String pageHeader(){
        waitForVisibility(PageHeader);
        return PageHeader.getText();
    }
    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public void clickOnLinkHome(){

        waitForVisibility(Home);
        Home.click();
    }
    public void homeLinkIsOpened(){
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://demoqa.com");
    }
    public void clickOnDynamicLink(){

        waitForVisibility(Home);
        Home.click();
    }
    public void dynamicLinkIsOpened(){
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://demoqa.com");
    }
    public void clickOnApiLinkCreated(){

        waitForVisibility(Created);
        Created.click();
    }
    public String messageResponse(){
        waitForVisibility(LinkResponse);
        return LinkResponse.getText();
    }
    public void clickOnApiLinkNoContent(){

        waitForVisibility(NoContent);
        NoContent.click();
    }
    public void clickOnApiLinkMoved(){

        waitForVisibility(Moved);
        Moved.click();
    }
    public void clickOnApiLinkBadRequest(){

        waitForVisibility(BadRequest);
        BadRequest.click();
    }
    public void clickOnApiLinkUnauthorized(){

        waitForVisibility(Unauthorized);
        Unauthorized.click();
    }
    public void clickOnApiLinkForbidden() {

        waitForVisibility(Forbidden);
        Forbidden.click();
    }
    public void clickOnApiLinkNotFound() {

        waitForVisibility(NotFound);
        NotFound.click();
    }
}
