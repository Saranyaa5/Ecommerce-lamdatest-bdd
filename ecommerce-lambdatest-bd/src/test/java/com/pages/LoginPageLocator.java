package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageLocator {

    @FindBy(xpath="//a[@class='icon-left both nav-link dropdown-toggle' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account']")
    public WebElement myAccount;
    
  @FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/a")
   // @FindBy(xpath="//a[@class='icon-left both dropdown-item active' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']")
    
    public WebElement login;
   
    @FindBy(xpath="//input[@id='input-email']")
    public WebElement emailId;
    
    @FindBy(xpath="//input[@id='input-password']")
    public WebElement password;
    
    @FindBy(xpath="//input[@class='btn btn-primary']")
    public WebElement loginButton;
    
//    @FindBy(xpath="//*[@id=\"account-login\"]/div[1]/text()")
//    public WebElement warning1;
//    
//    @FindBy(xpath="//*[@id=\"account-login\"]/div[1]/text()")
//    public WebElement warning2;

    @FindBy(xpath="//h2[text()='My Account']")
    public WebElement titleMyAccount;
    
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    public WebElement warningMessage;
}