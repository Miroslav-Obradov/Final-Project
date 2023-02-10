package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownloadPage extends BaseTest {
    public UploadAndDownloadPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(className="main-header")
    public WebElement PageHeader;
    @FindBy(id="downloadButton")
    public WebElement DownloadButton;
    @FindBy(id="uploadFile")
    public WebElement UploadButton;


    //---------------------------------------------------

    public String pageHeader(){
        waitForVisibility(PageHeader);
        return PageHeader.getText();
    }
    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public void clickOnDownloadButton(){

        waitForClickability(DownloadButton);
        DownloadButton.click();
    }
    public void clickOnUploadButton() throws InterruptedException {
        Thread.sleep(2000);

        builder.moveToElement(UploadButton).click().build().perform();

    }
}
