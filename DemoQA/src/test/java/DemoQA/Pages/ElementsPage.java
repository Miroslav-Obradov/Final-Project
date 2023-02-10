package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ElementsPage extends BaseTest {

    public ElementsPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "main-header")
    public WebElement HeaderElements;
    @FindBy(xpath = "//*[@id='item-0']//*[text()='Text Box']")
    public WebElement TextBox;
    @FindBy(id = "item-1")
    public WebElement CheckBox;
    @FindBy(xpath = "//*[@id='item-2']//*[text()='Radio Button']")
    public WebElement RadioButton;
    @FindBy(xpath = "//*[@id='item-3']//*[text()='Web Tables']")
    public WebElement WebTables;
    @FindBy(xpath = "//*[@id='item-4']//*[text()='Buttons']")
    public WebElement Buttons;
    @FindBy(xpath = "//*[@id='item-5']//*[text()='Links']")
    public WebElement Links;
    @FindBy(xpath = "//*[@id='item-6']//*[text()='Broken Links - Images']")
    public WebElement BrokenLinksImages;
    @FindBy(xpath = "//*[@id='item-7']//*[text()='Upload and Download']")
    public WebElement UploadDownload;
    @FindBy(xpath = "//*[@id='item-8']//*[text()='Dynamic Properties']")
    public WebElement DynamicProperties;


    //------------------------------------------------------

    public void clickOnTextBoxButton() {
        waitForClickability(TextBox);
        TextBox.click();
    }
    public void clickOnCheckBoxButton() {
        waitForClickability(CheckBox);
        CheckBox.click();
    }
    public void clickOnRadioButton(){

        waitForClickability(RadioButton);
        RadioButton.click();
    }
    public void clickOnWebTablesButton(){

        waitForClickability(WebTables);
        WebTables.click();
    }
    public void clickOnButtonsButton(){

        waitForClickability(Buttons);
        Buttons.click();
    }
    public void clickOnLinksButton(){

        waitForClickability(Links);
        Links.click();
    }
    public void clickOnBrokenLinksImagesButton(){

        waitForClickability(BrokenLinksImages);
        BrokenLinksImages.click();
    }
    public void clickOnUploadAndDownloadButton(){

        waitForClickability(UploadDownload);
        UploadDownload.click();
    }
    public void clickOnDynamicPropertiesButton(){

        waitForClickability(DynamicProperties);
        DynamicProperties.click();
    }
    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public String headerElements() {

        waitForClickability(HeaderElements);
        return HeaderElements.getText();
    }

}
