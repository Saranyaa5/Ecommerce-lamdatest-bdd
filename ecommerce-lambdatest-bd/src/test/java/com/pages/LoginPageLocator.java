package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageLocator {
    @FindBy(xpath="(//div[@id='entry_217834']/descendant::a[@class='icon-left both nav-link dropdown-toggle'])[3]")
    public WebElement myAccount;
    
    @FindBy(xpath = "//a[@class='icon-left both nav-link dropdown-toggle']/following::a[@class='icon-left both dropdown-item active']")
    public WebElement login;
    
    @FindBy(xpath="(//div[@class='form-group']//descendant::input)[1]")
    public WebElement emailId;    
    
    @FindBy(xpath="(//div[@class='form-group']//following::input[1])[2]")
    public WebElement password;
    
    @FindBy(xpath="//input[@class='btn btn-primary']")
    public WebElement loginButton;

    @FindBy(xpath = "(//div/h2[@class='card-header h5'])[1]")
    public WebElement titleMyAccount;
    
    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    public WebElement warningMessage;

    @FindBy(xpath = "//div[@class='list-group mb-3']/a[13]/following-sibling::a")
    public WebElement logout;
    
    @FindBy(xpath = "//div[@id='content']/h1")
    public WebElement accountLogout;

}