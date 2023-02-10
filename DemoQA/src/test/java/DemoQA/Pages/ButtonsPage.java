package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static DemoQA.Base.BaseTest.driver;

public class ButtonsPage extends BaseTest {

        public  ButtonsPage(){
        PageFactory.initElements(driver, this);
    }
        @FindBy(className = "main-header")
        public WebElement PageHeader;
        @FindBy(id="doubleClickBtn")
        public WebElement DoubleClickButton;
        @FindBy(id="doubleClickMessage")
        public WebElement DoubleClickMessage;
        @FindBy(id="rightClickBtn")
        public WebElement RightClickButton;
        @FindBy(id="rightClickMessage")
        public WebElement RightClickMessage;
        @FindBy(xpath = "//*[text()='Click Me']")
        public WebElement ClickMeButton;
        @FindBy(id="dynamicClickMessage")
        public WebElement DynamicClickMessage;

  //--------------------------------------------------
  public String currentURL(){

      String URL = driver.getCurrentUrl();
      return URL;
  }
    public String pageHeader(){

            waitForVisibility(PageHeader);
            return PageHeader.getText();

    }
    public void clickOnDoubleClickButton(){
      waitForClickability(DoubleClickButton);
        action.doubleClick(DoubleClickButton).perform();
    }
    public boolean visibilityOfDoubleClickMessage(){

        boolean message = false;
        try {
            waitForVisibility(DoubleClickMessage);
            message = true;
        }catch (Exception e){
        }
        return message;
    }
    public void rightClickOnRightClickButton(){
        waitForClickability(RightClickButton);
        action.contextClick(RightClickButton).perform();
    }
  public boolean visibilityOfRightClickMessage(){

      boolean message = false;
      try {
          waitForVisibility(RightClickMessage);
          message = true;
      }catch (Exception e){
      }
      return message;
  }
    public void clickOnClickMeButton(){
        waitForClickability(ClickMeButton);
        ClickMeButton.click();
    }
    public boolean visibilityOfDynamicClickMessage(){

        boolean message = false;
        try {
            waitForVisibility(DynamicClickMessage);
            message = true;
        }catch (Exception e){
        }
        return message;
    }
    public String dynamicClickMessage(){

      waitForVisibility(DynamicClickMessage);
     return DynamicClickMessage.getText();
    }
    public String rightClickMessage(){

        waitForVisibility(RightClickMessage);
        return RightClickMessage.getText();
    }
    public String doubleClickMessage(){

        waitForVisibility(DoubleClickMessage);
        return DoubleClickMessage.getText();
    }
}
