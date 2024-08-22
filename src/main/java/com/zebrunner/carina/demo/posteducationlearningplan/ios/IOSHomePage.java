package com.zebrunner.carina.demo.posteducationlearningplan.ios;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.HomePageBase;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class IOSHomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosPredicate = "value == 'Search Keywords'")
    private ExtendedWebElement searchInput;

    @ExtendedFindBy(iosPredicate = "name == '\uF002'")
    private ExtendedWebElement searchButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Search'`]")
    private List<ExtendedWebElement> searchResults;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == 'Automation Test Store'`]")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosPredicate = "name == 'Login'")
    private ExtendedWebElement loginAndRegistrationButton;

    @ExtendedFindBy(iosPredicate = "name == 'Cart'")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'navegación'`][1]/XCUIElementTypeButton")
    private ExtendedWebElement hamburgerButton;


    public IOSHomePage(WebDriver driver) {
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
        return new IOSLoginPage(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        hamburgerButton.click();
        cartButton.click();
        return new IOSCartPage(driver);
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