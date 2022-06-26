package com.telran.oscar.tests.unregistered_user;

import com.telran.oscar.elements.ProductPrice;
import com.telran.oscar.elements.SideMenu;
import com.telran.oscar.tests.TestBase;
import com.telran.oscar.utils.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnregUserHomePageTests extends TestBase {

    private static final String searchInput = "Digital Fortress";

    @BeforeMethod
    public void ensurePreconditions() {
        homePage.openPage(URL);
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "side menu elements", groups = "Positive")
    public void clickOnSideMenuLinksTest(String name) {
        new SideMenu(driver, name).clickOnSideMenuElement();
        Assert.assertEquals(cataloguePage.getPageTitle(), name);
    }

    @Test(groups = "Positive")
    public void searchForProductTest() {
        homePage.enterDataIntoSearchField(searchInput)
                .clickOnSearchBtn();
        Assert.assertTrue(cataloguePage.getPageTitle().contains(searchInput));
        Assert.assertTrue(cataloguePage.getProductTitle().contains(searchInput));
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "product names", groups = "Positive")
    public void addProductToBasketAndComparePrices(String name) {
        String productPrice = new ProductPrice(driver, name).getProductPrice();
        homePage.clickOnAddToBasketBtn(name);
        String basketPrice = homePage.getBasketIconPrice();
        Assert.assertTrue(basketPrice.contains(productPrice));
    }
}
