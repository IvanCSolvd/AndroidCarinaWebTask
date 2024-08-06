package com.zebrunner.carina.demo.posteducationlearningplan;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage {

    @FindBy(xpath = "/input[@id='loginFrm_loginname']")
    public ExtendedWebElement loginNameInput;

    @FindBy(css = "[title='Continue']")
    private ExtendedWebElement registrationContinueButton;

    @FindBy(css = "#loginFrm_password")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "[title='Login']")
    private ExtendedWebElement loginButton;

    @FindBy(css = ".maintext")
    private ExtendedWebElement accountText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPage clickRegistrationContinueButton() {
        registrationContinueButton.click();
        return new CreateAccountPage(driver);
    }

    public void login(String username, String password) {
        loginNameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
    }

    public boolean accountIsLogged() {
        return accountText.getText().equals("My Account");
    }
}