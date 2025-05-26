package com.actions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.MegaMenuLocator;
import com.utilities.HelperClass;
import org.openqa.selenium.interactions.Actions;

public class MegaMenuAction {
    WebDriver driver;
    MegaMenuLocator megaMenu;
    WebDriverWait wait;

    public MegaMenuAction() {
        this.driver = HelperClass.getDriver();
        this.megaMenu = new MegaMenuLocator();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, megaMenu);
    }

    public void hoverOnMegaMenu() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(megaMenu.megamenu));
        actions.moveToElement(megaMenu.megamenu).perform();

        wait.until(ExpectedConditions.visibilityOf(megaMenu.apple));
    }


    public void clickOptions() {
        wait.until(ExpectedConditions.elementToBeClickable(megaMenu.apple)).click();
    }
    
    public String appleProductText(){
    	return wait.until(ExpectedConditions.visibilityOf(megaMenu.appleHeading)).getText();
    }

}
