package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'product_main')]/p[contains(@class, 'price')]")
    WebElement productPriceOnProductPage;

    public String getProductPriceOnProductPage() {
        return productPriceOnProductPage.getText();
    }
}
