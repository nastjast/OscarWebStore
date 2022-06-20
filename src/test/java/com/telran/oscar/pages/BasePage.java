package com.telran.oscar.pages;

import com.google.common.io.Files;
import com.telran.oscar.utils.Waiters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage {

    WebDriver driver;

    @FindBy(css = ".alertinner")
    WebElement successMsg;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void shouldHaveText(WebElement element, String text, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void openPage (String url) {
        driver.get(url);
    }

    public boolean isElementDisplayed(WebElement element) {
        Waiters.waitForElementLocated(driver, element, 10);
        return element.isDisplayed();
    }

    public String getSuccessMsg() {
        return successMsg.getText();
    }

    public String takeScreenshot() {

        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
