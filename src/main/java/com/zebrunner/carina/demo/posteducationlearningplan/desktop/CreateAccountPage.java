package com.zebrunner.carina.demo.posteducationlearningplan.desktop;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CreateAccountBasePage.class)
public class CreateAccountPage extends CreateAccountBasePage {

    @FindBy(css = "#AccountFrm_agree")
    private ExtendedWebElement policyButton;

    @FindBy(css = ".btn-orange")
    private ExtendedWebElement continueButton;

    @FindBy(css = ".alert-error")
    private ExtendedWebElement alertErrorText;

    protected CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void acceptPolicy() {
        policyButton.click();
    }

    @Override
    public boolean isAlertErrorDisplayed() {
        return alertErrorText.isElementPresent();
    }

    @Override
    public void verifyRegistration() {
        continueButton.click();
    }
}