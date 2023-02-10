package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
        webTablesPage = new WebTablesPage();
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
        //scrollToElement(webTablesPage.FirstName);
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
        //scrollToElement(webTablesPage.FirstName);
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
        Thread.sleep(1000);
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
        //scrollToElement(webTablesPage.FirstName);
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
        //scrollToElement(webTablesPage.FirstName);
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
        //scrollToElement(webTablesPage.FirstName);
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
        //scrollToElement(webTablesPage.FirstName);
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
        //scrollToElement(webTablesPage.FirstName);
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
        //scrollToElement(webTablesPage.FirstName);
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
    //    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
