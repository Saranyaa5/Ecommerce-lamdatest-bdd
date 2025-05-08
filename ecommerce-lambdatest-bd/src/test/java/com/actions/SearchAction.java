package com.actions;

import com.pages.SearchLocator;
import com.utilities.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchAction {
    WebDriver driver;
    SearchLocator searchLocator;
    WebDriverWait wait;

    public SearchAction() {
        this.driver = HelperClass.getDriver();
        this.searchLocator = new SearchLocator();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, searchLocator);
    }

    public void enterSearchTerm(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchLocator.searchbox));
        searchLocator.searchbox.sendKeys(Keys.CONTROL + "a");  
        searchLocator.searchbox.sendKeys(Keys.BACK_SPACE);   
        searchLocator.searchbox.sendKeys(product.trim());
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchLocator.searchbutton));
        searchLocator.searchbutton.click();
    }

    public boolean areProductsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchLocator.productResult));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoProductMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchLocator.noProductMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getNoProductMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(searchLocator.noProductMessage)).getText();
    }
    
    public void enterMinimumValue(String min) {
        wait.until(ExpectedConditions.visibilityOf(searchLocator.mindragger)).clear();
        searchLocator.mindragger.sendKeys(min);
    }

    public void enterMaximumValue(String max) {
        wait.until(ExpectedConditions.visibilityOf(searchLocator.maxdragger)).clear();
        searchLocator.maxdragger.sendKeys(max);
    }

    public boolean isPriceWithinRange(int min, int max) {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchLocator.price));
            String priceText = searchLocator.price.getText().replaceAll("[^0-9]", "");
            int priceValue = Integer.parseInt(priceText);
            return priceValue >= min && priceValue <= max;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void dragSliderHandles(int leftOffset, int rightOffset) {
        WebElement leftHandle = searchLocator.leftSliderHandle;
        WebElement rightHandle = searchLocator.rightSliderHandle;

        Actions actions = new Actions(driver);

        actions.clickAndHold(leftHandle)
               .moveByOffset(leftOffset, 0)
               .release()
               .perform();

        actions.clickAndHold(rightHandle)
               .moveByOffset(rightOffset, 0)
               .release()
               .perform();
    }
    
    public void clickShopByCategory() {
    	searchLocator.shopbycategory.click();
    }
    public void clickCategory() {
    	searchLocator.components.click();
    }
   
    public void selectProductCountFromDropdown(String value){
        wait.until(ExpectedConditions.elementToBeClickable(searchLocator.select));
        Select dropdown = new Select(searchLocator.select);
        dropdown.selectByVisibleText(value);
    }
    
    public int getSelectedDropdownValue() {
        Select dropdown = new Select(searchLocator.select);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        return Integer.parseInt(selectedOption);
    }

    public int getDisplayedProductCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchLocator.productList));
        List<WebElement> list=searchLocator.productList;
        System.out.print(list.size());
        return searchLocator.productList.size();
        
    }

    public boolean isProductCountMatchingDropdown() {
        int expectedCount = getSelectedDropdownValue();
        int actualCount = getDisplayedProductCount();
        return expectedCount == actualCount;
    }
 
    
    public void hoverOverFirstProduct()  {
        Actions actions = new Actions(driver);
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='carousel-item active']//img)[1]"));
        actions.moveToElement(firstProduct).perform();
        
        WebElement quickViewButton = driver.findElement(By.xpath("//button[@class='btn btn-quick-view quick-view-28']/i"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", quickViewButton);
    }     

    public boolean isQuickViewDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(searchLocator.textQuickView)).isDisplayed();
    }
    
    public void clickAddToCartAndHandlePopup() {
        try {
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(searchLocator.addToCartButton));
            
            // Use JS click for reliability
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", addToCartBtn);

            // Wait for the notification popup or message
            WebElement popup = wait.until(ExpectedConditions.visibilityOf(searchLocator.popupMessage));
            System.out.println("Popup text: " + popup.getText());

            // Click the Checkout button if visible
            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(searchLocator.checkoutButton));
            checkoutBtn.click();

        } catch (Exception e) {
            System.out.println("Failed to click Add to Cart or handle popup: " + e.getMessage());
        }
    }   
}


