package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.config.GlobalConst;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class FormsPageTest extends TestBase {

    String sheetName = "forms";
    @DataProvider
    public Object[][] getCRMTestData() {
        return TestUtils.getTestData(sheetName);
    }

    @Test(groups = {"e2e"},dataProvider = "getCRMTestData", description = "A Test that fill forms and validate values")
    public void validateCreateNewForms(String formTitle, String reportMail, String description, String welcomeMessage,
                                       String confirmationMessage) throws InterruptedException {

        FormsPage formsPage = new LoginPage(getDriver())
                .login(GlobalConst.USERNAME, GlobalConst.PASSWORD)
                .switchToFrame()
                .clickOnNewFormLink()
                .createNewForm(formTitle, reportMail, description, welcomeMessage, confirmationMessage);


        Assert.assertEquals(formsPage.getReportMailText(),reportMail);
        Assert.assertEquals(formsPage.getDescriptionText(),description);
        Assert.assertEquals(formsPage.getWelcomeMessageText(),welcomeMessage);
        Assert.assertEquals(formsPage.getConfirmationMessageText(),confirmationMessage);
    }


}




