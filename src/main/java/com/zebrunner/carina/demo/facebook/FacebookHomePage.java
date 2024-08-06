package com.zebrunner.carina.demo.facebook;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FacebookHomePage extends AbstractPage {
    @FindBy(xpath = "//a[text()='Create new account']")
    private ExtendedWebElement createNewAccountButton;

    public FacebookHomePage(WebDriver driver) {
        super(driver);
        open();
    }

    public FacebookSignUpForm clickNewAccountbutton() {
        createNewAccountButton.click();
        return new FacebookSignUpForm(getDriver());
    }
}