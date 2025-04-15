package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountLocator {

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/div[1]/a")
    public WebElement EditInfo;
    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/div[2]/a")
    public WebElement ChangePass;
    @FindBy(xpath="//*[@id='content']/div[1]/div/div/div[4]/a")
    public WebElement ModifyWishlist;
    @FindBy(xpath="//*[@id='content']/div[1]/div/div/div[5]/a")
    public WebElement clickNewsLetter;
    
    
    
    

    @FindBy(xpath="//*[@id='input-telephone']")
    public WebElement Telephone;

    @FindBy(xpath="//*[@id='content']/form/div/div[2]/input")
    public WebElement EditContinue;

    @FindBy(xpath="//*[@id='account-account']/div[1]")
    public WebElement Edited;

 

    @FindBy(xpath="//*[@id='input-password']")
    public WebElement Password;

    @FindBy(xpath="//*[@id='input-confirm']")
    public WebElement ConfirmPassword;

    @FindBy(xpath="//*[@id='content']/form/div[3]/div[2]/input")
    public WebElement PassContinue;

    @FindBy(xpath="//*[@id='account-account']/div[1]")
    public WebElement PassChanged;

   

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")
    public WebElement RemoveFromWishlist;

    @FindBy(xpath="//*[@id='account-wishlist']/div[1]")
    public WebElement ModifiedWishList;



    @FindBy(xpath="//*[@id='content']/form/fieldset/div/div/div[1]/label")
    public WebElement subscribeRadio;

    @FindBy(xpath="//*[@id='content']/form/fieldset/div/div/div[2]/label")
    public WebElement unsubscribeRadio;

    @FindBy(xpath="//input[@value='Continue']")
    public WebElement NewsLettercontinue;

    @FindBy(xpath="//*[@id='account-account']/div[1]")
    public WebElement newsLetterUpdated;
}