package com.telran.oscar.tests.registered_user;

import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void selectItemFromSideMenuTest() {
        homePage.openPage(URL);
        homePage.selectCategory();
        Assert.assertTrue(productPage.getPageTitle().contains("Books"));
    }

}
