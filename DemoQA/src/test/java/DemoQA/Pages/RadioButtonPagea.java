package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPagea extends BaseTest {
    public RadioButtonPagea(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Yes']")
    public WebElement RadioButtonYes;
    @FindBy(xpath = "//*[text()='Impressive']")
    public WebElement RadioButtonImpressive;
    @FindBy(className = "main-header")
    public WebElement RadioButtonHeader;
    @FindBy(className="mt-3")
    public WebElement MessageSelected;
    @FindBy(className="text-success")
    public WebElement MessageButton;
    @FindBy(xpath = "//span[text()='Yes']")
    public WebElement MessageButtonYes;
    @FindBy(xpath = "//span[text()='Impressive']")
    public WebElement MessageButtonImpressive;
    @FindBy(id="noRadio")
    public WebElement NoRadio;





    //-------------------------------------------------------

    public String headerRadioButton(){
        waitForVisibility(RadioButtonHeader);
        return RadioButtonHeader.getText();
    }
    public void clickOnRadioButtonYes(){
        waitForClickability(RadioButtonYes);
        RadioButtonYes.click();
    }
    public void clickOnRadioButtonImpressive(){
        waitForClickability(RadioButtonImpressive);
        RadioButtonImpressive.click();
    }
    public boolean visibilityOfRadioButtonYes(){
        boolean radioButton = false;
        try {
            waitForVisibility(MessageButton);
            radioButton = true;
        }catch (Exception e){
        }
        return radioButton;
    }
    public boolean visibilityOfRadioButtonImpressive(){
        boolean radioButton = false;
        try {
            waitForVisibility(MessageButton);
            radioButton = true;
        }catch (Exception e){
        }
        return radioButton;
    }
    public boolean visibilityOfMessageSelected(){
        boolean radioButton = false;
        try {
            waitForVisibility(MessageSelected);
            radioButton = true;
        }catch (Exception e){
        }
        return radioButton;
    }
    public boolean visibilityOfMessageNotSelectedYes(){
        boolean radioButton = false;
        try {
            waitForVisibility(MessageButtonYes);
            radioButton = true;
        }catch (Exception e){
        }
        return radioButton;
    }
    public boolean visibilityOfMessageNotSelectedImpressive(){
        boolean radioButton = false;
        try {
            waitForVisibility(MessageButtonImpressive);
            radioButton = true;
        }catch (Exception e){
        }
        return radioButton;
    }
    public String noRadioAllowed() {
        String actualMousePointer = NoRadio.getCssValue("cursor");
        return actualMousePointer;
    }
}
