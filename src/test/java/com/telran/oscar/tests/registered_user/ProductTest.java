package com.telran.oscar.tests.registered_user;

import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        loginSteps.logIn(VALID_EMAIL, VALID_PASSWORD);
    }

    @Test
    public void checkRecommendedReadingLinkTest() {
        String titleOnHomePage = homePage.getRecommendedReadingProductName();
        String priceOnHomePage = homePage.getRecommendedReadingProductPrice();
        homePage.clickOnRecommendedReadingLink();
        String titleOnProductPage = productPage.getProductTitleOnProductPage();
        String priceOnProductPage = productPage.getProductPriceOnProductPage();
        Assert.assertEquals(titleOnHomePage, titleOnProductPage);
        Assert.assertEquals(priceOnHomePage, priceOnProductPage);
    }
}
