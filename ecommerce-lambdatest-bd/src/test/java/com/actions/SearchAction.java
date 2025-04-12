package com.actions;

import com.pages.SearchLocator;
import com.utilities.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchAction {

    WebDriver driver;
    SearchLocator searchLocator;

    public SearchAction() {
        this.driver = HelperClass.getDriver();
        this.searchLocator = new SearchLocator();
        PageFactory.initElements(driver, searchLocator);
    }

    public void searchProduct(String product) {
        searchLocator.searchbox.clear();
        searchLocator.searchbox.sendKeys(product);
        searchLocator.searchbutton.click();
    }

    public String getSearchResultText(String expected) {
        try {
            if (expected.equalsIgnoreCase("MacBook") && searchLocator.macbook.isDisplayed()) {
                return searchLocator.macbook.getText();
            } else if (expected.equalsIgnoreCase("iPhone") && searchLocator.iphone.isDisplayed()) {
                return searchLocator.iphone.getText();
            } else if (expected.equalsIgnoreCase("iMac") && searchLocator.imac.isDisplayed()) {
                return searchLocator.imac.getText();
            } else if (expected.equalsIgnoreCase("HTC Touch HD") && searchLocator.htc.isDisplayed()) {
                return searchLocator.htc.getText();
            } else if (expected.contains("There is no product that matches the search criteria.") && searchLocator.errormessage.isDisplayed()) {
                return searchLocator.errormessage.getText();
            }
        } catch (Exception e) {
            return "No element found";
        }
        return "No element matched";
    }
}
