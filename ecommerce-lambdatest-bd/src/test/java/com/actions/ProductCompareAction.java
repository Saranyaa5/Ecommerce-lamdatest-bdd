package com.actions;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pages.ProductCompareLocator;
import com.utilities.HelperClass;

public class ProductCompareAction {
    private ProductCompareLocator productCompareLocator;

    public ProductCompareAction() {
        this.productCompareLocator = new ProductCompareLocator();
        PageFactory.initElements(HelperClass.getDriver(), productCompareLocator);
    }

    private boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeToastIfVisible() { 
        try {
            if (isElementDisplayed(productCompareLocator.
            		toastHeader)) {
                if (isElementEnabled(productCompareLocator.toastCloseButton)) {
                    productCompareLocator.toastCloseButton.click();
                }
            }
        } catch (Exception e) {
            return;
        }
    }
//    public void closeToastIfVisible() {
//        try {
//           
//            WebDriverWait shortWait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(2));
//            WebElement toast = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".toast-header")));
//            
//            if (toast.isDisplayed()) {
//                WebElement closeButton = toast.findElement(By.cssSelector(".close"));
//                closeButton.click();
//              
//                shortWait.until(ExpectedConditions.invisibilityOf(toast));
//            }
//        } catch (TimeoutException | NoSuchElementException e) {
//            
//            return;
//        }
//    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public void clickProductCompare() {
        try {
            closeToastIfVisible();
            if (isElementDisplayed(productCompareLocator.productCompare1) && 
                isElementEnabled(productCompareLocator.productCompare1)) {
                scrollToElement(productCompareLocator.productCompare1);
                productCompareLocator.productCompare1.click();
            }
        } catch (Exception e) {
            if (isElementDisplayed(productCompareLocator.productCompare1)) {
                ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", 
                    productCompareLocator.productCompare1);
            }
        }
    }

    public void comparionButton() {
        closeToastIfVisible();
        if (isElementDisplayed(productCompareLocator.productCompare2) && 
            isElementEnabled(productCompareLocator.productCompare2)) {
            scrollToElement(productCompareLocator.productCompare2);
            productCompareLocator.productCompare2.click();
        }
    }

    public boolean getNoProductsToCompareMessage() {
        return isElementDisplayed(productCompareLocator.noProducts);
    }

    public void clickProduct() {
        closeToastIfVisible();
        if (isElementDisplayed(productCompareLocator.product1) && 
            isElementEnabled(productCompareLocator.product1)) {
            scrollToElement(productCompareLocator.product1);
            productCompareLocator.product1.click();
        }
    }
    
    public void clickComparionArrow() {
        closeToastIfVisible();
        if (isElementDisplayed(productCompareLocator.comparisionArrow) && 
            isElementEnabled(productCompareLocator.comparisionArrow)) {
            scrollToElement(productCompareLocator.comparisionArrow);
            try {
                productCompareLocator.comparisionArrow.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", 
                    productCompareLocator.comparisionArrow);
            }
        }
    }

    public String getProductDescription() {
        if (isElementDisplayed(productCompareLocator.comparisionProductDesc)) {
            return productCompareLocator.comparisionProductDesc.getText();
        }
        return "";
    }

    public boolean getNoProductsErrorMessage() {
        return isElementDisplayed(productCompareLocator.noProductsmatchError);
    }
}