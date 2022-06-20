package com.telran.oscar.tests.unregistered_user;

import com.telran.oscar.elements.ProductPrice;
import com.telran.oscar.tests.TestBase;
import com.telran.oscar.utils.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        homePage.openPage(URL);
    }

    @Test(dataProviderClass = DataProvider.class, dataProvider = "product names")
    public void addProductToCartAndComparePriceOnCartPageTest(String name) {
        String productPriceOnHomePage = new ProductPrice(driver, name).getProductPrice();
        homePage.clickOnAddToBasketBtn(name)
                .clickOnViewBasketBtn();
        Assert.assertEquals(productPriceOnHomePage, basketPage.getTotalPrice());
        Assert.assertEquals(basketPage.getTotalPrice(), basketPage.getOrderTotalPrice());
    }
}
