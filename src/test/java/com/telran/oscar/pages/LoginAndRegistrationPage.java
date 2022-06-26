package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAndRegistrationPage extends BasePage {
    public boolean isRegisterFormDisplayed() {
        return registerForm.isDisplayed();
    }

    public LoginAndRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "register_form")
    WebElement registerForm;

    @FindBy(id = "id_registration-email")
    WebElement emaiRegisterlField;

    @FindBy(id = "id_registration-password1")
    WebElement passwordRegisterField;

    @FindBy(id = "id_registration-password2")
    WebElement confirmPasswordField;

    @FindBy(name = "registration_submit")
    WebElement registrationSubmitButton;

    public CataloguePage fillRegisterForm(String email, String validPassword, String confirmPassword) {
        type(emaiRegisterlField, email);
        type(passwordRegisterField, validPassword);
        type(confirmPasswordField, confirmPassword);
        registrationSubmitButton.click();
        return new CataloguePage(driver);
    }

    @FindBy(xpath = "//span[contains (text(), 'exists')]")
    WebElement existingUserErrorMsg;

    public String getExistingUserError() {
        return existingUserErrorMsg.getText();
    }

    @FindBy(id = "id_login-username")
    WebElement emailLoginField;

    @FindBy(id = "id_login-password")
    WebElement passLoginField;

    @FindBy(name = "login_submit")
    WebElement logInBtn;

    public CataloguePage fillLogInForm(String email, String pass) {
        type(emailLoginField, email);
        type(passLoginField, pass);
        logInBtn.click();
        return new CataloguePage(driver);
    }
}
