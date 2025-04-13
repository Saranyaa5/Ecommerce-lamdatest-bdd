package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
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

    public static final String UserCredentialsPath = "Configuration.properties";

    public UserLoginAction() {
        ConfigReader.loadProperties(UserCredentialsPath);
        
        this.stremail = ConfigReader.getProperty("email");
        this.strpassword = ConfigReader.getProperty("password");
        
        this.loginPageLocator = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocator);
        
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(HelperClass.TIMEOUT));
        
        actions=new Actions(HelperClass.getDriver());
    }

    public void clickMyAccounts() {
        loginPageLocator.myAccount.click();
//    	actions.moveToElement(loginPageLocator.myAccount).perform();
    }

    public void clickLoginMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageLocator.login)).click();
    }

    public void setEmail() {
        loginPageLocator.emailId.sendKeys(stremail);
    }

    public void setEmail2(String email) {
        loginPageLocator.emailId.sendKeys(email);
    }

    public void setPassword2(String pass) {
        loginPageLocator.password.sendKeys(pass);
    }

    public void setPassword() {
        loginPageLocator.password.sendKeys(strpassword);
    }

    public void clickLoginButton() {
        loginPageLocator.loginButton.click();
    }

    public boolean isMyAccountPageDisplayed() {
        return loginPageLocator.titleMyAccount.isDisplayed();
    }

    public String getWarningMessage() {
        return loginPageLocator.warningMessage.getText();
    }
    
    public void clickLogout() {
    	loginPageLocator.logout.click();
    }

    public String getAccountLogoutText() {
        return loginPageLocator.accountLogout.getText();
    }
}