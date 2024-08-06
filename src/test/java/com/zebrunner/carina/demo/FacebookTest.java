package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.facebook.FacebookHomePage;
import com.zebrunner.carina.demo.facebook.FacebookSignUpForm;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest implements IAbstractTest {

    @Test
    public void signUpTest() {
        FacebookHomePage homePage = new FacebookHomePage(getDriver());
        FacebookSignUpForm signUpForm = homePage.clickNewAccountbutton();
        signUpForm.typeName("Ivan");
        signUpForm.clickSignButton();
        Assert.assertTrue(signUpForm.isSignButtonPresent());
    }
}