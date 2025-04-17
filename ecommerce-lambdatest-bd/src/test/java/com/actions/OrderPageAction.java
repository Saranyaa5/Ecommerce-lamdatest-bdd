
package com.actions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver; // <-- Import added
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.OrderPageLocator;
import com.utilities.HelperClass;

public class OrderPageAction {

    public OrderPageLocator orderPageLocator = null;
    private final WebDriver driver; // <-- Define WebDriver
    private final WebDriverWait wait;
    private final Actions actions;
    private final JavascriptExecutor jsExecutor;

    public OrderPageAction() {
        this.driver = HelperClass.getDriver(); // <-- Initialize WebDriver
        this.orderPageLocator = new OrderPageLocator();
        PageFactory.initElements(driver, orderPageLocator);
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void continue1() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(orderPageLocator.accContinue));
        continueBtn.click();
    }

    public void clickOrderHistory() throws InterruptedException {
        WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOf(orderPageLocator.myAccount));
        actions.moveToElement(myAccountElement).perform();

        WebElement myOrderElement = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(orderPageLocator.orders)
        ));
        Thread.sleep(2000);
        myOrderElement.click();
        Thread.sleep(2000);
    }
    
//    public boolean eyeDisplayed() {
//    return orderPageLocator.viewOrderButton.isDisplayed();
//    }
    public boolean eyeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orderPageLocator.viewOrderButton));
		return orderPageLocator.viewOrderButton.isDisplayed();
    }
    
    public void clickViewButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(orderPageLocator.viewOrderButton)).click();
    }

    public void clickReorderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(orderPageLocator.reorderButton)).click();
    }

    public boolean isReorderMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(orderPageLocator.reorderSuccessMessage));
		return orderPageLocator.reorderSuccessMessage.isDisplayed();
    }
    public String getTextOrder() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOf(orderPageLocator.orderhistory));
        return heading.getText();
    }


//    public boolean printOrderHistoryTable() throws InterruptedException {
//        WebDriverWait tableWait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        WebElement tbody = tableWait.until(ExpectedConditions.visibilityOfElementLocated(
//		        By.xpath("//div[@class='table-responsive']//table//tbody")));
//        Thread.sleep(4000);
//		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
//		for (WebElement row : rows) {
//		    List<WebElement> cols = row.findElements(By.tagName("td"));
//		    for (WebElement col : cols) {
//		        System.out.print(col.getText() + "\t");
//		    }
//		    System.out.println();
//		}
//		return false;
//    }
}
