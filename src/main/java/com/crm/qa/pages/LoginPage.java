package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//*[@value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {

        write(usernameInput,username);
        write(passwordInput,password);
        click(loginButton);

        return new HomePage(driver);

    }
}
