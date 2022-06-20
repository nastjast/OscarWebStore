package com.telran.oscar.tests.unregistered_user;

import com.telran.oscar.elements.ProductPrice;
import com.telran.oscar.elements.SideMenu;
import com.telran.oscar.tests.TestBase;
import com.telran.oscar.utils.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnregUserHomePageTests extends TestBase {

    private String searchInput = "Digital Fortress";

    @BeforeMethod
    public void ensurePreconditions() {
        homePage.openPage(URL);
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "side menu elements")
    public void clickOnSideMenuLinksTest(String name) {
        new SideMenu(driver, name).clickOnSideMenuElement();
        Assert.assertEquals(productPage.getPageTitle(), name);
    }

    @Test
    public void searchForProductTest() {
        homePage.enterDataIntoSearchField(searchInput)
                .clickOnSearchBtn();
        Assert.assertTrue(productPage.getPageTitle().contains(searchInput));
        Assert.assertTrue(productPage.getProductTitle().contains(searchInput));
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "product names")
    public void addProductToBasketAndComparePrices(String name) {
        String productPrice = new ProductPrice(driver, name).getProductPrice();
        homePage.clickOnAddToBasketBtn(name);
        String basketPrice = homePage.getBasketIconPrice();
        Assert.assertTrue(basketPrice.contains(productPrice));
    }
}
