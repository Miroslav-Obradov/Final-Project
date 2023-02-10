package DemoQA.Tests.Elements;

import DemoQA.Base.BaseTest;
import DemoQA.Pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
    }
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
//    @AfterMethod
//    public void tearDown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }
}
