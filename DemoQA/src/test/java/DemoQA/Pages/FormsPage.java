package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends BaseTest {
    public FormsPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='item-0']//*[text()='Practice Form']")
    public WebElement PracticeForm;


    //------------------------------------------------------

    public void clickOnFormsPageButton() {
        waitForClickability(PracticeForm);
        PracticeForm.click();
    }
}