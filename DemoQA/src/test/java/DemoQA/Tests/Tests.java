package DemoQA.Tests;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class Tests extends BaseTest {
//Spisak stringova za asertaciju checkboxova
String expectedResultHome = "You have selected :\n" +
        "home\n" +
        "desktop\n" +
        "notes\n" +
        "commands\n" +
        "documents\n" +
        "workspace\n" +
        "react\n" +
        "angular\n" +
        "veu\n" +
        "office\n" +
        "public\n" +
        "private\n" +
        "classified\n" +
        "general\n" +
        "downloads\n" +
        "wordFile\n" +
        "excelFile";

    String expectedResultDesktop = "You have selected :\n" +
            "desktop\n" +
            "notes\n" +
            "commands";
    String expectedResultDocuments = "You have selected :\n" +
            "documents\n" +
            "workspace\n" +
            "react\n" +
            "angular\n" +
            "veu\n" +
            "office\n" +
            "public\n" +
            "private\n" +
            "classified\n" +
            "general";
    String expectedResultWorkSpace = "You have selected :\n" +
            "workspace\n" +
            "react\n" +
            "angular\n" +
            "veu";
    String expectedResultOffice = "You have selected :\n" +
            "office\n" +
            "public\n" +
            "private\n" +
            "classified\n" +
            "general";
    String expectedResultDownloads = "You have selected :\n" +
            "downloads\n" +
            "wordFile\n" +
            "excelFile";

    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
        checkBoxPage = new CheckBoxPage();
        radioButtonPage = new RadioButtonPagea();
        webTablesPage = new WebTablesPage();
        buttonsPage = new ButtonsPage();
        linksPage = new LinksPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
        formsPage = new FormsPage();
        practiceFormPage = new PracticeFormPage();
    }
    //Metode za unosenje podataka iz excel tablice
    public void insertValidCredentials() {
        for (int i = 1; i <= excelReader.getLastRow("TextBox"); i++) {
            String fullName = excelReader.getStringData("TextBox", i, 0);
            String email = excelReader.getStringData("TextBox", i, 1);
            String currentAddress = excelReader.getStringData("TextBox", i, 2);
            String permanentAddress = excelReader.getStringData("TextBox", i, 3);

            textBoxPage.insertFullName(fullName);
            textBoxPage.insertEmail(email);
            textBoxPage.insertCurrentAddress(currentAddress);
            textBoxPage.insertPermanentAddress(permanentAddress);
        }
    }
        public void insertValidFullName() {
            for (int i = 1; i <= excelReader.getLastRow("TextBox"); i++) {
                String fullName = excelReader.getStringData("TextBox", i, 0);
                textBoxPage.insertFullName(fullName);
            }
    }
    public void insertValidEmail() {
        for (int i = 1; i <= excelReader.getLastRow("TextBox"); i++) {
            String email = excelReader.getStringData("TextBox", i, 1);
            textBoxPage.insertEmail(email);
        }
    }
    public void insertValidCurrentAddress() {
        for (int i = 1; i <= excelReader.getLastRow("TextBox"); i++) {
            String currentAddress = excelReader.getStringData("TextBox", i, 2);
            textBoxPage.insertCurrentAddress(currentAddress);
        }
    }
    public void insertValidPermanentAddress() {
        for (int i = 1; i <= excelReader.getLastRow("TextBox"); i++) {
            String permanentAddress = excelReader.getStringData("TextBox", i, 3);
            textBoxPage.insertPermanentAddress(permanentAddress);
        }
    }

        public void invalidEmailForm() {
            for (int i = 1; i <= excelReader.getLastRow("InvalidEmailForm"); i++) {
                String email = excelReader.getStringData("InvalidEmailForm", i, 0);
                textBoxPage.insertEmail(email);
                textBoxPage.clickOnSubmitButton();
                Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
                //Asertujem da se pojavljuje crveno uokvireno upozorenje i da se email nije upisao nakon klika na submit button
                Assert.assertTrue(textBoxPage.visibilityOfInvalidEmailForm());
                Assert.assertFalse(textBoxPage.visibilityOfEmail());
                Assert.assertFalse(textBoxPage.visibilityOfSubmitedFormField());

            }
        }
            public String insertCheckboxName () {
                ArrayList<String> names = new ArrayList<>();
                String expectedResult = "";
                for (int i = 1; i <= excelReader.getLastRow("CheckBox"); i++) {
                    names.add(excelReader.getStringData("CheckBox", i, 0));

                    expectedResult = " " + names;

                }
                return expectedResult.trim().replace("[", "" ).replace("]", "").replace(",", "").replace(" ", "");
            }
    public void insertValidCredentialsWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            String email = excelReader.getStringData("WebTables", i, 2);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void insertValidEditedCredentialsWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("EditedData"); i++) {
            String firstName = excelReader.getStringData("EditedData", i, 0);
            String lastName = excelReader.getStringData("EditedData", i, 1);
            String email = excelReader.getStringData("EditedData", i, 2);
            int age = excelReader.getIntegerData("EditedData", i, 3);
            int salary = excelReader.getIntegerData("EditedData", i, 4);
            String permanentAddress = excelReader.getStringData("EditedData", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void invalidEmailFormWebTables() throws InterruptedException {

        for (int j = 1; j <= excelReader.getLastRow("InvalidEmailForm"); j++) {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
            String email = excelReader.getStringData("InvalidEmailForm", j, 0);
            textBoxPage.insertEmail(email);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
        }
    }
    public void insertInvalidAgeNumber() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("InvalidAge"); i++) {
            String firstName = excelReader.getStringData("InvalidAge", i, 0);
            String lastName = excelReader.getStringData("InvalidAge", i, 1);
            String email = excelReader.getStringData("InvalidAge", i, 2);
            String age = excelReader.getStringData("InvalidAge", i, 3);
            int salary = excelReader.getIntegerData("InvalidAge", i, 4);
            String permanentAddress = excelReader.getStringData("InvalidAge", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertStringAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());

        }
    }
    public void insertInvalidSalaryNumber() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("InvalidSalaryFormat"); i++) {
            String firstName = excelReader.getStringData("InvalidSalaryFormat", i, 0);
            String lastName = excelReader.getStringData("InvalidSalaryFormat", i, 1);
            String email = excelReader.getStringData("InvalidSalaryFormat", i, 2);
            int age = excelReader.getIntegerData("InvalidSalaryFormat", i, 3);
            String salary = excelReader.getStringData("InvalidSalaryFormat", i, 4);
            String permanentAddress = excelReader.getStringData("InvalidSalaryFormat", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertStringSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);
            webTablesPage.clickOnSubmitButton();
            Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());

        }
    }
    public void leaveEmptyFirstNameFieldWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            //String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            String email = excelReader.getStringData("WebTables", i, 2);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            //webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void leaveEmptyLastNameFieldWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            //String lastName = excelReader.getStringData("WebTables", i, 1);
            String email = excelReader.getStringData("WebTables", i, 2);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            //webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void leaveEmptyEmailFieldWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            //String email = excelReader.getStringData("WebTables", i, 2);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            //webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void leaveEmptyAgeFieldWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            String email = excelReader.getStringData("WebTables", i, 2);
            //int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            //webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void leaveEmptySalaryFieldWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            String email = excelReader.getStringData("WebTables", i, 2);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            //int salary = excelReader.getIntegerData("WebTables", i, 4);
            String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            //webTablesPage.insertSalary(salary);
            webTablesPage.insertDepartment(permanentAddress);

        }
    }
    public void leaveEmptyDepartmentFieldWebTables() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("WebTables"); i++) {
            String firstName = excelReader.getStringData("WebTables", i, 0);
            String lastName = excelReader.getStringData("WebTables", i, 1);
            String email = excelReader.getStringData("WebTables", i, 2);
            int age = excelReader.getIntegerData("WebTables", i, 3);
            int salary = excelReader.getIntegerData("WebTables", i, 4);
            //String permanentAddress = excelReader.getStringData("WebTables", i, 5);

            webTablesPage.insertFirstName(firstName);
            webTablesPage.insertLastName(lastName);
            webTablesPage.insertEmail(email);
            webTablesPage.insertAge(age);
            webTablesPage.insertSalary(salary);
            //webTablesPage.insertDepartment(permanentAddress);
        }
    }
    public void insertValidCredentialsPracticeFormPage()  {
        for (int i = 1; i <= excelReader.getLastRow("PracticeFormValidData"); i++) {
            String firstName = excelReader.getStringData("PracticeFormValidData", i, 0);
            String lastName = excelReader.getStringData("PracticeFormValidData", i, 1);
            String email = excelReader.getStringData("PracticeFormValidData", i, 2);
            int mobileNumber = excelReader.getIntegerData("PracticeFormValidData", i, 3);
            String dof = excelReader.getStringData("PracticeFormValidData", i, 4);
            String currentAddress = excelReader.getStringData("PracticeFormValidData", i, 5);
            for (int j = 1; j <= excelReader.getLastRow("PracticeFormSubjects"); j++) {
                String subjets = excelReader.getStringData("PracticeFormSubjects", j, 0);
                practiceFormPage.insertSubjects(subjets);
            }
            practiceFormPage.insertFirstName(firstName);
            practiceFormPage.insertLastName(lastName);
            practiceFormPage.insertEmail(email);
            practiceFormPage.insertUserNumber(mobileNumber);
            practiceFormPage.insertDateOfBirth(dof);
            practiceFormPage.insertCurrentAddress(currentAddress);
        }
    }
//----------------DemoQA-------------------------------------------------------------------------------------------------
//Validacija da li se otvorila DemoQa stranica
    @Test(priority = 10)
    public void validateFirstPage(){

        scrollToElement(homePage.Elements);
        Assert.assertEquals(homePage.currentURL(), "https://demoqa.com/");
        Assert.assertEquals(homePage.elements(), "Elements");
        Assert.assertTrue(homePage.visibilityOfElements());
    }
    //------------Elements---------------------------------------------------------------------------------------------------
    //Validacija da li se otvorila Elements stranica
    @Test(priority = 20)
    public void validateElementsPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        Assert.assertEquals(homePage.currentURL(), "https://demoqa.com/elements");
        Assert.assertEquals(elementsPage.headerElements(), "Elements");
    }
    //--------TEXT BOX----------------------------------------------------------------------------------------------------
    //Validacija da li se otvorila Text Box stranica
    @Test(priority = 30)
        public void validateTextBoxPage(){
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        Assert.assertEquals(elementsPage.currentURL(), "https://demoqa.com/text-box");
}
//Validacija da nista nije uneto u obrazac ako se klikne direktno na submit button
    @Test(priority = 40)
    public void validateNothingIsInsertedClickingDirectlySubmitButton(){

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
        Assert.assertFalse(textBoxPage.visibilityOfSubmitedFormField());

    }
    //korisnik moze da unese validne podatke (sva polja prihvataju apsolutno sve karaktere, email polje prepoznaje validnu email formu)
    @Test(priority = 50)
    public void userCanSubmitValidDataInsertedInTextBox(){

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        insertValidCredentials();
        textBoxPage.clickOnSubmitButton();
        scrollToElement(textBoxPage.ComapareFullName);
        Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
        Assert.assertTrue(textBoxPage.visibilityOfFullName());
        Assert.assertEquals(textBoxPage.fullNameIsInserted(), "Name:Pera Peric");
    }
    //korisnik moze da unese validno ime i prezime (polje prihvata apsolutno sve karaktere)
    @Test(priority = 55)
    public void userCanSubmitFullNameInsertedInTextBox(){

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        insertValidFullName();
        textBoxPage.clickOnSubmitButton();
        scrollToElement(textBoxPage.ComapareFullName);
        Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
        Assert.assertTrue(textBoxPage.visibilityOfFullName());
        Assert.assertEquals(textBoxPage.fullNameIsInserted(), "Name:Pera Peric");
    }
    //korisnik moze da unese validni email
    @Test(priority = 60)
    public void userCanSubmitValidEmailInsertedInTextBox(){

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        insertValidEmail();
        textBoxPage.clickOnSubmitButton();
        scrollToElement(textBoxPage.CompareEmail);
        Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
        Assert.assertTrue(textBoxPage.visibilityOfEmail());
        Assert.assertEquals(textBoxPage.emailIsInserted(), "Email:peraperic@gmail.com");

    }
    //korisnik moze da unese trenutnu adresu
    @Test(priority = 70)
    public void userCanSubmitCurrentAddressInsertedInTextBox(){

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        insertValidCurrentAddress();
        textBoxPage.clickOnSubmitButton();
        scrollToElement(textBoxPage.CompareCurrentAdress);
        Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
        Assert.assertTrue(textBoxPage.visibilityOfCurrentAddress());
        Assert.assertEquals(textBoxPage.currentAddressIsInserted(), "Current Address :Visnjicka 23");
}
    //korisnik moze da unese stalnu adresu
    @Test(priority = 80)
    public void userCanSubmitPermanentAddressInsertedInTextBox(){

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        insertValidPermanentAddress();
        textBoxPage.clickOnSubmitButton();
        scrollToElement(textBoxPage.ComparePermanentAdress);
        Assert.assertEquals(textBoxPage.currentURL(), "https://demoqa.com/text-box");
        Assert.assertTrue(textBoxPage.visibilityOfPermanentAddress());
        Assert.assertEquals(textBoxPage.permanentAddressIsInserted(), "Permananet Address :Ulica lipa 44");
    }
    //Korisnik ne moze da unese navalidnu email formu
    @Test(priority = 90)
    public void validateInvalidEmailInsertedInTextBoxErrorNotification() {

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(textBoxPage.TextBox);
        elementsPage.clickOnTextBoxButton();
        invalidEmailForm();
    }
    //---------------CHECK BOX--------------------------------------------------------------------------------------------------------
    //Validacija da li se otvorila Check Box stranica
    @Test(priority = 100)
    public void validateCheckBoxPage() {

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        Assert.assertEquals(checkBoxPage.currentURL(), "https://demoqa.com/checkbox");
        Assert.assertTrue(checkBoxPage.visibilityOfHomeExpandButton());
        Assert.assertEquals(checkBoxPage.PageHeader(), "Check Box");
    }
    //Validacija da li otvara i zatvara toggle dugme na Home Folder ikoni
    @Test(priority = 110)
    public void openAnCloseToggleButtonHomeFolder() {

        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxDesktop());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxDocuments());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxDownloads());
        checkBoxPage.clickOnToggleButtonHomeClose();
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxDesktop());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxDocuments());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxDownloads());
    }
    //Validacija da li otvara i zatvara toggle dugme na Desktop ikoni
    @Test(priority = 120)
    public void openAndCloseToggleButtonDesktop() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDesktop();
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxNotes());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxCommands());
        checkBoxPage.clickOnToggleButtonDesktop();
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxNotes());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxCommands());
    }
    //Validacija da li otvara i zatvara toggle dugme na Documents ikoni
    @Test(priority = 130)
    public void openAndCloseToggleButtonDocuments() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDocuments();
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxWorkSpace());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxOffice());
        checkBoxPage.clickOnToggleButtonDocuments();
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxWorkSpace());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxOffice());
    }
    //Validacija da li otvara i zatvara toggle dugme na Downloads ikoni ikoni
    @Test(priority = 140)
    public void openAnCloseToggleButtonDownloads() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDownloads();
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxWordFile());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxOfficeFile());
        checkBoxPage.clickOnToggleButtonDownloads();
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxWordFile());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxOfficeFile());
    }
    //Validacija da li otvara i zatvara toggle dugme na Work Space ikoni
    @Test(priority = 150)
    public void openAnCloseToggleButtonWorkSpace() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDocuments();
        checkBoxPage.clickOnToggleButtonWorkSpace();
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxReact());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxAngular());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxVeu());
        checkBoxPage.clickOnToggleButtonWorkSpace();
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxReact());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxAngular());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxVeu());
    }
    //Validacija da li otvara i zatvara toggle dugme na Office ikoni
    @Test(priority = 160)
    public void openAnCloseToggleButtonOffice() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDocuments();
        checkBoxPage.clickOnToggleButtonOffice();
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxPublic());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxPrivate());
        Assert.assertTrue(checkBoxPage.visibilityOfCheckBoxClassified());
        checkBoxPage.clickOnToggleButtonOffice();
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxPublic());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxPrivate());
        Assert.assertFalse(checkBoxPage.visibilityOfCheckBoxClassified());
    }
    //Validacija da li radi checkbox dugme na Home Foler ikoni tako da su se prikazali nazivi ostalih folera
    @Test(priority = 170)
    public void checkAndUncheckHomeFolderCheckButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnCheckBoxHomeFolder();
        Assert.assertEquals(checkBoxPage.getResult(), expectedResultHome);
        checkBoxPage.clickOnCheckBoxHomeFolder();
        Assert.assertFalse(checkBoxPage.visibilityOfResult());
    }
    //Validacija da li radi checkbox dugme na Desktop ikoni tako da su se prikazali nazivi ostalih folera
    @Test(priority = 180)
    public void checkAndUncheckDesktopFolderCheckButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDesktop();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnCheckBoxDesktop();
        Assert.assertEquals(checkBoxPage.getResult(), expectedResultDesktop);
        checkBoxPage.clickOnCheckBoxDesktop();
        Assert.assertFalse(checkBoxPage.visibilityOfResult());
    }
    //Validacija da li radi checkbox dugme na Documents ikoni tako da su se prikazali nazivi ostalih folera
    @Test(priority = 190)
    public void checkAndUncheckDocumentsFolderCheckButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDesktop();
        checkBoxPage.clickOnToggleButtonDocuments();
        checkBoxPage.clickOnToggleButtonDownloads();
        checkBoxPage.clickOnToggleButtonWorkSpace();
        checkBoxPage.clickOnToggleButtonOffice();
        scrollToElement(checkBoxPage.CheckBoxDocuments);
        checkBoxPage.clickOnCheckBoxDocuments();
        Assert.assertEquals(checkBoxPage.getResult(), expectedResultDocuments);
        checkBoxPage.clickOnCheckBoxDocuments();
        Assert.assertFalse(checkBoxPage.visibilityOfResult());
    }
    //Validacija da li radi checkbox dugme na Downloads ikoni tako da su se prikazali nazivi ostalih folera
    @Test(priority = 200)
    public void checkAndUncheckDownloasFolderCheckButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDesktop();
        checkBoxPage.clickOnToggleButtonDocuments();
        checkBoxPage.clickOnToggleButtonDownloads();
        checkBoxPage.clickOnToggleButtonWorkSpace();
        checkBoxPage.clickOnToggleButtonOffice();
        scrollToElement(checkBoxPage.CheckBoxDownloads);
        checkBoxPage.clickOnCheckBoxDownloads();
        Assert.assertEquals(checkBoxPage.getResult(), expectedResultDownloads);
        checkBoxPage.clickOnCheckBoxDownloads();
        Assert.assertFalse(checkBoxPage.visibilityOfResult());
    }
    //Validacija da li radi checkbox dugme na WorkSpace ikoni tako da su se prikazali nazivi ostalih folera
    @Test(priority = 210)
    public void checkAndUncheckDocumentsFolderWorkSpaceButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDesktop();
        checkBoxPage.clickOnToggleButtonDocuments();
        checkBoxPage.clickOnToggleButtonDownloads();
        checkBoxPage.clickOnToggleButtonWorkSpace();
        checkBoxPage.clickOnToggleButtonOffice();
        scrollToElement(checkBoxPage.CheckBoxDocuments);
        checkBoxPage.clickOnCheckBoxWorkSpace();
        Assert.assertEquals(checkBoxPage.getResult(), expectedResultWorkSpace);
        checkBoxPage.clickOnCheckBoxWorkSpace();
        Assert.assertFalse(checkBoxPage.visibilityOfResult());
    }
    //Validacija da li radi checkbox dugme na Office ikoni tako da su se prikazali nazivi ostalih folera
    @Test(priority = 220)
    public void checkAndUncheckDocumentsFolderOfficeButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(checkBoxPage.CheckBox);
        elementsPage.clickOnCheckBoxButton();
        scrollToElement(checkBoxPage.CheckBoxHome);
        checkBoxPage.clickOnToggleButtonHome();
        checkBoxPage.clickOnToggleButtonDesktop();
        checkBoxPage.clickOnToggleButtonDocuments();
        checkBoxPage.clickOnToggleButtonDownloads();
        checkBoxPage.clickOnToggleButtonWorkSpace();
        checkBoxPage.clickOnToggleButtonOffice();
        scrollToElement(checkBoxPage.CheckBoxDocuments);
        checkBoxPage.clickOnCheckBoxOffice();
        Assert.assertEquals(checkBoxPage.getResult(), expectedResultOffice);
        checkBoxPage.clickOnCheckBoxOffice();
        Assert.assertFalse(checkBoxPage.visibilityOfResult());
    }
    //------------RADIO BUTTON----------------------------------------------------------------------------------------------------------
    //Validacija da li se prikazala Radio Button stranica
    @Test(priority = 230)
    public void validateRadioButtonPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.RadioButton);
        elementsPage.clickOnRadioButton();
        Assert.assertEquals(homePage.currentURL(), "https://demoqa.com/radio-button");
        Assert.assertEquals(radioButtonPage.headerRadioButton(), "Radio Button");
    }
    //Valiacija da li se ukljucilo radio button Yes tako sto se prikazala poruka Yes a nije Impressive
    @Test(priority = 240)
    public void clickOnRadioButtonYes() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.RadioButton);
        elementsPage.clickOnRadioButton();
        scrollToElement(radioButtonPage.RadioButtonYes);
        radioButtonPage.clickOnRadioButtonYes();
        Assert.assertTrue(radioButtonPage.visibilityOfMessageSelected());
        Assert.assertTrue(radioButtonPage.visibilityOfRadioButtonYes());
        Assert.assertFalse(radioButtonPage.visibilityOfMessageNotSelectedImpressive());
    }
    //Valiacija da li se ukljucilo radio button Impressive tako sto se prikazala poruka Impressive a nije Yes
    @Test(priority = 250)
    public void clickOnRadioButtonImpressive() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.RadioButton);
        elementsPage.clickOnRadioButton();
        scrollToElement(radioButtonPage.RadioButtonImpressive);
        radioButtonPage.clickOnRadioButtonImpressive();
        Assert.assertTrue(radioButtonPage.visibilityOfMessageSelected());
        Assert.assertTrue(radioButtonPage.visibilityOfRadioButtonImpressive());
        Assert.assertFalse(radioButtonPage.visibilityOfMessageNotSelectedYes());
        radioButtonPage.noRadioAllowed();
        Assert.assertEquals(radioButtonPage.noRadioAllowed(), "not-allowed");
    }
    //Valiacija da ne moze a se ukljuci button NotAlloved i da izlazi znak zabrane
    @Test(priority = 260)
    public void clickOnRadioButtonNotAllowed() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.RadioButton);
        elementsPage.clickOnRadioButton();
        scrollToElement(radioButtonPage.NoRadio);
        radioButtonPage.noRadioAllowed();
        Assert.assertEquals(radioButtonPage.noRadioAllowed(), "not-allowed");
    }
    //--------------WEB TABLES----------------------------------------------------------------------------------------------------------
    //Validacija da li se pojavila stranica Web Tables
    @Test(priority = 270)
    public void validateWebTablesPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        Assert.assertEquals(webTablesPage.currentURL(), "https://demoqa.com/webtables");
        Assert.assertEquals(webTablesPage.pageHeader(), "Web Tables");
    }
    //Validacija da li mogu da se unesu validni kredencijali
    @Test(priority = 280)
    public void userCanInsertValidCredentialsInWebTable() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        insertValidCredentialsWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.getCellValue("Pera"));
        Assert.assertTrue(webTablesPage.getCellValue("Peric"));
        Assert.assertTrue(webTablesPage.getCellValue("Noob"));
    }
    //Validacija da moze da se obrise red u tabeli
    @Test(priority = 290)
    public void deleteDataFromWebTable() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        //scrollToElement(webTablesPage.FirstName);
        insertValidCredentialsWebTables();
        webTablesPage.clickOnSubmitButton();
        webTablesPage.clickOnDeleteRecordButton();
        Assert.assertFalse(webTablesPage.getCellValue("Pera"));
        Assert.assertFalse(webTablesPage.getCellValue("Peric"));
        Assert.assertFalse(webTablesPage.getCellValue("Noob"));
    }
    //Validacija da mogu da se isprave podaci u tabeli
    @Test(priority = 300)
    public void userCanEditDataInWebTable() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        insertValidCredentialsWebTables();
        webTablesPage.clickOnSubmitButton();
        webTablesPage.clickOnEditRecordButton();
        insertValidEditedCredentialsWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.getCellValue("Zoka"));
        Assert.assertTrue(webTablesPage.getCellValue("Zokic"));
        Assert.assertTrue(webTablesPage.getCellValue("Pro"));
    }
    //Validacija da li se pojavljuje notifikacija o gresci ako se klikne direktno na dodaj poatke dume bez upisivanja p[odataka
    @Test(priority = 310)
    public void clickOnButtonirectlyWithoutEnteringData() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
    //Validacija da li moze da se unese nevalidna email forma
    @Test(priority = 320)
    public void userCannotInsertDataWithInvaliEmailForm() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        invalidEmailFormWebTables();

    }
    //Validacija da ne mogu da se unesu slova i negativni brojevi u Age polje
    @Test(priority = 330)
    public void userCannotInsertDataInvalidAgeNumber() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        insertInvalidAgeNumber();
    }
    //Validacija da ne mogu da se unesu slova i negativni brojevi u Salary polje
    @Test(priority = 340)
    public void userCannotInsertDataInvalidSalaryNumber() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        insertInvalidSalaryNumber();
    }
    //Validacija da korisnik ne moze da ostavi Ime polje prazno
    @Test(priority = 350)
    public void userCannotLeaveEmptyFirstNameFieldWebTables() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        //scrollToElement(webTablesPage.FirstName);
        leaveEmptyFirstNameFieldWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
    //Validacija da korisnik ne moze da ostavi Prezime polje prazno
    @Test(priority = 360)
    public void userCannotLeaveEmptyLastNameFieldWebTables() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        leaveEmptyLastNameFieldWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
    //Validacija da korisnik ne moze da ostavi Email polje prazno
    @Test(priority = 370)
    public void userCannotLeaveEmptyEmailFieldWebTables() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        leaveEmptyEmailFieldWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
    //Validacija da korisnik ne moze da ostavi Age polje prazno
    @Test(priority = 380)
    public void userCannotLeaveEmptyAgeFieldWebTables() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        leaveEmptyAgeFieldWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
    //Validacija da korisnik ne moze da ostavi Salary polje prazno
    @Test(priority = 390)
    public void userCannotLeaveEmptySalaryFieldWebTables() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        leaveEmptySalaryFieldWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
    //Validacija da korisnik ne moze da ostavi Department polje prazno
    @Test(priority = 400)
    public void userCannotLeaveEmptyDepartmentFieldWebTables() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        webTablesPage.clickOnAddButton();
        scrollToElement(webTablesPage.FirstName);
        leaveEmptyDepartmentFieldWebTables();
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.visibilityOfErrorNotification());
    }
   // Validacija da se kolona moze sortirati po rastucem i opadajucem redosledu u svim kolonama
    @Test(priority = 410)
    public void validateAscendingDscendingColumnSort() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.WebTables);
        elementsPage.clickOnWebTablesButton();
        scrollToElement(webTablesPage.SortAscDescFNColumn);
        webTablesPage.sortAscDescFNColumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescFNColumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
        webTablesPage.sortAscDescLNColumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescLNColumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
        webTablesPage.sortAscDescAgeColumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescAgeColumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
        webTablesPage.sortAscDescEmailColumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescEmailColumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
        webTablesPage.sortAscDescSalaryColumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescSalaryColumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
        webTablesPage.sortAscDescDepartmentolumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescDepartmentolumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
        webTablesPage.sortAscDescActionColumn();
        Assert.assertTrue(webTablesPage.visibilityOfAscSort());
        webTablesPage.sortAscDescActionColumn();
        Assert.assertTrue(webTablesPage.visibilityOfDescSort());
    }
    //----------------BUTTONS--------------------------------------------------------------------------------------------------
    //Validacija da li se otvorila Buttons stranica
    @Test(priority = 420)
    public void validateButtonsPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Buttons);
        elementsPage.clickOnButtonsButton();
        Assert.assertEquals(buttonsPage.currentURL(), "https://demoqa.com/buttons");
        Assert.assertEquals(buttonsPage.pageHeader(), "Buttons");
    }
    //Validacija funkcionalnosti double click dugmeta
    @Test(priority = 430)
    public void clickOnDoubleClickButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Buttons);
        elementsPage.clickOnButtonsButton();
        scrollToElement(buttonsPage.DoubleClickButton);
        buttonsPage.clickOnDoubleClickButton();
        Assert.assertTrue(buttonsPage.visibilityOfDoubleClickMessage());
        Assert.assertEquals(buttonsPage.doubleClickMessage(), "You have done a double click");
    }
    //Validacija funkcionalnosi desnog klik dugmeta
    @Test(priority = 440)
    public void rightClickOnRightClickButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Buttons);
        elementsPage.clickOnButtonsButton();
        scrollToElement(buttonsPage.DoubleClickButton);
        buttonsPage.rightClickOnRightClickButton();
        Assert.assertTrue(buttonsPage.visibilityOfRightClickMessage());
        Assert.assertEquals(buttonsPage.rightClickMessage(), "You have done a right click");
    }
    //Validacija jednog klika dugmeta
    @Test(priority = 450)
    public void clickOnClickMeButton() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Buttons);
        elementsPage.clickOnButtonsButton();
        scrollToElement(buttonsPage.ClickMeButton);
        buttonsPage.clickOnClickMeButton();
        Assert.assertTrue(buttonsPage.visibilityOfDynamicClickMessage());
        Assert.assertEquals(buttonsPage.dynamicClickMessage(), "You have done a dynamic click");
    }
    //-------------------LINKS------------------------------------------------------------------------------------------
//Validacija da li se otvorila Links stranica
    @Test(priority = 460)
    public void validateLinksPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        Assert.assertEquals(linksPage.currentURL(), "https://demoqa.com/links");
        Assert.assertEquals(linksPage.pageHeader(), "Links");
    }
    //Validacija da li radi link Home
    @Test(priority = 470)
    public void clickOnLinkHome() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        linksPage.clickOnLinkHome();
        scrollToElement(linksPage.Home);
        linksPage.homeLinkIsOpened();
        Assert.assertEquals(linksPage.currentURL(), "https://demoqa.com/");
        Assert.assertEquals(homePage.elements(), "Elements");
        Assert.assertTrue(homePage.visibilityOfElements());
    }
    //Validacija da li radi dynamic link
    @Test(priority = 480)
    public void clickOnDynamicLink() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        linksPage.clickOnLinkHome();
        scrollToElement(linksPage.Dynamic);
        linksPage.dynamicLinkIsOpened();
        Assert.assertEquals(linksPage.currentURL(), "https://demoqa.com/");
        Assert.assertEquals(homePage.elements(), "Elements");
        Assert.assertTrue(homePage.visibilityOfElements());
    }
    //Validacija API poruke
    @Test(priority = 490)
    public void clickOnApiLinkCreated() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.Created);
        linksPage.clickOnApiLinkCreated();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 201 and status text Created");
    }
    //Validacija API poruke//Validacija API poruke
    @Test(priority = 500)
    public void clickOnApiLinkNoContent() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.NoContent);
        linksPage.clickOnApiLinkNoContent();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 204 and status text No Content");
    }
    //Validacija API poruke
    @Test(priority = 510)
    public void clickOnApiLinkMoved() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.Moved);
        linksPage.clickOnApiLinkMoved();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 301 and status text Moved Permanently");
    }
    //Validacija API poruke
    @Test(priority = 520)
    public void clickOnApiLinkBadRequest() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.BadRequest);
        linksPage.clickOnApiLinkBadRequest();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 400 and status text Bad Request");
    }
    //Validacija API poruke
    @Test(priority = 530)
    public void clickOnApiLinkUnauthorized() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.Unauthorized);
        linksPage.clickOnApiLinkUnauthorized();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 401 and status text Unauthorized");
    }
    //Validacija API poruke
    @Test(priority = 540)
    public void clickOnApiLinkForbidden() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.Forbidden);
        linksPage.clickOnApiLinkForbidden();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 403 and status text Forbidden");
    }
    //Validacija API poruke
    @Test(priority = 550)
    public void clickOnApiLinkNotFound() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.Links);
        elementsPage.clickOnLinksButton();
        scrollToElement(linksPage.NotFound);
        linksPage.clickOnApiLinkNotFound();
        Assert.assertEquals(linksPage.messageResponse(), "Link has responded with staus 404 and status text Not Found");
    }
    //---------------------BROKEN LINKS IMAGES----------------------------------------------------------------------------------------------
    //Validacija da li se otvorila Broken Links Images stranica
    @Test(priority = 560)
    public void validateBrokenLinksImagesPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.BrokenLinksImages);
        elementsPage.clickOnBrokenLinksImagesButton();
        Assert.assertEquals(brokenLinksImagesPage.currentURL(), "https://demoqa.com/broken");
        Assert.assertEquals(brokenLinksImagesPage.pageHeader(), "Broken Links - Images");
    }
    //Validacija da li se prikazala validna slika
    @Test(priority = 570)
    public void validateBrokenLinksDisplayedImage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.BrokenLinksImages);
        elementsPage.clickOnBrokenLinksImagesButton();
        Assert.assertTrue(brokenLinksImagesPage.validateDisplayedImage());
    }
    //Validacija da li se prikazala slika sa losim linkom
    @Test(priority = 580)
    public void validateBrokenLinksBrokenImage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.BrokenLinksImages);
        elementsPage.clickOnBrokenLinksImagesButton();
        Assert.assertTrue(brokenLinksImagesPage.validateBrokenImage());
    }
    //Validacija da li radi valid link
    @Test(priority = 590)
    public void validateBrokenLinksValidLink() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.BrokenLinksImages);
        elementsPage.clickOnBrokenLinksImagesButton();
        brokenLinksImagesPage.validateValidLink();
        Assert.assertEquals(linksPage.currentURL(), "https://demoqa.com/");
        Assert.assertEquals(homePage.elements(), "Elements");
        Assert.assertTrue(homePage.visibilityOfElements());
    }
    //Validacija da li se pojavilo upozorenje za neispravnu stranicu
    @Test(priority = 600)
    public void validateBrokenLinksInvalidLink() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.BrokenLinksImages);
        elementsPage.clickOnBrokenLinksImagesButton();
        brokenLinksImagesPage.validateBrokenLink();
        Assert.assertEquals(linksPage.currentURL(), "http://the-internet.herokuapp.com/status_codes/500");
        Assert.assertEquals(brokenLinksImagesPage.errorPageHeader(), "Status Codes\n" +
                "This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here");
    }
    //-------------------UPLOAD AND DOWNLOAD------------------------------------------------------------------------------------------------
    //Validacija da li se prikazala Upload And Download Stranica
    @Test(priority = 610)
    public void validateUploadAndDownloadPage() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.UploadDownload);
        elementsPage.clickOnUploadAndDownloadButton();
        Assert.assertEquals(uploadAndDownloadPage.currentURL(), "https://demoqa.com/upload-download");
        Assert.assertEquals(uploadAndDownloadPage.pageHeader(), "Upload and Download");
    }
//Validacija da li se otvara upload prozor
    @Test(priority = 620)
    public void validateDownloadFile() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.UploadDownload);
        elementsPage.clickOnUploadAndDownloadButton();
        uploadAndDownloadPage.clickOnDownloadButton();
        //Assert.assertTrue(FileUtils.getFile("sdfs", "fsfs"));
    }
    //Validacija da li se uploudovao fajl
    @Test(priority = 630)
    public void validateUploadFile() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.UploadDownload);
        elementsPage.clickOnUploadAndDownloadButton();
        uploadAndDownloadPage.clickOnUploadButton();
    }
    //Validacija da li se menja dynamic ID
    @Test(priority = 640)
    public void validateynamicChangeId() {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.DynamicProperties);
        elementsPage.clickOnDynamicPropertiesButton();
        Assert.assertFalse(dynamicPropertiesPage.validateRanomIdChange());

    }
    //Validacija da li se je klikabilno dugme nakon 5 sekundi
    @Test(priority = 650)
    public void validateEnabledButtonAfter5Sec() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.DynamicProperties);
        elementsPage.clickOnDynamicPropertiesButton();
        Assert.assertTrue(dynamicPropertiesPage.enabledIn5SecButton());
        Thread.sleep(5000);
        Assert.assertFalse(dynamicPropertiesPage.enabledIn5SecButton());
    }
    //Validacija da li je dugme promenilo boju nakon 5 sekundi
    @Test(priority = 660)
    public void validateColorChangeButton() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.DynamicProperties);
        elementsPage.clickOnDynamicPropertiesButton();
        Assert.assertTrue(dynamicPropertiesPage.validateColorChangeButton());
        Thread.sleep(5000);
        Assert.assertTrue(dynamicPropertiesPage.validateColorChangeToRedButton());
    }
   // Validacija da li je dugme vidljivo nakon 5 sekundi
    @Test(priority = 670)
    public void validateVisibleAfter5sec() throws InterruptedException {
        scrollToElement(homePage.Elements);
        homePage.clickOnCard("Elements");
        scrollToElement(elementsPage.DynamicProperties);
        elementsPage.clickOnDynamicPropertiesButton();
        Thread.sleep(5000);
        Assert.assertTrue(dynamicPropertiesPage.validateVisibleAfter5sec());
    }
    //------------------Forms--------------------------------------------------------------------------------------------------
    //Validacija da li se pojavila Forms stranica
    @Test(priority = 680)
    public void validateFormsPage() {
        scrollToElement(homePage.Forms);
        homePage.clickOnCard("Forms");
        Assert.assertEquals(homePage.currentURL(), "https://demoqa.com/forms");
        Assert.assertEquals(elementsPage.headerElements(), "Forms");
    }
    //-------------PRACTICE FORMS-------------------------------------------------------------------------------
    //Validacija da li se pojavila Practice forms Stranica
    @Test(priority = 690)
    public void validatePracticeFormsPage() {
        scrollToElement(homePage.Forms);
        homePage.clickOnCard("Forms");
        scrollToElement(formsPage.PracticeForm);
        formsPage.clickOnFormsPageButton();
        Assert.assertEquals(homePage.currentURL(), "https://demoqa.com/automation-practice-form");
        Assert.assertEquals(elementsPage.headerElements(), "Practice Form");
    }
    //Korisnik moze da posalje validne podatke
    @Test(priority = 700)
    public void userCanInsertPracticeFormsPageValidData() throws InterruptedException {

        scrollToElement(homePage.Forms);
        homePage.clickOnCard("Forms");
        scrollToElement(formsPage.PracticeForm);
        formsPage.clickOnFormsPageButton();
        scrollToElement(practiceFormPage.FirstName);
        insertValidCredentialsPracticeFormPage();
        scrollToElement(practiceFormPage.RadioButtonMale);
        practiceFormPage.clickOnRadioButtonMale();
        practiceFormPage.clickOnCheckBoxHobbies();
        Thread.sleep(3000);
        scrollToElement(practiceFormPage.StateName);
        practiceFormPage.selectStateName("Haryana");
        scrollToElement(practiceFormPage.CityName);
        practiceFormPage.selectCityName("Panipat");
        scrollToElement(practiceFormPage.SubmitButton);
        practiceFormPage.clickOnSubmitButton();
        Assert.assertEquals(practiceFormPage.submitFormPageHeader(),"Thanks for submitting the form");
        Assert.assertTrue(practiceFormPage.visibilityOfCloseButton());
        practiceFormPage.closeFormFrame();
        Assert.assertEquals(elementsPage.headerElements(), "Practice Form");
        Assert.assertTrue(practiceFormPage.visibilityOfSubmitButton());
    }
//    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}



