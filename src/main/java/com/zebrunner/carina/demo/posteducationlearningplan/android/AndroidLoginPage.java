package com.zebrunner.carina.demo.posteducationlearningplan.android;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginBasePage.class)
public class AndroidLoginPage extends LoginBasePage {

    @FindBy(id = "loginFrm_loginname")
    public ExtendedWebElement loginNameInput;

    @FindBy(css = "[title='Continue']")
    private ExtendedWebElement registrationContinueButton;

    @FindBy(id = "loginFrm_password")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "[title='Login']")
    private ExtendedWebElement loginButton;

    @FindBy(css = ".maintext")
    private ExtendedWebElement accountText;

    public AndroidLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateAccountBasePage clickRegistrationContinueButton() {
        registrationContinueButton.click();
        return new AndroidCreateAccountPage(driver);
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