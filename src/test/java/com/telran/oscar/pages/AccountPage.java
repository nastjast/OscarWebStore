package com.telran.oscar.pages;


import com.telran.oscar.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    public AccountPage clickOnDeleteProfileBtn() {
        deleteProfileBtn.click();
        return this;
    }

    @FindBy(id = "id_password")
    WebElement passField;

    @FindBy(css = ".btn-danger")
    WebElement deleteBtn;

    public void enterPasswordAndDelete(String text) {
        type(passField, text);
        deleteBtn.click();
    }

    @FindBy(css = ".btn-lg")
    WebElement saveNewPassBtn;

    public AccountPage clickOnSaveBtn() {
        saveNewPassBtn.click();
        return this;
    }
}
