package com.zebrunner.carina.demo.posteducationlearningplan.commonpages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void searchForProduct(String productName);

    public abstract LoginBasePage clickLoginButton();

    public abstract CartPageBase clickCartButton();

    public abstract String getLogoText();

    public abstract boolean isSearchIncluded(String search);

    public abstract void printSearchResults();
}