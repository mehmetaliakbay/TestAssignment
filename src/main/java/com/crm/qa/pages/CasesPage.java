package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class CasesPage extends TestBase {


    @FindBy (xpath = "//input[@name='title']")
    WebElement title;

    @FindBy (xpath = "//input[@name='closed' and @value='N']")
    WebElement state;

    @FindBy (xpath = "//input[@name='identifier']")
    WebElement identifier ;

    @FindBy (xpath = "//input[@name='tags']")
    WebElement tags;

    @FindBy (xpath = "//textarea[@name='description']")
    WebElement description ;

    @FindBy (xpath = "//input[@value='Lookup']")
    WebElement contactLookup;

    @FindBy (xpath = "//input[@name='search']")
    WebElement searchContactLookup;

    @FindBy (xpath = "//input[@type='submit']")
    WebElement searchContactButton ;

    @FindBy (xpath = "//td[contains(text(),'Case: 100')]")
    public WebElement caseAddedLabel ;

    @FindBy (xpath = "//a[contains(text(),'bansal - contact')]")
    WebElement searchedContactLink ;

    @FindBy (xpath = " //input[@value='Save']//parent::td[1]")
    WebElement saveButton;


    @FindBy(xpath = "//legend[contains(text(),'Case Information')]")
    WebElement tempLabel ;

    @FindBy (xpath = "//i[@title='Edit']")
    WebElement editIcon ;

    @FindBy (xpath = "//td[contains(text(),'Case:')]")
    WebElement updatedCaseLabel ;


    @FindBy (xpath = "//input[@name='cs_keyword']")
    WebElement searchKeyword ;

    @FindBy (xpath = "//input[@name='cs_submit' and @value= 'Search']")
    WebElement searchButton ;

    @FindBy (xpath = "//a[contains(text(),'Test Case')]")
    public WebElement searchResult ;




    public CasesPage(){
        PageFactory.initElements(driver,this);
    }



    public void createNewCase(String strTitle, String strStatus, String strIdentifier, String strTags, String strDescription,
                              String strType, String strPriority  ) throws InterruptedException {

        title.sendKeys(strTitle);
        Select selectStatus = new Select(driver.findElement(By.xpath("//select[@name='status']")));
        selectStatus.selectByVisibleText(strStatus);
        state.click();
        identifier.sendKeys(strIdentifier);
        tags.sendKeys(strTags);
        description.sendKeys(strDescription);
        Select selectType = new Select(driver.findElement(By.xpath("//select[@name='type']")));
        selectType.selectByVisibleText(strType);
        Select selectPriority = new Select(driver.findElement(By.xpath("//select[@name='priority']")));
        selectPriority.selectByVisibleText(strPriority);
        saveButton.click();
    }

    public void updateCase(String strTitle, String strDescription) throws InterruptedException {

        editIcon.click();
        Thread.sleep(2000);
        title.clear();
        title.sendKeys(strTitle);
        description.sendKeys(strDescription);
        saveButton.click();
    }

    public boolean validateUpdatedCaseLabel(){
        return updatedCaseLabel.isDisplayed();
    }


    public void searchCase(String strKeyword){
        searchKeyword.sendKeys(strKeyword);
        searchButton.click();
    }


    public void validateSearchCaseResult(){
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),'Test Case')]"));
        System.out.println("Number of search result: - " + elements.size());

        for (int i =0 ; i < elements.size(); i++){
            searchResult.isDisplayed();
            System.out.println("Value of search result :- " + searchResult.getText());
        }
    }


}
