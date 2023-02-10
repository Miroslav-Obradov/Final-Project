package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        linksPage = new LinksPage();
    }

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
    //    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
