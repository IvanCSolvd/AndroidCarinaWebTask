package com.zebrunner.carina.demo.posteducationlearningplan.ios;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginBasePage.class)
public class IOSLoginPage extends LoginBasePage {

    @ExtendedFindBy(iosPredicate = "name == 'Account Login'")
    public ExtendedWebElement loginNameInput;

    @ExtendedFindBy(iosPredicate = "name == '\uF00C Continue'")
    private ExtendedWebElement registrationContinueButton;

    @ExtendedFindBy(iosPredicate = "type == 'XCUIElementTypeSecureTextField'")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(iosPredicate = "name == '\uF023 Login'")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(iosPredicate = "name == ' MY ACCOUNT'")
    private ExtendedWebElement accountText;

    public IOSLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateAccountBasePage clickRegistrationContinueButton() {
        registrationContinueButton.click();
        return new IOSCreateAccountPage(driver);
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