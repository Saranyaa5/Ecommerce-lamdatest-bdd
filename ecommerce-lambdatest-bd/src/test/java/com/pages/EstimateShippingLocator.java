package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateShippingLocator {
    @FindBy(xpath = "//div[@id=\"collapse-shipping\"]/preceding-sibling::h5")
    public WebElement estimateShipping;  // Renamed to 'estimateShipping'

    @FindBy(xpath = "//button[contains(@id, 'button-quote')]")
    public WebElement getQuotes;

    @FindBy(xpath = "//div[contains(@class, 'form-check')]/label/input")
    public WebElement flatShippingRadioButton;

    @FindBy(xpath = "//button[contains(@id, 'button-shipping')]")
    public WebElement applyShippingButton;

    @FindBy(xpath = "//div[contains(@class, 'alert') and contains(@class, 'alert-success')]")
    public WebElement estimateShippingSuccessMsg;  // Renamed to 'estimateShippingSuccessMsg'
}
