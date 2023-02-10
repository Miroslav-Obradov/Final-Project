package DemoQA.Base;

import DemoQA.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static Actions action;
    public static Actions builder;
    public static WebDriverWait wdwait;
    public static ExcelReader excelReader;
    public String homeURL;
    public HomePage homePage;
    public ElementsPage elementsPage;
    public TextBoxPage textBoxPage;
    public CheckBoxPage checkBoxPage;
    public RadioButtonPagea radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public FormsPage formsPage;
    public PracticeFormPage practiceFormPage;


    @BeforeClass public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(3));
        excelReader = new ExcelReader("src/test/java/DemoQA/TestData.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
        action = new Actions(driver);
        builder = new Actions(driver);
    }
    public void waitForVisibility(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollToPageBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public boolean isDisplayed(WebElement element) {
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
