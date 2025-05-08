package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageLocator {
    @FindBy(xpath = "//a[@class='icon-left both nav-link dropdown-toggle' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account']")
    public WebElement myAccount; 
    
    @FindBy(xpath = "//a[@class='icon-left both dropdown-item' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']")
    public WebElement register;
  
    @FindBy(xpath = "//form/preceding::h1[1]")
    public WebElement registerPageTitle;
    
    @FindBy(xpath = "//label[contains(text(),'First Name')]/following::input[1]")
    public WebElement firstName;
   
    @FindBy(xpath = "//label[contains(text(),'Last Name')]/following::input[1]")
    public WebElement lastName;
    
    @FindBy(css="fieldset:first-of-type div > label[for='input-email'] ~ div > input")
    public WebElement registerEmail;
    
    @FindBy(xpath ="//label[contains(text(), 'Telephone')]/ancestor::div[contains(@class, 'form-group')]//input")
    public WebElement telephone;
    
    @FindBy(css="fieldset:nth-of-type(2)>div >div>input")
    public WebElement password;
    
    @FindBy(css="fieldset:nth-of-type(2)>div:nth-of-type(2) >div>input")
    public WebElement cofirmpass;
    
    @FindBy(css="fieldset legend:contains('Newsletter') ~ div input[value='1']")
    public WebElement newsRadioYes;
    
    @FindBy(css="fieldset legend:contains('Newsletter') ~ div input[value='0']")
    public WebElement newsRadioNo;
    
    @FindBy(xpath = "//div[contains(@id,'content')]/form/div/div/div/label")
    public WebElement policyCheckBox;
    
    @FindBy(xpath = "//input[@type='submit' and @value='Continue']")
    public WebElement regiterSubmitButton;
    
    @FindBy(xpath = "//div[@id='content']//h1[contains(@class, 'page-title')]")
    public WebElement registrationSuccessMsg;
    
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement existingEmailError;
    
    @FindBy(xpath = "//div[@class='col-sm-10']//div[@class='text-danger'][1]")
    public WebElement emptyFirstNameError;
    
    @FindBy(xpath = "//div[@id='content']/form/fieldset[2]/div[1]/div/div")
    public WebElement emptyPasswordError;
    
    @FindBy(xpath = "//div[@id='content']/form/fieldset[2]/div[2]/div/div")
    public WebElement passwordMisMathError;
    
    @FindBy(xpath = "//div[@id='account-register']/div[1]")
    public WebElement uncheckedError;
}