package com.telran.oscar.tests.registered_user;

import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    
    @BeforeMethod
    public void ensurePreconditions() {
        loginSteps.openLoginAndRegistrationPage();
    }
    
    @Test(groups = {"Positive", "Smoke", "Regression"})
    public void loginWithValidCredsTest() {
        loginAndRegistrationPage.fillLogInForm(VALID_EMAIL, VALID_PASSWORD);
        Assert.assertTrue(cataloguePage.getSuccessMsg().contains(LOGIN_MSG));
    }

    @AfterMethod
    public void logOut() {
        homePage.logOut();
        Assert.assertTrue(homePage.isLogInLinkDisplayed());
    }
 }
