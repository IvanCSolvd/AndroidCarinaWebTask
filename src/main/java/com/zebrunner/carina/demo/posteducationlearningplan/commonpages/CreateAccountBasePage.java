package com.zebrunner.carina.demo.posteducationlearningplan.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CreateAccountBasePage extends AbstractPage {
    protected CreateAccountBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void acceptPolicy();

    public abstract boolean isAlertErrorDisplayed();

    public abstract void verifyRegistration();
}