package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        radioButtonPage = new RadioButtonPagea();
    }
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
    //    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
