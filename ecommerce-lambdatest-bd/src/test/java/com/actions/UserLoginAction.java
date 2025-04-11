package com.actions;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.LoginPageLocator;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

public class UserLoginAction {
    LoginPageLocator loginPageLocator=null;
    WebDriverWait wait;
    String stremail,strpassword;

    public static final String UserCredentialsPath = "C:\\Users\\admi\\git\\Ecommerce-lamdatest-bdd\\ecommerce-lambdatest-bd\\src\\test\\resources\\com\\features\\Cofiguration.properties";
    public UserLoginAction() {
    	ConfigReader.loadProperties(UserCredentialsPath);
    	this.stremail = ConfigReader.getProperty("email");
    	this.strpassword = ConfigReader.getProperty("password");
        this.loginPageLocator = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocator);
        
    }

    public void clickMyAccounts() {
       loginPageLocator.myAccount.click();
    }

    public void clickLoginMenu() {
//        wait.until(ExpectedConditions.elementToBeClickable(lp.login)).click();
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
    	System.out.println((loginPageLocator.titleMyAccount).getText());
        return loginPageLocator.titleMyAccount.isDisplayed();
    }

    public String getWarningMessage() {
        return loginPageLocator.warningMessage.getText();
    }
}