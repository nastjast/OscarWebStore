package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//*[@class='basket-items']//p[contains(@class,'price_color')])[2]")
    WebElement totalBasketPrice;

    public String getTotalPrice() {
        return totalBasketPrice.getText();
    }

    @FindBy(xpath = "//h3[contains(@class,'price_color')]")
    WebElement orderTotalPrice;

    public String getOrderTotalPrice() {
        return orderTotalPrice.getText();
    }

    @FindBy(id = "id_form-0-quantity")
    WebElement quantityField;

    public BasketPage enterQuantity(String quantity) {
        type(quantityField, quantity);
        return this;
    }

    public String getQuantity() {
        return quantityField.getAttribute("value");
    }

    @FindBy(xpath = "//*[@class='input-group-btn']/button")
    WebElement updateBtn;

    public BasketPage clickOnUpdateBtn() {
        updateBtn.click();
        return this;
    }
}
