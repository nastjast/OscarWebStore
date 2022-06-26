package com.telran.oscar.pages;

import com.telran.oscar.elements.ProductName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".basket-mini")
    WebElement priceNearBasketIcon;

    public String getBasketIconPrice() {
        return priceNearBasketIcon.getText();
    }

    public HomePage clickOnAddToBasketBtn(String name) {
        new ProductName(driver, name).addProductToCart();
        return this;
    }

    @FindBy(css = "form > input.btn")
    WebElement searchBtn;

    public CataloguePage clickOnSearchBtn() {
        searchBtn.click();
        return new CataloguePage(driver);
    }

    @FindBy(id = "id_q")
    WebElement searchField;

    public HomePage enterDataIntoSearchField(String text) {
        type(searchField, text);
        return this;
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;

    public CataloguePage selectCategory() {
        submenuBook.click();
        return new CataloguePage(driver);
    }

    @FindBy(id = "login_link")
    WebElement loginLink;

    public LoginAndRegistrationPage clickOnLoginAndRegisterLink() {
        loginLink.click();
        return new LoginAndRegistrationPage(driver);
    }

    public boolean isLogInLinkDisplayed() {
        return isElementDisplayed(loginLink);
    }

    @FindBy(id = "logout_link")
    WebElement logOutLink;

    public HomePage logOut() {
        logOutLink.click();
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),' Account')]")
    WebElement accountLink;

    public AccountPage clickOnAccountLink() {
        accountLink.click();
        return new AccountPage(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'pussyfoot')]")
    WebElement pussyfootLink;

    public CataloguePage clickOnRecommendedReadingLink() {
        pussyfootLink.click();
        return new CataloguePage(driver);
    }

    public String getRecommendedReadingProductName() {
        return pussyfootLink.getText();
    }

    @FindBy(xpath = "(//div//p[contains(@class, 'price_color')])[1]")
    WebElement recommendedReadingProductPrice;

    public String getRecommendedReadingProductPrice() {
        return recommendedReadingProductPrice.getText();
    }

    @FindBy(xpath = "//span/*[contains(text(), 'basket')]")
    WebElement viewBasketBtn;

    public BasketPage clickOnViewBasketBtn() {
        viewBasketBtn.click();
        return new BasketPage(driver);
    }
}
