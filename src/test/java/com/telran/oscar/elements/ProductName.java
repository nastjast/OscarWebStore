package com.telran.oscar.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductName extends Base {

    public ProductName(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String PRODUCT_ADD_TO_CART_BTN_XPATH = "//a[contains(text(),'%s')]/ancestor::article//button";

    public void addProductToCart() {
        driver.findElement(By.xpath(String.format(PRODUCT_ADD_TO_CART_BTN_XPATH, label))).click();
    }
}
