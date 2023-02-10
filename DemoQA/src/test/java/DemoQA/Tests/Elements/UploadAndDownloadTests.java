package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAndDownloadTests extends BaseTest {
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
    //    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
