package com.actions;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.LoginPageLocator;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

public class UserLoginAction {
    LoginPageLocator loginPageLocator = null;
    WebDriverWait wait;
    String stremail, strpassword;
    Actions actions;

    public static final String USER_CREDENTIALS_PATH = "Configuration.properties";


    public UserLoginAction() {
        ConfigReader.loadProperties(USER_CREDENTIALS_PATH);
        
        this.stremail = ConfigReader.getProperty("email");
        this.strpassword = ConfigReader.getProperty("password");
        

        this.loginPageLocator = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocator);

        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(HelperClass.TIMEOUT));
        
        actions=new Actions(HelperClass.getDriver());

    }

    public void clickMyAccounts() {
        loginPageLocator.myAccount.click();
    }

    public void clickLoginMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageLocator.login)).click();
    }

    public void setEmail() {
        loginPageLocator.emailId.sendKeys(stremail);
    }

    public void setPassword() {
        loginPageLocator.password.sendKeys(strpassword);
    }
    
    public void setEmail2(String email) {
        loginPageLocator.emailId.sendKeys(email);
    }

    public void setPassword2(String pass) {
        loginPageLocator.password.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginPageLocator.loginButton.click();
    }

    public boolean isMyAccountPageDisplayed() {
        try {
            System.out.println(loginPageLocator.titleMyAccount.getText());
            return loginPageLocator.titleMyAccount.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element not found or stale: " + e.getMessage());
            return false;
        }
    }

    public boolean getWarningMessage() {
        try {
            return loginPageLocator.warningMessage.isDisplayed();
        } catch (Exception e) {
            System.out.println("Warning message element not found or stale: " + e.getMessage());
            return false;
        }
    }
    
    
    public void clickLogout() {
    	loginPageLocator.logout.click();
    }

    public String getAccountLogoutText() {
        return loginPageLocator.accountLogout.getText();
    }
}