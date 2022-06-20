package com.telran.oscar.pages;

import com.telran.oscar.utils.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage {
    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Edit')]")
    WebElement editProfileBtn;

    public EditProfilePage clickOnEditProfileBtn() {
        editProfileBtn.click();
        return this;
    }

    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    public EditProfilePage enterUserInfo(String name) {
        if (name != null && !name.equals(nameCell.getText())) {
            type(firstNameField, name);
        }
        return this;
    }

    @FindBy(xpath = "(//table//td)[1]")
    WebElement nameCell;

    public String getUserName() {
        Waiters.waitForElementLocated(driver, nameCell, 10);
        return nameCell.getText();
    }
}
