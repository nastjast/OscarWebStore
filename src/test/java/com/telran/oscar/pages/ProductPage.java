package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-header")
    WebElement pageTitle;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    @FindBy(css = ".product_pod")
    WebElement productTitle;

    public String getProductTitle() {
        return productTitle.getText();
    }

    @FindBy(xpath = "//div[contains(@class, 'product_main')]/h1")
    WebElement productTitleOnProductPage;

    public String getProductTitleOnProductPage() {
        return productTitleOnProductPage.getText();
    }

    @FindBy(xpath = "//div[contains(@class, 'product_main')]/p[contains(@class, 'price')]")
    WebElement productPriceOnProductPage;

    public String getProductPriceOnProductPage() {
        return productPriceOnProductPage.getText();
    }
}
