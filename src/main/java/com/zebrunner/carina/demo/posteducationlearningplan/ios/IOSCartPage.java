package com.zebrunner.carina.demo.posteducationlearningplan.ios;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class IOSCartPage extends CartPageBase {

    @FindBy(xpath = "//div[@class='contentpanel']")
    private ExtendedWebElement carIsEmptyText;

    protected IOSCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isEmptyCarTextPresent() {
        return carIsEmptyText.isPresent();
    }
}