package DemoQA.Tests.Forms;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormsTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        formsPage = new FormsPage();
        practiceFormPage = new PracticeFormPage();
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
        Thread.sleep(500);
        scrollToPageBottom();
        insertValidCredentialsPracticeFormPage();
        scrollToElement(practiceFormPage.RadioButtonMale);
        practiceFormPage.clickOnRadioButtonMale();
        practiceFormPage.clickOnCheckBoxHobbies();
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
