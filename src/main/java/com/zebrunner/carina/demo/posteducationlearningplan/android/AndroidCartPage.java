package com.zebrunner.carina.demo.posteducationlearningplan.android;

import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class AndroidCartPage extends CartPageBase {

    @FindBy(xpath = "name = //div[@class='contentpanel']")
    private ExtendedWebElement carIsEmptyText;

    protected AndroidCartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isEmptyCarTextPresent() {
        return carIsEmptyText.isPresent();
    }
}