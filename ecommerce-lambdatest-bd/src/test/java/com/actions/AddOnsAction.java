package com.actions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AddOnsLocator;
import com.utilities.HelperClass;

public class AddOnsAction {
    WebDriver driver;
    AddOnsLocator addon;
    WebDriverWait wait;

    public AddOnsAction() {
        this.driver = HelperClass.getDriver();
        this.addon = new AddOnsLocator();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, addon);
    }

    public void clickAddons() {
        wait.until(ExpectedConditions.elementToBeClickable(addon.addons)).click();
    }

    public void clickDesignMenu() {
        addon.addons.click();

        wait.until(ExpectedConditions.visibilityOf(addon.design));
        wait.until(ExpectedConditions.elementToBeClickable(addon.design)).click();
    }


    public String getAlertText() {
        return wait.until(ExpectedConditions.visibilityOf(addon.alerttext)).getText();
    }
}