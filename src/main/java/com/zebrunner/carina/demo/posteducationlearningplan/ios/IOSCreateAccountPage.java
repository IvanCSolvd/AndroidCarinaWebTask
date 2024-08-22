package com.zebrunner.carina.demo.posteducationlearningplan.ios;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CreateAccountBasePage.class)
public class IOSCreateAccountPage extends CreateAccountBasePage {

    @ExtendedFindBy(iosPredicate = "name == 'I have read and agree to the  Privacy Policy'")
    private ExtendedWebElement policyButton;

    @ExtendedFindBy(iosPredicate = "name == '\uF00C Continue'")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Create Account'`]/XCUIElementTypeOther[5]")
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