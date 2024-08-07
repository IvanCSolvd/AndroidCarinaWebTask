package com.zebrunner.carina.demo.posteducationlearningplan.desktop;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//div[@class='contentpanel']")
    private ExtendedWebElement carIsEmptyText;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCarIsEmptyTextPresent() {
        return carIsEmptyText.isPresent();
    }
}