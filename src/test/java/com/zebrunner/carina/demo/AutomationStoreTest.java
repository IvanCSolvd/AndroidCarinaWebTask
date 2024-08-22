package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.posteducationlearningplan.android.NativeChrome;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CartPageBase;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.CreateAccountBasePage;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.HomePageBase;
import com.zebrunner.carina.demo.posteducationlearningplan.commonpages.LoginBasePage;
import com.zebrunner.carina.demo.posteducationlearningplan.desktop.HomePage;
import com.zebrunner.carina.demo.utils.MobileContextUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationStoreTest implements IAbstractTest {

    @Test
    public void testFailedRegistration() {
        HomePage homePage = new HomePage(getDriver());
        LoginBasePage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened());
        CreateAccountBasePage createAccountPage = loginPage.clickRegistrationContinueButton();
        createAccountPage.acceptPolicy();
        createAccountPage.verifyRegistration();
        Assert.assertTrue(createAccountPage.isAlertErrorDisplayed(), "The registration error was not displayed");
    }

    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        LoginBasePage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isPageOpened());
        loginPage.login("testeandoando", "Test123");
        Assert.assertTrue(loginPage.accountIsLogged(), "Account is not logged");
    }

    @Test
    public void testSearchProduct() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Page is not opened correctly in the Home Page.");
        String logoText = homePage.getLogoText();
        Assert.assertEquals(logoText, "Automation Test Store", "Logo text is not the same");
        homePage.searchForProduct("shirt");
        homePage.printSearchResults();
        Assert.assertTrue(homePage.isSearchIncluded("shirt"), "The product ");
    }

    @Test
    public void testEmptyCart() {
        HomePage homePage = new HomePage(getDriver());
        CartPageBase cartPage = homePage.clickCartButton();
        Assert.assertTrue(cartPage.isEmptyCarTextPresent(), "Car is not empty");
    }

    @Test
    public void testWebView() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);

        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);

        NativeChrome nativeChrome = new NativeChrome(getDriver());
        nativeChrome.openNewTab();
    }
}