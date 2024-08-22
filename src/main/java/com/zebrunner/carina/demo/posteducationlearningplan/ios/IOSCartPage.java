package com.zebrunner.carina.demo.posteducationlearningplan.ios;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class IOSCartPage extends CartPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'Your shopping cart is empty!'")
    private ExtendedWebElement carIsEmptyText;

    protected IOSCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isEmptyCarTextPresent() {
        return carIsEmptyText.isPresent();
    }
}