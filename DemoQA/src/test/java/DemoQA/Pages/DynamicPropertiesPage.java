package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends BaseTest {

    public DynamicPropertiesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="Zv2M4")
    public WebElement RandomId;
    @FindBy(css = ".mt-4.btn.btn-primary")
    public WebElement ColorChange;
    @FindBy(css = ".mt-4.text-danger.btn.btn-primary")
    public WebElement ColorRed;
    @FindBy(id="visibleAfter")
    public WebElement VisibleAfter;



    //----------------------------------------------
    public boolean validateRanomIdChange(){
        boolean ranomId = false;
        try {
            waitForVisibility(RandomId);
            ranomId = true;
        }catch (Exception e){
        }
        return ranomId;
    }
    public boolean enabledIn5SecButton(){

        return driver.getPageSource().contains("disabled");
    }
    public boolean validateColorChangeButton(){

        boolean colorChange = false;
        try {
            waitForVisibility(ColorChange);
            colorChange = true;
        }catch (Exception e){
        }
        return colorChange;
    }
    public boolean validateColorChangeToRedButton(){

        boolean colorChange = false;
        try {
            waitForVisibility(ColorRed);
            colorChange = true;
        }catch (Exception e){
        }
        return colorChange;
    }
    public boolean validateVisibleAfter5sec(){

        boolean visibleAfter = false;
        try {
            waitForVisibility(VisibleAfter);
            visibleAfter = true;
        }catch (Exception e){
        }
        return visibleAfter;
    }
}
