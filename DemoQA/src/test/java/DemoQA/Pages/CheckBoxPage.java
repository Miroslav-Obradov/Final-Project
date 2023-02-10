package DemoQA.Pages;

import DemoQA.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {
    public CheckBoxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".rct-icon.rct-icon-expand-close")
    public WebElement ToggleButtonHome;
    @FindBy(css = ".rct-icon.rct-icon-expand-open")
    public  WebElement ToggleButtonHomeClose;
    @FindBy(xpath = "//*[@id='item-1']//*[text()='Check Box']")
    public WebElement CheckBox;
    @FindBy(className = "main-header")
    public WebElement PageHeader;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Home']")
    public WebElement CheckBoxHome;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Desktop']")
    public WebElement CheckBoxDesktop;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Documents']")
    public WebElement CheckBoxDocuments;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Downloads']")
    public WebElement CheckBoxDownloads;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[1]/span/button")
    public WebElement ToggleButtonDesktop;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/span/button")
    public WebElement ToggleButtonDocuments;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[3]/span/button")
    public WebElement ToggleButtonDownloads;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[1]/span/button")
    public WebElement ToggleButtonWorkSpace;
    @FindBy(xpath = "//*[@id='tree-node']/ol/li/ol/li[2]/ol/li[2]/span/button")
    public WebElement ToggleButtonOffice;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Notes']")
    public WebElement CheckBoxNotes;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Commands']")
    public WebElement CheckBoxCommands;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='WorkSpace']")
    public WebElement CheckBoxWorkSpace;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Office']")
    public WebElement CheckBoxOffice;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Word File.doc']")
    public WebElement CheckBoxWordFile;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='Excel File.doc']")
    public WebElement CheckBoxExcelFile;
    @FindBy(xpath = "//*[@id='tree-node']//*[text()='React']")
    public WebElement CheckBoxReact;

    @FindBy(xpath = "//*[text()='Angular']")
    public WebElement CheckBoxAngular;

    @FindBy(xpath = "//*[text()='Veu']")
    public WebElement CheckBoxVeu;

    @FindBy(xpath = "//*[text()='Public']")
    public WebElement CheckBoxPublic;

    @FindBy(xpath = "//*[text()='Private']")
    public WebElement CheckBoxPrivate;

    @FindBy(xpath = "//*[text()='Classified']")
    public WebElement CheckBoxClassified;

    @FindBy(xpath = "//*[text()='General']")
    public WebElement CheckBoxGeneral;
    @FindBy(id="result")
    public WebElement Result;




    //---------------------------------------------------

    public String currentURL(){

        String URL = driver.getCurrentUrl();
        return URL;
    }
    public void clickOnCheckBoxButton(){

        waitForClickability(CheckBox);
        CheckBox.click();
    }
    public boolean visibilityOfHomeExpandButton(){
        boolean expandButton = false;
        try {
            waitForVisibility(CheckBoxHome);
            expandButton = true;
        }catch (Exception e){
        }
        return expandButton;
    }
    public String PageHeader(){
     waitForVisibility(PageHeader);
        return PageHeader.getText();

    }
    public void clickOnToggleButtonHome(){

        waitForClickability(ToggleButtonHome);
        ToggleButtonHome.click();

    }
    public boolean visibilityOfCheckBoxDesktop(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxDesktop);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxDocuments(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxDocuments);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxDownloads(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxDownloads);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public void clickOnToggleButtonDesktop() {

        waitForClickability(ToggleButtonDesktop);
        ToggleButtonDesktop.click();
    }
    public void clickOnToggleButtonDocuments() {

        waitForClickability(ToggleButtonDocuments);
        ToggleButtonDocuments.click();
    }
    public void clickOnToggleButtonDownloads() {

        waitForClickability(ToggleButtonDownloads);
        ToggleButtonDownloads.click();
    }
    public void clickOnToggleButtonWorkSpace() {

        waitForClickability(ToggleButtonWorkSpace);
        ToggleButtonWorkSpace.click();
    }
    public void clickOnToggleButtonOffice() {

        waitForClickability(ToggleButtonOffice);
        ToggleButtonOffice.click();
    }
    public void clickOnToggleButtonNotes() {

        waitForClickability(CheckBoxNotes);
        CheckBoxNotes.click();
    }
    public void clickOnToggleButtonCommands() {

        waitForClickability(CheckBoxCommands);
        CheckBoxCommands.click();
    }
    public boolean visibilityOfCheckBoxNotes(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxNotes);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxCommands(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxCommands);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxWorkSpace(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxWorkSpace);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxOffice(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxOffice);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxOfficeFile(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxExcelFile);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxWordFile(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxWordFile);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxReact(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxReact);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxAngular(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxAngular);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxVeu(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxVeu);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxPublic(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxPublic);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxPrivate(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxPrivate);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxClassified(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxClassified);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public boolean visibilityOfCheckBoxGeneral(){
        boolean checboxDesktop = false;
        try {
            waitForVisibility(CheckBoxGeneral);
            checboxDesktop = true;
        }catch (Exception e){
        }
        return checboxDesktop;
    }
    public void clickOnCheckBoxHomeFolder() {

        waitForClickability(CheckBoxHome);
        CheckBoxHome.click();
    }
    public void clickOnCheckBoxDesktop() {

        waitForClickability(CheckBoxDesktop);
        CheckBoxDesktop.click();
    }
    public String getResult(){
        waitForVisibility(Result);
        return Result.getText();
    }
    public void clickOnCheckBoxDocuments(){
        waitForClickability(CheckBoxDocuments);
        CheckBoxDocuments.click();
    }
    public void clickOnCheckBoxDownloads(){
        waitForClickability(CheckBoxDownloads);
        CheckBoxDownloads.click();
    }
    public boolean visibilityOfResult(){

        boolean result = false;
        try {
            waitForVisibility(Result);
            result = true;
        }catch (Exception e){
        }
        return result;
    }
    public void clickOnToggleButtonHomeClose(){
        waitForClickability(ToggleButtonHomeClose);
        ToggleButtonHomeClose.click();
    }
    public void clickOnCheckBoxWorkSpace(){
        waitForClickability(CheckBoxWorkSpace);
        CheckBoxWorkSpace.click();
    }
    public void clickOnCheckBoxOffice(){
        waitForClickability(CheckBoxOffice);
        CheckBoxOffice.click();
    }
}
