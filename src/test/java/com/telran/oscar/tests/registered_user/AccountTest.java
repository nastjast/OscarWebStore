package com.telran.oscar.tests.registered_user;

import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        loginSteps.logIn(VALID_EMAIL, VALID_PASSWORD);
        homePage.clickOnAccountLink();
    }

    @Test(groups = "Positive")
    public void changePassAndLogInWithNewOneTest() {
        changePasswordPage.clickOnChangePassBtn()
                .changePass(VALID_PASSWORD, CHANGED_PASSWORD, CHANGED_PASSWORD);
        accountPage.clickOnSaveBtn();
        homePage.logOut()
                .clickOnLoginAndRegisterLink()
                .fillLogInForm(VALID_EMAIL, CHANGED_PASSWORD);
        Assert.assertTrue(cataloguePage.getSuccessMsg().contains(LOGIN_MSG));
    }

    @Test(groups = "Positive")
    public void changeProfileNameTest() {
        String originalName = editProfilePage.getUserName();
        editProfilePage.clickOnEditProfileBtn()
                .enterUserInfo(USER_NAME);
        accountPage.clickOnSaveBtn();
        String changedName = editProfilePage.getUserName();
        Assert.assertTrue(accountPage.getSuccessMsg().contains(PROFILE_UPDATED_MSG));
        Assert.assertNotEquals(originalName, changedName);
    }
}
