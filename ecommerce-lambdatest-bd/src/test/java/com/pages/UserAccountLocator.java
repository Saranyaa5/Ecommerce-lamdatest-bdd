package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountLocator {

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/div[1]/a")
    public WebElement editInfo;  // Renamed to 'editInfo'

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/div[2]/a")
    public WebElement changePass;  // Renamed to 'changePass'

    @FindBy(xpath="//*[@id='content']/div[1]/div/div/div[4]/a")
    public WebElement modifyWishlist;  // Renamed to 'modifyWishlist'

    @FindBy(xpath="//*[@id='content']/div[1]/div/div/div[5]/a")
    public WebElement clickNewsLetter;  

    @FindBy(xpath="//small[@id='input-telephone-help']/ancestor::div/input")
    public WebElement telephone;  // Renamed to 'telephone'

    @FindBy(xpath="//div[@class='float-left']/following-sibling::div/input")
    public WebElement editContinue;  // Renamed to 'editContinue'

    @FindBy(xpath="//*[@id='account-account']/div[1]")
    public WebElement edited;  // Renamed to 'edited'

    @FindBy(xpath="//*[@id='input-password']")
    public WebElement password;  // Renamed to 'password'

    @FindBy(xpath="//*[@id='input-confirm']")
    public WebElement confirmPassword;  // Renamed to 'confirmPassword'

    @FindBy(xpath="//*[@id='content']/form/div[3]/div[2]/input")
    public WebElement passContinue;  // Renamed to 'passContinue'

    @FindBy(xpath="//*[@id='account-account']/div[1]")
    public WebElement passChanged;  // Renamed to 'passChanged'

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")
    public WebElement removeFromWishlist;  // Renamed to 'removeFromWishlist'

    @FindBy(xpath="//*[@id='account-wishlist']/div[1]")
    public WebElement modifiedWishList;  // Renamed to 'modifiedWishList'

    @FindBy(xpath="//*[@id='content']/form/fieldset/div/div/div[1]/label")
    public WebElement subscribeRadio;  

    @FindBy(xpath="//*[@id='content']/form/fieldset/div/div/div[2]/label")
    public WebElement unsubscribeRadio;  

    @FindBy(xpath="//input[@value='Continue']")
    public WebElement newsletterContinue;  // Renamed to 'newsletterContinue'

    @FindBy(xpath="//*[@id='account-account']/div[1]")
    public WebElement newsLetterUpdated;  

    @FindBy(xpath="//*[@id=\"content\"]/form/div[1]/div/div")
    public WebElement passwordEmpty;  // Renamed to 'passwordEmpty'

    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/div[3]/a")
    public WebElement modifyAddress;  // Renamed to 'modifyAddress'

    @FindBy(xpath="//*[@id=\"content\"]/div/div[2]/a")
    public WebElement newAddress;  

    @FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
    public WebElement modifyAddressContinue;  

    @FindBy(xpath="//*[@id=\"account-address\"]/div[1]")
    public WebElement newAddressCreated;  

    @FindBy(xpath="//*[@id=\"input-firstname\"]")
    public WebElement getFirstNameField;  

    @FindBy(xpath="//*[@id=\"input-lastname\"]")
    public WebElement getLastNameField;  

    @FindBy(xpath="//*[@id=\"input-address-1\"]")
    public WebElement getAddressField;  

    @FindBy(xpath="//*[@id=\"input-city\"]")
    public WebElement getCityField;  

    @FindBy(xpath="//*[@id=\"input-postcode\"]")
    public WebElement getPostcodeField;  

    @FindBy(xpath="//*[@id=\"input-country\"]")
    public WebElement countrySelect;  

    @FindBy(xpath="//*[@id=\"input-country\"]/option[240]")
    public WebElement unitedStates;  // Renamed to 'unitedStates'

    @FindBy(xpath="//*[@id=\"input-zone\"]")
    public WebElement state;  

    @FindBy(xpath="//*[@id=\"input-zone\"]/option[2]")
    public WebElement aberdeen;  // Renamed to 'aberdeen'

}
