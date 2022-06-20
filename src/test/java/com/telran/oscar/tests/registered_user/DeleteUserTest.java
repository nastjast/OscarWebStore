package com.telran.oscar.tests.registered_user;

import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteUserTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        registerSteps.openPageAndRegister(REGISTRATION_EMAIL, VALID_PASSWORD, VALID_PASSWORD);
    }

    @Test
    public void deleteRegisteredUserTest() {
        homePage.clickOnAccountLink()
                .clickOnDeleteProfileBtn()
                .enterPasswordAndDelete(VALID_PASSWORD);
        Assert.assertTrue(productPage.getSuccessMsg().contains(DELETED_ACC_MSG));
        Assert.assertTrue(homePage.isLogInLinkDisplayed());
    }
}
