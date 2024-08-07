package com.zebrunner.carina.demo.posteducationlearningplan.desktop;

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

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePage.class)
public class HomePage extends HomePageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "#filter_keyword")
    private ExtendedWebElement searchInput;

    @FindBy(css = ".button-in-search")
    private ExtendedWebElement searchButton;

    @FindBy(css = ".prdocutname")
    private List<ExtendedWebElement> searchResults;

    @FindBy(css = ".header-logo img")
    private ExtendedWebElement logo;

    @FindBy(css = "#customer_menu_top")
    private ExtendedWebElement loginAndRegistrationButton;

    @FindBy(css = "li[data-id=menu_cart]")
    private ExtendedWebElement cartButton;

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    @Override
    public void searchForProduct(String productName) {
        searchInput.type(productName);
        searchButton.click();
    }

    @Override
    public LoginBasePage clickLoginButton() {
        loginAndRegistrationButton.click();
        return new LoginPage(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
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