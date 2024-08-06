package com.zebrunner.carina.demo.posteducationlearningplan;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends AbstractPage {

    @FindBy(css = "#AccountFrm_agree")
    private ExtendedWebElement policyButton;

    @FindBy(css = ".btn-orange")
    private ExtendedWebElement continueButton;

    @FindBy(css = ".alert-error")
    private ExtendedWebElement alertErrorText;

    protected CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void acceptPolicy() {
        policyButton.click();
    }

    public boolean isAlertErrorDisplayed() {
        return alertErrorText.isElementPresent();
    }

    public void verifyRegistration() {
        continueButton.click();
    }
}