package com.actions;

import com.pages.SearchLocator;
import com.utilities.HelperClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchAction {
    WebDriver driver;
    SearchLocator searchLocator;

    public SearchAction() {
        this.driver = HelperClass.getDriver();
        this.searchLocator = new SearchLocator();
        PageFactory.initElements(driver, searchLocator);
    }

    public void enterSearchTerm(String product) {
        if (searchLocator.searchbox.isDisplayed() && searchLocator.searchbox.isEnabled()) {
            searchLocator.searchbox.clear();
            searchLocator.searchbox.sendKeys(product.trim());
        }
    }

    public void clickSearchButton() {
        if (searchLocator.searchbutton.isDisplayed() && searchLocator.searchbutton.isEnabled()) {
            searchLocator.searchbutton.click();
        }
    }

    public boolean areProductsDisplayed() {
        return searchLocator.productResult != null && searchLocator.productResult.isDisplayed();
    }

    public boolean isNoProductMessageDisplayed() {
        return searchLocator.noProductMessage != null && searchLocator.noProductMessage.isDisplayed();
    }

    public String getNoProductMessageText() {
        return searchLocator.noProductMessage.getText();
    }

    public void enterMinimumValue(String min) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", searchLocator.mindragger);

            if (searchLocator.mindragger.isDisplayed() && searchLocator.mindragger.isEnabled()) {
                searchLocator.mindragger.clear();
                searchLocator.mindragger.sendKeys(min);
            }
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + min + "';", searchLocator.mindragger);
        }
    }

    public void enterMaximumValue(String max) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", searchLocator.maxdragger);

            if (searchLocator.maxdragger.isDisplayed() && searchLocator.maxdragger.isEnabled()) {
                searchLocator.maxdragger.clear();
                searchLocator.maxdragger.sendKeys(max);
            }
        } catch (ElementNotInteractableException e) {
            System.out.println("Fallback JS for Max: element not interactable");
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + max + "';", searchLocator.maxdragger);
        }
    }

    public boolean areAllPricesWithinRange(int min, int max) {
        try {
            List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='price-new']"));
            for (WebElement priceElement : priceElements) {
                String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
                if (!priceText.isEmpty()) {
                    double price = Double.parseDouble(priceText);
                    if (price < min || price > max) {
                        System.out.println("❌ Out-of-range price: " + price);
                        return false;
                    }
                }
            }
            return true;
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element during price check");
            return false;
        }
    }

    public void dragSliderHandles(int leftOffset, int rightOffset) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(searchLocator.leftSliderHandle)
                .moveByOffset(leftOffset, 0)
                .release().perform();

        actions.clickAndHold(searchLocator.rightSliderHandle)
                .moveByOffset(rightOffset, 0)
                .release().perform();
    }

    public void clickShopByCategory() {
        if (searchLocator.shopbycategory.isDisplayed() && searchLocator.shopbycategory.isEnabled()) {
            searchLocator.shopbycategory.click();
        }
    }

    public void clickCategory() {
        if (searchLocator.components.isDisplayed() && searchLocator.components.isEnabled()) {
            searchLocator.components.click();
        }
    }

    public void selectProductCountFromDropdown(String value) {
        if (searchLocator.select.isDisplayed()) {
            Select dropdown = new Select(searchLocator.select);
            dropdown.selectByVisibleText(value);
        }
    }

    public int getSelectedDropdownValue() {
        Select dropdown = new Select(searchLocator.select);
        String selectedText = dropdown.getFirstSelectedOption().getText().trim();
        return Integer.parseInt(selectedText);
    }

    public int getDisplayedProductCount() {
        List<WebElement> list = searchLocator.productList;
        System.out.print(list.size());
        return list.size();
    }

    public boolean isProductCountMatchingDropdown() {
        return getSelectedDropdownValue() == getDisplayedProductCount();
    }

    public void hoverOverFirstProduct() {
        try {
            WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='carousel-item active']//img)[1]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).perform();

            WebElement quickViewButton = driver.findElement(By.xpath("//button[@class='btn btn-quick-view quick-view-41']/i"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", quickViewButton);
        } catch (Exception e) {
            System.out.println("❗ Hover/Quick View failed: " + e.getMessage());
        }
    }

    public boolean isQuickViewDisplayed() {
        return searchLocator.textQuickView != null && searchLocator.textQuickView.isDisplayed();
    }

    public void clickAddToCartAndHandlePopup() {
        try {
            if (searchLocator.addToCartButton.isDisplayed() && searchLocator.addToCartButton.isEnabled()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchLocator.addToCartButton);
            }

            if (searchLocator.popupMessage.isDisplayed()) {
                System.out.println("Popup: " + searchLocator.popupMessage.getText());
            }

            if (searchLocator.checkoutButton.isDisplayed()) {
                searchLocator.checkoutButton.click();
            }

        } catch (Exception e) {
            System.out.println("❌ Add to Cart error: " + e.getMessage());
        }
    }

    public boolean isCheckoutPageDisplayed() {
        return searchLocator.textShoppingCart != null && searchLocator.textShoppingCart.isDisplayed();
    }
}
