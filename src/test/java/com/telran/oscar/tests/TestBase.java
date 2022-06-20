package com.telran.oscar.tests;

import com.telran.oscar.constants.ITestConstants;
import com.telran.oscar.pages.*;
import com.telran.oscar.steps.LoginSteps;
import com.telran.oscar.steps.RegisterSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase implements ITestConstants {
    public WebDriver driver;
    public LoginSteps loginSteps;
    public ProductPage productPage;
    public HomePage homePage;
    public LoginAndRegistrationPage loginAndRegistrationPage;
    public RegisterSteps registerSteps;
    public AccountPage accountPage;
    public ChangePasswordPage changePasswordPage;
    public EditProfilePage editProfilePage;
    public BasketPage basketPage;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method, Object[] parameters) {
        logger.info("Start test" + method.getName() + "with data: " + Arrays.asList(parameters));//show method name with used parameters - especially useful for data provider
    }

    @BeforeMethod(alwaysRun = true)
    public void initTest() {
        initBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initPage();
    }

    public void initBrowser() {
        if (System.getProperty("browser") != null) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver( );
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        } else {
            try {
                /*ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x800");*/
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } catch (Exception e) {
            }
        }
    }

    public void initPage() {
        loginSteps = new LoginSteps(driver);
        productPage = new ProductPage(driver);
        loginAndRegistrationPage = new LoginAndRegistrationPage(driver);
        registerSteps = new RegisterSteps(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        editProfilePage = new EditProfilePage(driver);
        basketPage = new BasketPage(driver);
    }


    @AfterMethod()
    public void closeDriver(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Test result: PASSED");
        } else {
            logger.error("Test result: FAILED" + "\n" + new BasePage(driver).takeScreenshot());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
