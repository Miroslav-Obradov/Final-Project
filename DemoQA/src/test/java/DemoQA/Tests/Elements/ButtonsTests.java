package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends BaseTest {
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
//    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
