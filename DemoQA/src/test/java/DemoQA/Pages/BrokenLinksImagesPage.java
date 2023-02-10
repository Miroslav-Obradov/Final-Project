package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksImagesPage extends BaseTest {

    public BrokenLinksImagesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className="main-header")
    public WebElement PageHeader;
    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/div[2]/img[1]")
    public WebElement DisplayedImage;
    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div[2]/div[2]/img[1]")
    public WebElement BrokenImage;
    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement ValidLink;
    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement BrokenLink;
    @FindBy( className = "example")
    public WebElement ErrorPageHeader;



    //---------------------------------------------
    public String pageHeader(){
        waitForVisibility(PageHeader);
        return PageHeader.getText();
    }
    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public boolean validateDisplayedImage(){
        Boolean p = (Boolean) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].complete "
                        + "&& typeof arguments[0].naturalWidth != 'undefined' "
                        + "&& arguments[0].naturalWidth > 0", DisplayedImage);
        return p;
    }
    public boolean validateBrokenImage(){
        Boolean p = (Boolean) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].complete "
                        + "&& typeof arguments[0].naturalWidth != 'undefined' "
                        + "&& arguments[0].naturalWidth > 0", BrokenImage);
        return p;
    }
    public void validateValidLink(){
        waitForClickability(ValidLink);
        ValidLink.click();
    }
    public void validateBrokenLink(){
        waitForClickability(BrokenLink);
        BrokenLink.click();
    }
    public String errorPageHeader(){
        waitForVisibility(ErrorPageHeader);
        return ErrorPageHeader.getText();
    }
}
