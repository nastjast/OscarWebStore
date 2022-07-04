package com.telran.oscar.tests.registered_user;

import com.telran.oscar.tests.TestBase;
import com.telran.oscar.utils.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        loginSteps.openLoginAndRegistrationPage();
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "registrationWithInvalidEmailFromCSV", groups = {"Negative", "Regression"})
    public void registerNewUserWithInvalidEmailTest(String email) {
        loginAndRegistrationPage.fillRegisterForm(email, VALID_PASSWORD, VALID_PASSWORD);
        Assert.assertTrue(loginAndRegistrationPage.isRegisterFormDisplayed());
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "registrationWithInvalidPasswordFromCSV", groups = {"Negative", "Regression"})
    public void registerNewUserWithInvalidPasswordTest(String password) {
        loginAndRegistrationPage.fillRegisterForm(REGISTRATION_EMAIL, password, password);
        Assert.assertTrue(loginAndRegistrationPage.isRegisterFormDisplayed());
    }

    @Test(groups = {"Negative", "Regression"})
    public void registerUserWithExistingEmailTest() {
        loginAndRegistrationPage.fillRegisterForm(VALID_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
        Assert.assertTrue(loginAndRegistrationPage.getExistingUserError().contains(EXISTING_USER_MSG));
    }

    @Test(groups = {"Positive", "Smoke", "Regression"})
    public void registerUserWithValidDataTest() {
        loginAndRegistrationPage.fillRegisterForm(REGISTRATION_EMAIL, PASS_REGISTRATION, PASS_REGISTRATION);
        Assert.assertTrue(cataloguePage.getSuccessMsg().contains(REGISTRATION_MSG));
    }

    @Test(groups = {"Positive", "Smoke", "Regression"})
    public void logOut() {
        loginAndRegistrationPage.fillRegisterForm(REGISTRATION_EMAIL, PASS_REGISTRATION, PASS_REGISTRATION);
        homePage.logOut();
        Assert.assertTrue(homePage.isLogInLinkDisplayed());
    }
}
