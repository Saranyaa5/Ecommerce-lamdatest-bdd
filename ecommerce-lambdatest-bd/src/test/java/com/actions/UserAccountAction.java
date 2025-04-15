package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.UserAccountLocator;
import com.utilities.HelperClass;

public class UserAccountAction {

    WebDriver driver = HelperClass.getDriver();
    UserAccountLocator userAccountLocator;
    WebDriverWait wait;

    public UserAccountAction() {
        userAccountLocator = new UserAccountLocator();
        PageFactory.initElements(driver, userAccountLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void EditInformation() {
        WebElement EditInfoLink = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditInfo));
        EditInfoLink.click();
    }

    public void UpdateTelephoneNumber() {
        userAccountLocator.Telephone.clear();
        userAccountLocator.Telephone.sendKeys("8825428889");
    }

    public void Continue() {
        userAccountLocator.EditContinue.click();
    }

    public String Edited() {
        return userAccountLocator.Edited.getText();
    }

    public void changePassword() {
        WebElement passwordLink = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ChangePass));
        passwordLink.click();
    }

    public String PasswordChanged() {
        return userAccountLocator.PassChanged.getText();
    }

    public void EntersnewPass() {
        userAccountLocator.Password.sendKeys("KIOT");
        userAccountLocator.ConfirmPassword.sendKeys("KIOT");
    }

    public void ClickPassContinue() {
        userAccountLocator.PassContinue.click();
    }

    public void ModifyWishlist() {
        WebElement wishlistLink = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyWishlist));
        wishlistLink.click();
    }

    public void RemoveFromWishList() {
    	try {
        userAccountLocator.RemoveFromWishlist.click();
    	}
    	catch(Exception e) {
    		System.out.println("No product in Wishlist");
    	}
    }

    public String ModifiedWishList() {
        return userAccountLocator.ModifiedWishList.getText();
    }

    public void ClickNewsLetter() {
        WebElement newsletterLink = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.clickNewsLetter));
        newsletterLink.click();
    }

    public void selectNewsletterOption(String action) {
        wait.until(ExpectedConditions.visibilityOf(userAccountLocator.subscribeRadio));
        if (action.equalsIgnoreCase("subscribe")) {
            userAccountLocator.subscribeRadio.click();
        } else if (action.equalsIgnoreCase("unsubscribe")) {
            userAccountLocator.unsubscribeRadio.click();
        }
    }

    public void clickNewsLetterContinue() {
        userAccountLocator.NewsLettercontinue.click();
    }

    public String NewsLetterUpdated() {
        return userAccountLocator.newsLetterUpdated.getText();
    }
}