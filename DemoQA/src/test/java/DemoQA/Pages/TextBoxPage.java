package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {

    public TextBoxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='item-0']//*[text()='Text Box']")
    public WebElement TextBox;
    @FindBy(id="userName")
    public WebElement FullName;

    @FindBy(id="userEmail")
    public WebElement Email;
    @FindBy(id="currentAddress")
    public WebElement CurrentAddress;
    @FindBy(id="permanentAddress")
    public WebElement PermanentAddress;
    @FindBy(id="submit")
    public WebElement SubmitButton;
    @FindBy(id="name")
    public WebElement ComapareFullName;
    @FindBy(id="email")
    public WebElement CompareEmail;
    @FindBy(xpath = "//*[@id='output']//*[text()='Current Address :']")
    public WebElement CompareCurrentAdress;
    @FindBy(xpath = "//*[@id='output']//*[text()='Permananet Address :']")
    public WebElement ComparePermanentAdress;
    @FindBy(css = ".mr-sm-2.field-error.form-control")
    public WebElement InvalidEmailForm;
    @FindBy(css = ".border.col-md-12.col-sm-12")
    public WebElement SubmitedForm;
    //-------------------------------------------------s-----

    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public void insertFullName(String userName){

        waitForVisibility(FullName);
        FullName.clear();
        FullName.click();
        FullName.sendKeys(userName);
    }
    public void insertEmail(String email){

        waitForVisibility(Email);
        Email.clear();
        Email.click();
        Email.sendKeys(email);
    }
    public void insertCurrentAddress(String currentAddress){
        waitForVisibility(CurrentAddress);
        CurrentAddress.clear();
        CurrentAddress.click();
        CurrentAddress.sendKeys(currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress){

        waitForVisibility(PermanentAddress);
        PermanentAddress.clear();
        PermanentAddress.click();
        PermanentAddress.sendKeys(permanentAddress);
    }
    public void clickOnSubmitButton(){
        waitForClickability(SubmitButton);
        SubmitButton.click();
    }
    public boolean visibilityOfFullName(){
        boolean fullName = false;
        try {
            waitForVisibility(ComapareFullName);
            fullName = true;
        }catch (Exception e){
        }
        return fullName;
    }
    public String fullNameIsInserted(){
        waitForVisibility(ComapareFullName);
        return ComapareFullName.getText();
    }
    public boolean visibilityOfEmail(){
        boolean fullName = false;
        try {
            waitForVisibility(CompareEmail);
            fullName = true;
        }catch (Exception e){
        }
        return fullName;
    }
    public String emailIsInserted(){
        waitForVisibility(CompareEmail);
        return CompareEmail.getText();
    }
    public boolean visibilityOfCurrentAddress(){
        boolean currentAddress = false;
        try {
            waitForVisibility(CompareCurrentAdress);
            currentAddress = true;
        }catch (Exception e){
        }
        return currentAddress;
    }
    public String currentAddressIsInserted(){
        waitForVisibility(CompareCurrentAdress);
        return CompareCurrentAdress.getText();
    }
    public boolean visibilityOfPermanentAddress(){
        boolean currentAddress = false;
        try {
            waitForVisibility(ComparePermanentAdress);
            currentAddress = true;
        }catch (Exception e){
        }
        return currentAddress;
    }
    public String permanentAddressIsInserted(){
        waitForVisibility(ComparePermanentAdress);
        return ComparePermanentAdress.getText();
    }
    public boolean visibilityOfInvalidEmailForm(){
        boolean invalidEmail = false;
        try {
            waitForVisibility(InvalidEmailForm);
            invalidEmail = true;
        }catch (Exception e){
        }
        return invalidEmail;
    }
    public boolean visibilityOfSubmitedFormField(){
        boolean form = false;
        try {
            waitForVisibility(SubmitedForm);
            form = true;
        }catch (Exception e){
        }
        return form;
    }

}

