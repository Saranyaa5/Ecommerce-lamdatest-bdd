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
        PageFactory.initElements(driver, loginPageLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Edit personal information
    public void EditInformation() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditInfo)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Edit Info: " + e.getMessage());
        }
    }

    // Change account password
    public void changePassword() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ChangePass)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Change Password: " + e.getMessage());
        }
    }

    // Modify wishlist
    public void ModifyWishlist() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyWishlist)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Modify Wishlist: " + e.getMessage());
        }
    }
// Navigate to newsletter preferences
    public void ClickNewsLetter() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.clickNewsLetter)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Newsletter: " + e.getMessage());
        }
    }
// Update telephone number
    public void UpdateTelephoneNumber() {
        try {
            userAccountLocator.Telephone.clear();
            userAccountLocator.Telephone.sendKeys("8825428889");
        } catch (Exception e) {
            System.out.println("Error updating telephone: " + e.getMessage());
    }
    }
 // Save edited personal information
    public void EditContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditContinue)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Edit Continue: " + e.getMessage());
        } }

 public String Edited() {
        return userAccountLocator.Edited.getText();
    }

    public String PasswordChanged() {
        return userAccountLocator.PassChanged.getText();
    }

    // Enter new password and confirm
    public void EntersnewPass() {
        try {
            userAccountLocator.Password.sendKeys("KIOT");
            userAccountLocator.ConfirmPassword.sendKeys("KIOT");
        } catch (Exception e) {
            System.out.println("Error entering new password: " + e.getMessage());
        }
    }

    public void ClickPassContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.PassContinue)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Password Continue: " + e.getMessage());
        }
    }

    // Remove a product from wishlist
    public void RemoveFromWishList() {
        try {
            List<WebElement> removeButtons = driver.findElements(By.cssSelector("a.btn.btn-light.btn-sm.text-danger"));
            if (!removeButtons.isEmpty()) {
                WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0)));
                removeButton.click();
                System.out.println("Product removed from wishlist.");
            } else {
                System.out.println("No product in Wishlist to remove.");
            }
        } catch (Exception e) {
            System.out.println("Error removing from wishlist: " + e.getMessage());
        }
    }

    public String ModifiedWishList() {
        return userAccountLocator.ModifiedWishList.getText();
    }

    // Subscribe or unsubscribe newsletter
    public void selectNewsletterOption(String action) {
        try {
            wait.until(ExpectedConditions.visibilityOf(userAccountLocator.subscribeRadio));
            if (action.equalsIgnoreCase("subscribe")) {
                userAccountLocator.subscribeRadio.click();
            } else if (action.equalsIgnoreCase("unsubscribe")) {
                userAccountLocator.unsubscribeRadio.click();
            }
        } catch (Exception e) {
            System.out.println("Error selecting newsletter option: " + e.getMessage());
        }
            }

    public void clickNewsLetterContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.NewsLettercontinue)).click();
         } catch (Exception e) {
            System.out.println("Error clicking Newsletter Continue: " + e.getMessage());
         }
       }
 public String NewsLetterUpdated() {
        return userAccountLocator.newsLetterUpdated.getText();
    }

    public void EnterCredentialsForMyAccount() {
        try {
            loginPageLocator.emailId.sendKeys("2k21eee40@kiot.ac.in");
            loginPageLocator.password.sendKeys("KIOT");
        } catch (Exception e) {
            System.out.println("Error entering login credentials: " + e.getMessage());
        }
    }

    public String PasswordEmpty() {
        return userAccountLocator.PasswordEmpty.getText();
    }

    public void ClickModifyAddress() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyAddress)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Modify Address: " + e.getMessage());
        }
    }

    public void clickNewAddress() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.newAddress)).click();
        } catch (Exception e) {
            System.out.println("Error clicking New Address: " + e.getMessage());
        }
    }

    public void ModifyAddressContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.modifyAddressContinue)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Modify Address Continue: " + e.getMessage());
        }
    }

    public String NewAddressCreated() {
        return userAccountLocator.newAddressCreated.getText();
    }

    // Fill in new address details
    public void enterAddressDetails(String firstName, String lastName, String address, String city, String postcode) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            userAccountLocator.getFirstNameField.sendKeys(firstName);
            userAccountLocator.getLastNameField.sendKeys(lastName);
            userAccountLocator.getAddressField.sendKeys(address);
            userAccountLocator.getCityField.sendKeys(city);
            userAccountLocator.getPostcodeField.sendKeys(postcode);

            // Click country dropdown and select United States
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.countrySelect)).click();
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.unitedstates)).click();

            // Wait until state dropdown is visible and clickable
            wait.until(ExpectedConditions.visibilityOf(userAccountLocator.state));
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.state)).click();

            // Wait until Abeerdan is visible and clickable
            wait.until(ExpectedConditions.visibilityOf(userAccountLocator.Abeerdan));
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.Abeerdan)).click();

        } catch (Exception e) {
            System.out.println("Error entering address details: " + e.getMessage());
        }
    }

}