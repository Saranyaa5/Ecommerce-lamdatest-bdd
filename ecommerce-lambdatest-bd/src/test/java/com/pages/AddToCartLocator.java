package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartLocator {

    @FindBy(xpath = "//a[text()=' Shop by Category']")
    public WebElement Category;

    @FindBy(xpath = "//div[contains(@class, 'info')]//span[contains(@class, 'title') and normalize-space(text())='Phone, Tablets & Ipod']")
    public WebElement phonesCategory;

    @FindBy(xpath = "//*[@id='mz-product-grid-image-36-212408']/div/div[1]/img")
    public WebElement IpodNano;

    @FindBy(xpath = "(//button[text()='Add to Cart'])[2]")
    public WebElement addToCartButton;


    @FindBy(xpath = "//*[@id='notification-box-top']/div/div[2]/div[1]/p")
    public WebElement successMsg;

    @FindBy(xpath = "(//a[@href='#cart-total-drawer' and contains(@class,'cart') and .//span[contains(@class,'cart-item-total')]])[1]")
    public WebElement shoppingCartIcon;

    @FindBy(xpath = "//a[@role='button' and contains(@class,'btn-block') and normalize-space()='Edit cart']")
    public WebElement editCart;

    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[4]/div/div/button[2]")
    public WebElement remove;

    @FindBy(xpath = "//*[@id='content']/p")
    public WebElement noItem;

    @FindBy(xpath = "(//button[@aria-label='Increase quantity'])[2]")
    public WebElement quantity;

    @FindBy(xpath = "//*[@id='notification-box-top']/div/div[1]/span")
    public WebElement noOfItems;

    @FindBy(xpath = "//a[contains(@href, 'product_id=42') and contains(text(), 'Apple Cinema')]")
    public WebElement AppleCinema;

    @FindBy(xpath = "(//select[starts-with(@id,'input-option231')]/following-sibling::div[@class='text-danger' and normalize-space()='Size required!'])[1]")
    public WebElement SizeReq;
}