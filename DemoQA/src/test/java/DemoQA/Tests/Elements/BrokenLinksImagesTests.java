package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        linksPage = new LinksPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
    }
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
       @AfterMethod
        public void tearDown() {
           driver.manage().deleteAllCookies();
           driver.quit();
       }
}
