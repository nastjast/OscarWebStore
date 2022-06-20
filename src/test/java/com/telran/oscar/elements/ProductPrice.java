package com.telran.oscar.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPrice extends Base{

    public ProductPrice(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String PRODUCT_PRICE_XPATH = "//a[contains(text(),'%s')]/ancestor::article//p[@class='price_color']";

    public String getProductPrice() {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_XPATH, label))).getText();
    }
}
