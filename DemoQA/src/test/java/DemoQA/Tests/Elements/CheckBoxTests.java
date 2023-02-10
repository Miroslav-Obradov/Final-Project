package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CheckBoxTests extends BaseTest {

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
    public String insertCheckboxName () {
        ArrayList<String> names = new ArrayList<>();
        String expectedResult = "";
        for (int i = 1; i <= excelReader.getLastRow("CheckBox"); i++) {
            names.add(excelReader.getStringData("CheckBox", i, 0));

            expectedResult = " " + names;

        }
        return expectedResult.trim().replace("[", "" ).replace("]", "").replace(",", "").replace(" ", "");
    }

    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        checkBoxPage = new CheckBoxPage();
    }
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
//    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
