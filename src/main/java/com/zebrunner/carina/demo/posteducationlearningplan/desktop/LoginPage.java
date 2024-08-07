package com.zebrunner.carina.demo.posteducationlearningplan.desktop;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginBasePage.class)
public class LoginPage extends LoginBasePage {

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

    @Override
    public CreateAccountBasePage clickRegistrationContinueButton() {
        registrationContinueButton.click();
        return new CreateAccountPage(driver);
    }

    @Override
    public void login(String username, String password) {
        loginNameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
    }

    @Override
    public boolean accountIsLogged() {
        return accountText.getText().equals("My Account");
    }
}