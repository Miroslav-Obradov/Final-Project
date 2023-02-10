package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TextBoxTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();
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
    //    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
