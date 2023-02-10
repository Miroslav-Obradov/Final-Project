package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(className="main-header")
    public WebElement PageHeader;
    @FindBy(id="addNewRecordButton")
    public WebElement AddButton;
    @FindBy(id="firstName")
    public WebElement FirstName;
    @FindBy(id="lastName")
    public WebElement LastName;
    @FindBy(id="userEmail")
    public WebElement Email;
    @FindBy(id="age")
    public WebElement Age;
    @FindBy(id="salary")
    public WebElement Salary;
    @FindBy(id="department")
    public WebElement Department;
    @FindBy(id="submit")
    public WebElement SubmitButton;
    @FindBy(id="delete-record-4")
    public WebElement DeleteRecord;
    @FindBy(id="edit-record-4")
    public WebElement EditRecord;
    @FindBy(className = "was-validated")
    public WebElement ErrorNotification;
    @FindBy(xpath = "//*[text()='First Name']")
    public WebElement SortAscDescFNColumn;
    @FindBy(xpath = "//*[text()='Last Name']")
    public WebElement SortAscDescLNColumn;
    @FindBy(css=".rt-th.rt-resizable-header.-sort-asc.-cursor-pointer")
    public WebElement SortAscending;
    @FindBy(css=".rt-th.rt-resizable-header.-sort-desc.-cursor-pointer")
    public WebElement SortDescending;
    @FindBy(xpath = "//*[text()='Email']")
    public WebElement SortAscDescEmailColumn;
    @FindBy(xpath = "//*[text()='Age']")
    public WebElement SortAscDescAgeColumn;
    @FindBy(xpath = "//*[text()='Salary']")
    public WebElement SortAscDescSalaryColumn;
    @FindBy(xpath = "//*[text()='Department']")
    public WebElement SortAscDescDepartmentColumn;
    @FindBy(xpath = "//*[text()='Action']")
    public WebElement SortAscDescActionColumn;


    public List<WebElement> getFields(){
        return driver.findElements(By.className("rt-td"));
    }
    public List<WebElement> getData(){
        return driver.findElements(By.className("rt-td"));}



    //-------------------------------------------------


    public String pageHeader(){
        waitForVisibility(PageHeader);
        return PageHeader.getText();
    }
    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public void clickOnAddButton(){
        waitForClickability(AddButton);
        AddButton.click();
    }
    public void insertFirstName(String userName) throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(FirstName);
        FirstName.clear();
        FirstName.click();
        FirstName.sendKeys(userName);
    }
    public void insertLastName(String lastName) {

        waitForVisibility(LastName);
        LastName.clear();
        LastName.click();
        LastName.sendKeys(lastName);
    }
    public void insertEmail(String email) {

        waitForVisibility(Email);
        Email.clear();
        Email.click();
        Email.sendKeys(email);
    }
    public void insertAge(Integer age) {

        waitForVisibility(Age);
        Age.clear();
        Age.click();
        Age.sendKeys(age.toString());
    }
    public void insertSalary(Integer salary) {

        waitForVisibility(Salary);
        Salary.clear();
        Salary.click();
        Salary.sendKeys(salary.toString());
    }
    public void insertDepartment(String department) {

        waitForVisibility(Department);
        Department.clear();
        Department.click();
        Department.sendKeys(department);
    }
    public void clickOnSubmitButton(){
        waitForClickability(SubmitButton);
        SubmitButton.click();
    }
    public boolean getCellValue(String fieldName) {
        boolean cellValue = false;
        for (int i = 0; i < getFields().size(); i++) {
            if (getFields().get(i).getText().equals(fieldName)) {
                cellValue = true;
                break;
            }
        }
        return cellValue;
    }
    public void clickOnDeleteRecordButton() {
        waitForClickability(DeleteRecord);
        DeleteRecord.click();
                }
    public void clickOnEditRecordButton() {
        waitForClickability(EditRecord);
        EditRecord.click();
    }
    public boolean visibilityOfErrorNotification(){
        boolean errorNotification = false;
        try {
            waitForVisibility(ErrorNotification);
            errorNotification = true;
        }catch (Exception e){
        }
        return errorNotification;
    }
    public void insertStringAge(String age) {

        waitForVisibility(Age);
        Age.clear();
        Age.click();
        Age.sendKeys(age);
    }
    public void insertStringSalary(String salary){
        waitForVisibility(Salary);
        Salary.clear();
        Salary.click();
        Salary.sendKeys(salary);

    }
    public void sortAscDescFNColumn() {
        waitForVisibility(SortAscDescFNColumn);
        SortAscDescFNColumn.click();
    }
    public void sortAscDescLNColumn() {
        waitForVisibility(SortAscDescLNColumn);
        SortAscDescLNColumn.click();
    }
    public void sortAscDescEmailColumn() {
        waitForVisibility(SortAscDescEmailColumn);
        SortAscDescEmailColumn.click();
    }
    public void sortAscDescAgeColumn() {
        waitForVisibility(SortAscDescAgeColumn);
        SortAscDescAgeColumn.click();
    }
    public void sortAscDescDepartmentolumn() {
        waitForVisibility(SortAscDescDepartmentColumn);
        SortAscDescDepartmentColumn.click();
    }
    public void sortAscDescSalaryColumn() {
        waitForVisibility(SortAscDescSalaryColumn);
        SortAscDescSalaryColumn.click();
    }
    public void sortAscDescActionColumn() {
        waitForVisibility(SortAscDescActionColumn);
        SortAscDescActionColumn.click();
    }
    public boolean visibilityOfAscSort(){
        boolean notification = false;
        try {
            waitForVisibility(SortAscending);
            notification = true;
        }catch (Exception e){
        }
        return notification;
    }
    public boolean visibilityOfDescSort(){
        boolean notification = false;
        try {
            waitForVisibility(SortDescending);
            notification = true;
        }catch (Exception e){
        }
        return notification;
    }
}



