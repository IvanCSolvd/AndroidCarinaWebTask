package com.zebrunner.carina.demo.posteducationlearningplan.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NativeChrome extends AbstractPage {
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\'Switch or close tabs\']")
    public ExtendedWebElement seeTabsButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\'New tab\']")
    public ExtendedWebElement newTabButton;

    public NativeChrome(WebDriver driver) {
        super(driver);
    }

    public void openNewTab() {
        seeTabsButton.click();
        newTabButton.click();
    }
}