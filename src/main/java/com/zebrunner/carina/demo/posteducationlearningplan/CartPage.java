package com.zebrunner.carina.demo.posteducationlearningplan;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='contentpanel']")
    private ExtendedWebElement carIsEmptyText;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCarIsEmptyTextPresent() {
        return carIsEmptyText.isPresent();
    }
}