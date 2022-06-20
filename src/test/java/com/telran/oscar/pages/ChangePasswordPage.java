package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Change pass')]")
    WebElement changePassBtn;

    public ChangePasswordPage clickOnChangePassBtn() {
        changePassBtn.click();
        return this;
    }

    @FindBy(id = "id_old_password")
    WebElement oldPassField;

    @FindBy(id = "id_new_password1")
    WebElement newPassField;

    @FindBy(id = "id_new_password2")
    WebElement confirmNewPassField;

    public ChangePasswordPage changePass(String oldPass, String newPass, String confirmNewPass) {
        if (oldPass != null) {
            type(oldPassField, oldPass);
        }
        if (newPass != null && !newPass.equals(oldPass)) {
            type(newPassField, newPass);
        }
        if (confirmNewPass != null && confirmNewPass == newPass) {
            type(confirmNewPassField, newPass);
        }
        return this;
    }
}
