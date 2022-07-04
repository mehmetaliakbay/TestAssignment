package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends BasePage {

    @FindBy (xpath = "//td[contains(text(), 'Feedback Forms')]")
    WebElement feedbackFormsLabel ;


    private final By formTitle = By.name("title");

    private final By reportMail = By.name("report_email");
    private final By description = By.name("description");


    private final By welcomeMessage = By.name("welcome_message");
    private final By confirmationMessage = By.name("confirmation_message");
    private final By saveButton = By.xpath("//input[@type= 'submit' and @value= 'Save' and @class = 'button']");

    private final By formTitleText = By.xpath("//td[.='Title']/following-sibling::td");
    private final By reportMailText = By.xpath("//td[.='Report Email']/following-sibling::td");
    private final By descriptionText = By.xpath("//td[.='Description']/..//following-sibling::tr/td");
    private final By welcomeMessageText = By.xpath("//td[.='Welcome Message']/..//following-sibling::tr/td");
    private final By confirmationMessageText = By.xpath("//td[.='Confirmation ']/..//following-sibling::tr/td");


    public FormsPage(WebDriver driver) {
        super(driver);
    }


    public boolean validateFormsPageLabel() throws InterruptedException {
        Thread.sleep(1000);
        return feedbackFormsLabel.isDisplayed();
    }


    public FormsPage createNewForm(String strFormTitle, String strReportMail, String strDescription, String strWelcomeMessage,
                              String strConfirmationMessage){
        write(formTitle,strFormTitle);
        write(reportMail,strReportMail);
        write(description,strDescription);
        write(welcomeMessage,strWelcomeMessage);
        write(confirmationMessage,strConfirmationMessage);
        click(saveButton);
        return this;
    }

    public String getFormTitle(){
        return findElement(formTitleText).getText().trim();
    }

    public String getReportMailText(){
        return findElement(reportMailText).getText().trim();
    }
    public String getDescriptionText(){
        return findElement(descriptionText).getText().trim();
    }
    public String getWelcomeMessageText(){
        return findElement(welcomeMessageText).getText().trim();
    }
    public String getConfirmationMessageText(){
        return findElement(confirmationMessageText).getText().trim();
    }

}
