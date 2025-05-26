package com.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.utilities.HelperClass;

import org.openqa.selenium.WebElement;
public class linkcheckerLocator {

    WebDriver driver;

    public linkcheckerLocator() {
        this.driver = HelperClass.getDriver();
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAllAnchorTags() {
        return driver.findElements(By.tagName("a"));
    }
}

