/*

This class contains page  objects of Home Pages.

 */

package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.TableHeaderUI;

public class HomePage extends BasePage {



    @FindBy (xpath = "//td[contains (text(),'User: Tejas niturkar')]")
    WebElement userNameLabel ;

    @FindBy (xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink ;

    @FindBy (xpath ="//a[contains(text(), 'Deals')]")
    WebElement dealsLink ;

    @FindBy (xpath ="//a[contains(text(), 'Tasks')]")
    WebElement tasksLink ;

    @FindBy (xpath = "//a[contains(text(),'Companies')]")
    WebElement companiesLink ;

    @FindBy (xpath = "//a[contains(text(), 'New Contact')]")
    WebElement newContactsLink ;

    @FindBy (xpath = "//a[contains(text(), 'New Deal')]")
    WebElement newDealLink ;

    @FindBy (xpath = "//a[contains(text(), 'New Task')]")
    WebElement newTaskLink ;

    @FindBy (xpath = "//a[contains(text(), 'Docs')]")
    WebElement docsLink ;

    @FindBy (xpath = "//a[contains(text(),'New Document')]")
    WebElement newDocumentLink ;

    @FindBy (xpath = "//a[contains(text(),'New Company')]")
    WebElement newCompanyLink ;

    @FindBy (linkText = "Full Search Form")
    WebElement fullSearchFormLink ;

    @FindBy (xpath = "//a[contains(text(),'Calendar')]")
    WebElement calendarLink ;

    @FindBy (xpath = "//a[contains(text(),'New Event')]")
    WebElement calendarNewEventLink ;

    @FindBy (xpath = "//a[contains(text(),'Reports')]")
    WebElement reportsLink ;


    private final By formsLink = By.xpath("//a[.='Forms']");

//    @FindBy (xpath = "//a[contains(text(),'New Form')]")
//    WebElement newFormLink ;
    private final By newFormLink =By.xpath("//*[@title='New Form']");

    @FindBy (xpath = "//a[contains(text(),'Cases')]")
    WebElement casesLink ;

    @FindBy (xpath = "//a[contains(text(),'New Case')]")
    WebElement newCasesLink ;

    @FindBy (xpath = "//input[@name='search' and @value='Quick Search']")
    WebElement globalSearchInputField ;

    @FindBy (xpath = "//input[@type='image' and @src='https://classic.crmpro.com/skins/flatter/images/search.gif']")
    WebElement globalSearchButton ;

    @FindBy (xpath = "//a[@_name='Test' and @context='company']")
    public WebElement globalSearchResultVerifyField ;

    @FindBy (xpath = "//a[@title='Sales Targets']")
    WebElement salesTargetLink ;






    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String homePageTitle (){
        return driver.getTitle();
    }
    public HomePage switchToFrame(){
        driver.switchTo().frame("mainpanel");
        return this;
    }
    public boolean validateUsername () {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink (){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink (){
        dealsLink.click();
        return new DealsPage() ;
    }

    public TaskPage clickOnTaskLink (){
        tasksLink.click();
        return new TaskPage();
    }

    public DocsPage clickOnDocsLink(){
        docsLink.click();
        return new DocsPage() ;
    }

    public CompanyPage clickOnCompanyLink(){
        companiesLink.click();
        return new CompanyPage();
    }

    public CalendarPage clickOnCalendarLink(){
        calendarLink.click();
        return new CalendarPage() ;
    }

    public ReportsPage clickOnReportsLink(){
        reportsLink.click();
        return new ReportsPage();
    }

    public HomePage clickOnFormsLink(){
        driver.findElement(formsLink).click();
        return this;
    }

    public CasesPage clickOnCasesLink(){
        casesLink.click();
        return new CasesPage();
    }

    public TargetsPage clickOnSalesTargetsLink() throws InterruptedException {
        salesTargetLink.click();
        Thread.sleep(2000);
        return new TargetsPage();
    }


    public void clickOnNewContactsLink () throws InterruptedException {

        Actions actionNewContact  = new Actions(driver);
        Thread.sleep(4000);
        actionNewContact.moveToElement(contactsLink).build().perform();
        Thread.sleep(2000);
        newContactsLink.click();
        Thread.sleep(2000);
    }


    public void clickOnNewDealsLink () throws InterruptedException {
        Actions actionNewDeal = new Actions(driver);
        Thread.sleep(1000);
        actionNewDeal.moveToElement(dealsLink).build().perform();
        Thread.sleep(1000);
        newDealLink.click();
    }


    public void clickONewTasksLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(tasksLink).build().perform();
        Thread.sleep(2000);
        newTaskLink.click();
    }

    public void clickOnNewDocumentLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(docsLink).build().perform();
        Thread.sleep(1000);
        newDocumentLink.click();
    }

    public void clickOnNewCompanyLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(companiesLink).build().perform();
        Thread.sleep(2000);
        newCompanyLink.click();
    }

    public void clickOnFullSearchFormLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(companiesLink).build().perform();
        Thread.sleep(2000);
        fullSearchFormLink.click();
    }

    public void clickOnNewCalendarEventLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(calendarLink).build().perform();
        Thread.sleep(2000);
        calendarNewEventLink.click();
    }

    public FormsPage clickOnNewFormLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(1000);

        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(formsLink));
        actions.moveToElement(element).build().perform();
        Thread.sleep(1000);
        driver.findElement(newFormLink).click();
        return new FormsPage(driver);
    }

    public void clickOnNewCasesLink() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(casesLink).build().perform();
        Thread.sleep(1000);
        newCasesLink.click();
    }

    public void globalSearch (String searchData) {
        globalSearchInputField.sendKeys(searchData);
        globalSearchButton.click();
    }
}


