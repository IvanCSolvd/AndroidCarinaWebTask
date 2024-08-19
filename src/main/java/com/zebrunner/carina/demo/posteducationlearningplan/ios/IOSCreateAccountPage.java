package com.zebrunner.carina.demo.posteducationlearningplan.ios;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateAccountBasePage.class)
public class IOSCreateAccountPage extends CreateAccountBasePage {

    @FindBy(id = "AccountFrm_agree")
    private ExtendedWebElement policyButton;

    @FindBy(css = ".btn-orange")
    private ExtendedWebElement continueButton;

    @FindBy(css = ".alert-error")
    private ExtendedWebElement alertErrorText;

    protected IOSCreateAccountPage(WebDriver driver) {
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