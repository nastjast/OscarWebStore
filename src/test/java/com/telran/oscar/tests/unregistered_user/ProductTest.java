package com.telran.oscar.tests.unregistered_user;

import com.telran.oscar.elements.SideMenu;
import com.telran.oscar.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        homePage.openPage(URL);
    }

    @Test(groups = {"Positive", "Smoke", "Regression"})
    public void chooseFirstProductAndCompareWithDetailsPageTest() {
        new SideMenu(driver, "All products").clickOnSideMenuElement();
        String nameOfBookOnProductPage = cataloguePage.getNameOfBookByIndex(0);
        cataloguePage.clickOnProductByIndex(0);
        String nameOfBookOnDetailsPage = cataloguePage.getProductTitleOnProductPage();
        Assert.assertEquals(nameOfBookOnProductPage, nameOfBookOnDetailsPage);
    }

    @Test(groups = {"Positive", "Regression"})
    public void chooseLastProductAndCompareWithDetailsPageTest() {
        new SideMenu(driver, "All products").clickOnSideMenuElement();
        String nameOfBookOnProductPage = cataloguePage.getNameOfBookByIndex(cataloguePage.getNamesOfBooksList().size() - 1);
        cataloguePage.clickOnAddToBasketByLastIndex();
        String nameOfBookOnDetailsPage = cataloguePage.getProductTitleOnProductPage();
        Assert.assertTrue(nameOfBookOnDetailsPage.startsWith(nameOfBookOnProductPage.substring(0, 15)));
    }

    @Test(groups = {"Positive", "Regression"})
    public void chooseMiddleProductAndCompareWithDetailsPageTest() {
        new SideMenu(driver, "All products").clickOnSideMenuElement();
        String nameOfBookOnProductPage = cataloguePage.getNameOfBookByIndex(cataloguePage.getNamesOfBooksList().size() / 2);
        cataloguePage.clickOnAddToBasketByMiddleIndex();
        String nameOfBookOnDetailsPage = cataloguePage.getProductTitleOnProductPage();
        Assert.assertTrue(nameOfBookOnDetailsPage.startsWith(nameOfBookOnProductPage.substring(0, 15)));
    }

    @Test(groups = {"Positive", "Smoke", "Regression"})
    public void clickOnPaginationButtonAndComparePageNumber() {
        new SideMenu(driver, "All products").clickOnSideMenuElement();
        String paginationTextBeforeClicking = cataloguePage.getPaginationText();
        cataloguePage.clickOnPaginationNextBtn();
        String paginationTextAfterClicking = cataloguePage.getPaginationText();
        Assert.assertTrue(paginationTextBeforeClicking.contains("1"));
        Assert.assertTrue(paginationTextAfterClicking.contains("2"));
        Assert.assertNotEquals(paginationTextBeforeClicking, paginationTextAfterClicking);
    }
}
