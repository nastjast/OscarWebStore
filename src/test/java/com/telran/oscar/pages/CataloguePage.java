package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CataloguePage extends BasePage {
    public CataloguePage(WebDriver driver) {
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

    @FindBy(xpath = "//h3/a")
    List<WebElement> nameOfBooksList;


    public String getNameOfBookByIndex(int index) {
        return getNamesOfBooksList().get(index).getText();
    }

    public List<WebElement> getNamesOfBooksList() {
        return nameOfBooksList;
    }

    public CataloguePage clickOnProductByIndex(int index) {
        getNamesOfBooksList().get(index).click();
        return this;
    }

    public CataloguePage clickOnAddToBasketByLastIndex() {
        getNamesOfBooksList().get(getNamesOfBooksList().size() - 1).click();
        return this;
    }

    public CataloguePage clickOnAddToBasketByMiddleIndex() {
        getNamesOfBooksList().get(getNamesOfBooksList().size() / 2).click();
        return this;
    }

    @FindBy(xpath = "//*[@class='pager']/*[@class='current']")
    WebElement paginationText;

    public String getPaginationText() {
        return paginationText.getText();
    }

    @FindBy(xpath = "//*[@class='pager']//a")
    WebElement paginationNextBtn;

    public CataloguePage clickOnPaginationNextBtn() {
        paginationNextBtn.click();
        return this;
    }


}
