//package com.actions;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.pages.LoginPageLocator;
//import com.pages.UserAccountLocator;
//import com.utilities.HelperClass;
//
//
//public class UserAccountAction {
//
//    WebDriver driver = HelperClass.getDriver();
//    UserAccountLocator userAccountLocator;
//    LoginPageLocator loginPageLocator;
//    WebDriverWait wait;
//
//    public UserAccountAction() {
//        userAccountLocator = new UserAccountLocator();
//        PageFactory.initElements(driver, userAccountLocator);
//        loginPageLocator = new LoginPageLocator();
//        PageFactory.initElements(HelperClass.getDriver(), loginPageLocator);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//    }
//
//    public void EditInformation() {
//    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//         wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditInfo)).click();
//    }
//    public void changePassword() {
//        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ChangePass)).click();
//    }
//
//    public void ModifyWishlist() {
//    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//         wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyWishlist)).click();
//    }
//    public void ClickNewsLetter() {
//    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//         wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.clickNewsLetter)).click();
//    }
//    public void UpdateTelephoneNumber() {
//        userAccountLocator.Telephone.clear();
//        userAccountLocator.Telephone.sendKeys("8825428889");
//    }
//
//    public void EditContinue() {
//        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditContinue)).click();
//    }
//
//    public String Edited() {
//        return userAccountLocator.Edited.getText();
//    }
//
//
//
//    public String PasswordChanged() {
//        return userAccountLocator.PassChanged.getText();
//    }
//
//    public void EntersnewPass() {
//    	 userAccountLocator.Password.sendKeys("KIOT"); 
//         userAccountLocator.ConfirmPassword.sendKeys("KIOT"); 
//    }
// 
//
//
//    public void ClickPassContinue() {
//        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.PassContinue)).click();
//    }
//
//
//    
//
//    public void RemoveFromWishList() {
//        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//        List<WebElement> removeButtons = HelperClass.getDriver().findElements(By.cssSelector("a.btn.btn-light.btn-sm.text-danger"));
//
//        if (!removeButtons.isEmpty()) {
//            WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0)));
//            removeButton.click();
//            System.out.println("Product removed from wishlist.");
//        } else {
//            System.out.println("No product in Wishlist to remove.");
//        }
//    }
//
//
//    public String ModifiedWishList() {
//        return userAccountLocator.ModifiedWishList.getText();
//    }
//
//   
//
//    public void selectNewsletterOption(String action) {
//        wait.until(ExpectedConditions.visibilityOf(userAccountLocator.subscribeRadio));
//        if (action.equalsIgnoreCase("subscribe")) {
//            userAccountLocator.subscribeRadio.click();
//        } else if (action.equalsIgnoreCase("unsubscribe")) {
//            userAccountLocator.unsubscribeRadio.click();
//        }
//    }
//
//    public void clickNewsLetterContinue() {
//        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.NewsLettercontinue)).click();
//    }
//
//    public String NewsLetterUpdated() {
//        return userAccountLocator.newsLetterUpdated.getText();
//    }
//
//	public void EnterCredentialsForMyAccount() {
//	
//
//		loginPageLocator.emailId.sendKeys("2k21eee40@kiot.ac.in");
//		loginPageLocator.password.sendKeys("KIOT"); 
//		
//	}
//}

package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPageLocator;
import com.pages.UserAccountLocator;
import com.utilities.HelperClass;

public class UserAccountAction {

    WebDriver driver = HelperClass.getDriver();
    UserAccountLocator userAccountLocator;
    LoginPageLocator loginPageLocator;
    WebDriverWait wait;

    public UserAccountAction() {
        userAccountLocator = new UserAccountLocator();
        PageFactory.initElements(driver, userAccountLocator);
        loginPageLocator = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void EditInformation() {
        WebElement editInfo = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditInfo));
        editInfo.click();
    }

    public void changePassword() {
        WebElement changePass = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ChangePass));
        changePass.click();
    }

    public void ModifyWishlist() {
        WebElement modifyWishlist = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyWishlist));
        modifyWishlist.click();
    }

    public void ClickNewsLetter() {
        WebElement clickNewsLetter = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.clickNewsLetter));
        clickNewsLetter.click();
    }

    public void UpdateTelephoneNumber() {
        WebElement telephone = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.Telephone));
        telephone.clear();
        telephone.sendKeys("8825428889");
    }

    public void EditContinue() {
        WebElement editContinue = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditContinue));
        editContinue.click();
    }

    public String Edited() {
        WebElement edited = wait.until(ExpectedConditions.visibilityOf(userAccountLocator.Edited));
        return edited.getText();
    }

    public String PasswordChanged() {
        WebElement passChanged = wait.until(ExpectedConditions.visibilityOf(userAccountLocator.PassChanged));
        return passChanged.getText();
    }

    public void EntersnewPass() {
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.Password));
        password.sendKeys("KIOT");
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ConfirmPassword));
        confirmPassword.sendKeys("KIOT");
    }

    public void ClickPassContinue() {
        WebElement passContinue = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.PassContinue));
        passContinue.click();
    }

    public void RemoveFromWishList() {
        List<WebElement> removeButtons = driver.findElements(By.cssSelector("a.btn.btn-light.btn-sm.text-danger"));
        if (!removeButtons.isEmpty()) {
            WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0)));
            removeButton.click();
            System.out.println("Product removed from wishlist.");
        } else {
            System.out.println("No product in Wishlist to remove.");
        }
    }

    public String ModifiedWishList() {
        WebElement modifiedWishList = wait.until(ExpectedConditions.visibilityOf(userAccountLocator.ModifiedWishList));
        return modifiedWishList.getText();
    }

    public void selectNewsletterOption(String action) {
        WebElement subscribeRadio = wait.until(ExpectedConditions.visibilityOf(userAccountLocator.subscribeRadio));
        if (action.equalsIgnoreCase("subscribe")) {
            subscribeRadio.click();
        } else if (action.equalsIgnoreCase("unsubscribe")) {
            WebElement unsubscribeRadio = wait.until(ExpectedConditions.visibilityOf(userAccountLocator.unsubscribeRadio));
            unsubscribeRadio.click();
        }
    }

    public void clickNewsLetterContinue() {
        WebElement newsLetterContinue = wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.NewsLettercontinue));
        newsLetterContinue.click();
    }

    public String NewsLetterUpdated() {
        WebElement newsLetterUpdated = wait.until(ExpectedConditions.visibilityOf(userAccountLocator.newsLetterUpdated));
        return newsLetterUpdated.getText();
    }

    public void EnterCredentialsForMyAccount() {
        WebElement emailId = wait.until(ExpectedConditions.elementToBeClickable(loginPageLocator.emailId));
        emailId.sendKeys("2k21eee40@kiot.ac.in");
        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(loginPageLocator.password));
        password.sendKeys("KIOT");
    }
}