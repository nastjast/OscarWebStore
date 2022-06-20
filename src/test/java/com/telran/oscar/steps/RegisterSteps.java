package com.telran.oscar.steps;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginAndRegistrationPage;
import org.openqa.selenium.WebDriver;

import static com.telran.oscar.constants.ITestConstants.*;

public class RegisterSteps {

    LoginAndRegistrationPage loginAndRegistrationPage;
    HomePage homePage;
    LoginSteps loginSteps;

    public RegisterSteps(WebDriver driver) {
        loginAndRegistrationPage = new LoginAndRegistrationPage(driver);
        homePage = new HomePage(driver);
        loginSteps = new LoginSteps(driver);
    }

    public void openPageAndRegister(String email, String pass, String confirmPass) {
        loginSteps.openLoginAndRegistrationPage();
        loginAndRegistrationPage.fillRegisterForm(email, pass, confirmPass);
        homePage.openPage(URL);
    }
}
