package com.telran.oscar.steps;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginAndRegistrationPage;
import org.openqa.selenium.WebDriver;

import static com.telran.oscar.constants.ITestConstants.URL;

public class LoginSteps {

    HomePage homePage;
    LoginAndRegistrationPage loginAndRegistrationPage;

    public LoginSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        loginAndRegistrationPage = new LoginAndRegistrationPage(driver);
    }

    public LoginSteps openLoginAndRegistrationPage() {
        homePage.openPage(URL);
        homePage.clickOnLoginAndRegisterLink();
        return this;
    }

    public LoginSteps logIn(String email, String pass) {
        homePage.openPage(URL);
        homePage.clickOnLoginAndRegisterLink();
        loginAndRegistrationPage.fillLogInForm(email, pass);
        homePage.openPage(URL);
        return this;
    }

}
