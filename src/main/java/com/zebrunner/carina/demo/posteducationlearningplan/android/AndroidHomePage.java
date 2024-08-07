package com.zebrunner.carina.demo.posteducationlearningplan.android;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.HomePageBase;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AndroidHomePage.class)
public class AndroidHomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "#filter_keyword")
    private ExtendedWebElement searchInput;

    @FindBy(css = ".button-in-search")
    private ExtendedWebElement searchButton;

    @FindBy(css = ".prdocutname")
    private List<ExtendedWebElement> searchResults;

    @FindBy(css = ".logo")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//*[@id=\"topnav\"]/select/option[4]")
    private ExtendedWebElement loginAndRegistrationButton;

    @FindBy(xpath = "//*[@id=\"topnav\"]/select/option[6]")
    private ExtendedWebElement cartButton;

    @FindBy(css = ".collapsed")
    private ExtendedWebElement hamburgerButton;


    public AndroidHomePage(WebDriver driver) {
        super(driver);
        open();
    }

    @Override
    public void searchForProduct(String productName) {
        hamburgerButton.click();
        searchInput.type(productName);
        searchButton.click();
    }

    @Override
    public LoginBasePage clickLoginButton() {
        hamburgerButton.click();
        loginAndRegistrationButton.click();
        return new AndroidLoginPage(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        hamburgerButton.click();
        cartButton.click();
        return new AndroidCartPage(driver);
    }

    @Override
    public String getLogoText() {
        return logo.getText();
    }

    @Override
    public boolean isSearchIncluded(String search) {
        for (ExtendedWebElement searchResult : searchResults) {
            if (!searchResult.getText().contains(search)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printSearchResults() {
        LOGGER.info("The results of the search are:");
        for (ExtendedWebElement searchResult : searchResults) {
            LOGGER.info(searchResult.getText());
        }
    }
}