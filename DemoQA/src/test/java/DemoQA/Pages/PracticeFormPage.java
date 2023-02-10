package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class PracticeFormPage extends BaseTest {

    public PracticeFormPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="firstName")
    public WebElement FirstName;
    @FindBy(id="lastName")
    public WebElement LastName;
    @FindBy(id="userEmail")
    public WebElement UserEmail;
    @FindBy(xpath = "//*[text()='Male']")
    public WebElement RadioButtonMale;
    @FindBy(id="userNumber")
    public  WebElement UserNumber;
    @FindBy(id="dateOfBirthInput")
    public WebElement DateOfBirth;
    @FindBy(id="subjectsInput")
    public WebElement Subjects;
    @FindBy(xpath = "//*[text()='Sports']")
    public WebElement HobbiesCheckbox;
    @FindBy(id="currentAddress")
    public WebElement CurrentAddress;
    @FindBy(id="react-select-3-input")
    public WebElement StateName;
    @FindBy(id="react-select-4-input")
    public WebElement CityName;
    @FindBy(id="submit")
    public WebElement SubmitButton;
    @FindBy(id="example-modal-sizes-title-lg")
    public WebElement PageHeader;
    @FindBy(xpath = "//*[text()='Close']")
    public WebElement CloseButton;

    //------------------------------------------------
public void insertFirstName(String firstName){
    waitForVisibility(FirstName);
    FirstName.clear();
    FirstName.click();
    FirstName.sendKeys(firstName);
}
    public void insertLastName(String lastName){
        waitForVisibility(LastName);
        LastName.clear();
        LastName.click();
        LastName.sendKeys(lastName);
    }
    public void insertEmail(String email){
        waitForVisibility(UserEmail);
        UserEmail.clear();
        UserEmail.click();
        UserEmail.sendKeys(email);
    }
    public void insertUserNumber(Integer number) {

        waitForVisibility(UserNumber);
        UserNumber.clear();
        UserNumber.click();
        UserNumber.sendKeys(number.toString());
    }
    public void insertDateOfBirth(String dof){
        waitForVisibility(DateOfBirth);
        Actions action1= new Actions(driver);
        action1= action.moveToElement(DateOfBirth).doubleClick();
        action1.click().build().perform();
        DateOfBirth.sendKeys(dof);
        DateOfBirth.sendKeys(Keys.RETURN);
    }
    public void insertSubjects(String subjects){
        waitForVisibility(Subjects);
        Subjects.click();
        Subjects.sendKeys(subjects);
        Subjects.sendKeys(Keys.RETURN);
    }
    public void insertCurrentAddress(String currentAddress){
        waitForVisibility(CurrentAddress);
        CurrentAddress.click();
        CurrentAddress.sendKeys(currentAddress);
        CurrentAddress.sendKeys(Keys.RETURN);
    }
    public void clickOnCheckBoxHobbies(){
        waitForClickability(HobbiesCheckbox);
        HobbiesCheckbox.click();
}
    public void clickOnRadioButtonMale(){
        waitForClickability(RadioButtonMale);
        RadioButtonMale.click();
    }
    public void selectStateName(String stateName) {
        waitForVisibility(StateName);
        StateName.clear();
        StateName.sendKeys(stateName);
        StateName.sendKeys(Keys.RETURN);
    }
    public void selectCityName(String stateName) {
        waitForVisibility(CityName);
        CityName.clear();
        CityName.sendKeys(stateName);
        CityName.sendKeys(Keys.RETURN);
    }

    public void clickOnSubmitButton() {

        WebElement ele = driver.findElement(By.xpath("//*[text()='Submit']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }
    public void closeFormFrame(){

        WebElement ele = driver.findElement(By.xpath("//*[text()='Close']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", ele);
    }
    public String submitFormPageHeader(){

    waitForVisibility(PageHeader);
    return PageHeader.getText();
    }
    public boolean visibilityOfCloseButton(){

        boolean button = false;
        try {
            waitForVisibility(CloseButton);
            button = true;
        }catch (Exception e){
        }
        return button;
    }
    public boolean visibilityOfSubmitButton(){

        boolean button = false;
        try {
            waitForVisibility(SubmitButton);
            button = true;
        }catch (Exception e){
        }
        return button;
    }
}


