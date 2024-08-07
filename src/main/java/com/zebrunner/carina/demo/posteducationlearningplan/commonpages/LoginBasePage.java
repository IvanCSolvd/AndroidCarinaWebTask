package com.zebrunner.carina.demo.posteducationlearningplan.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginBasePage extends AbstractPage {

    protected LoginBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract CreateAccountBasePage clickRegistrationContinueButton();

    public abstract void login(String username, String password);

    public abstract boolean accountIsLogged();
}