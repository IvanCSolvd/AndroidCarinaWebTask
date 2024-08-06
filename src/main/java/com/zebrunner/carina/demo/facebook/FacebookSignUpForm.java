package com.zebrunner.carina.demo.facebook;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FacebookSignUpForm extends AbstractPage {
    @FindBy(name = "firstname")
    private ExtendedWebElement nameField;

    @FindBy(name = "websubmit")
    private ExtendedWebElement signUpButton;

    protected FacebookSignUpForm(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name) {
        nameField.type(name);
    }

    public void clickSignButton() {
        signUpButton.click();
    }

    public boolean isSignButtonPresent() {
        return signUpButton.isPresent();
    }
}