package com.telran.oscar.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu extends Base{

    public SideMenu(WebDriver driver, String label) {
        super(driver, label);
    }

    public static final String SIDE_MENU_ELEMENTS_XPATH = "//*[contains(@class, 'dropdown-menu')]//a[contains(text(), '%s')]";

    public void clickOnSideMenuElement() {
        driver.findElement(By.xpath(String.format(SIDE_MENU_ELEMENTS_XPATH, label))).click();
    }

    public String getSideMenuElementName() {
        return driver.findElement(By.xpath(String.format(SIDE_MENU_ELEMENTS_XPATH, label))).getText();
    }
}
