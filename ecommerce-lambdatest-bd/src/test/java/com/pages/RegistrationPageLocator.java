package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageLocator {
    @FindBy(xpath="//a[@class='icon-left both nav-link dropdown-toggle' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account']")
    public WebElement MyAccount; 
    
    @FindBy(xpath="//a[@class='icon-left both dropdown-item' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")
    public WebElement Register;
    
    @FindBy(xpath="//div[@id='content']//h1")
    public WebElement RegisterPageTitle;
    
    @FindBy(id="input-firstname")
    public WebElement FirstName;
    @FindBy(id="input-lastname")
    public WebElement LastName;
    @FindBy(id="input-email")
    public WebElement RegisterEmail;
    @FindBy(id="input-telephone")
    public WebElement Telephone;
    
    @FindBy(id="input-password")
    public WebElement password;
    
    @FindBy(id="input-confirm")
    public WebElement cofirmpass;
    
    @FindBy(id="input-newsletter-yes")
    public WebElement NewsRadioYes;
    @FindBy(id="input-newsletter-no")
    public WebElement NewsRadioNo;
    
    @FindBy(xpath="//*[@id='content']/form/div/div/div/label")
    public WebElement PolicyCheckBox;
    
    @FindBy(xpath="//input[@type='submit' and @value='Continue']")
    public WebElement RegiterSubmitButton;
    
    @FindBy(xpath="//*[@id='content']//h1")
    public WebElement RegistrationSuccessMsg;
    
    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
   public WebElement ExistingEmailError;
    @FindBy(xpath="//div[@class='col-sm-10']//div[@class='text-danger'][1]")
    public WebElement EmptyFirstNameError;
    
  
    @FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
    public WebElement EmptyPasswordError;
    
    @FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")
    public WebElement PasswordMisMathError;
    

    @FindBy(xpath="//*[@id=\"account-register\"]/div[1]")
    public WebElement UncheckedError;
    
}