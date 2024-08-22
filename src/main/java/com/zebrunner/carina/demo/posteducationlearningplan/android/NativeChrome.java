package com.zebrunner.carina.demo.posteducationlearningplan.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NativeChrome extends AbstractPage {
    @FindBy(id = "com.android.chrome:id/tab_switcher_button")
    public ExtendedWebElement seeTabsButton;

    @FindBy(id = "com.android.chrome:id/new_tab_view")
    public ExtendedWebElement newTabButton;

    public NativeChrome(WebDriver driver) {
        super(driver);
    }

    public void openNewTab() {
        seeTabsButton.click();
        newTabButton.click();
    }
}