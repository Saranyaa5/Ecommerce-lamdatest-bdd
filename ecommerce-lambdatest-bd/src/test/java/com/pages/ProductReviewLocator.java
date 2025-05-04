package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.HelperClass;

public class ProductReviewLocator {

    public ProductReviewLocator() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    @FindBy(linkText = "Write a review")
    public WebElement writeReviewLink;

    @FindBy(xpath = "//textarea[@id='input-review']/parent::div/preceding-sibling::div[1]/input")
    public WebElement nameInput;

    @FindBy(xpath = "//textarea[@id='input-review']")
    public WebElement reviewTextarea;

    @FindBy(xpath = "(//input[@name='rating']/following-sibling::label)[5]")
    public WebElement rating1;

    @FindBy(xpath = "(//input[@name='rating']/following-sibling::label)[4]")
    public WebElement rating2;

    @FindBy(xpath = "(//input[@name='rating']/following-sibling::label)[3]")
    public WebElement rating3;

    @FindBy(xpath = "(//input[@name='rating']/following-sibling::label)[2]")
    public WebElement rating4;

    @FindBy(xpath = "(//input[@name='rating']/following-sibling::label)[1]")
    public WebElement rating5;

    @FindBy(xpath = "//div[@class='float-right']/ancestor::div[@class='buttons clearfix']//button")
    public WebElement continueButton;

    @FindBy(css = ".alert-success")
    public WebElement successMessage;

    @FindBy(css = ".alert-danger") 
    public WebElement ErrorMessage;
    
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//i[contains(@class, 'fa-exclamation-circle')]/following-sibling::text()[contains(., 'Review Text must be between 25 and 1000 characters!')]") 
    public WebElement ErrorMessage1;

}