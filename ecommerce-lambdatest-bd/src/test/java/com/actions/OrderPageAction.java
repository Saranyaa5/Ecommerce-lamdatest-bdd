package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.OrderPageLocator;
import com.utilities.HelperClass;

public class OrderPageAction {

    public OrderPageLocator orderPageLocator = null;
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final JavascriptExecutor jsExecutor;

    public OrderPageAction() {
        this.driver = HelperClass.getDriver();
        this.orderPageLocator = new OrderPageLocator();
        PageFactory.initElements(driver, orderPageLocator);
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void continue1() {
        int attempts = 0;
        while (attempts < 2) {
            try {
                // Reinitialize the locator to make sure it's up to date
                orderPageLocator = new OrderPageLocator(); 
                PageFactory.initElements(driver, orderPageLocator);

                // Wait and click the 'Continue' button after refreshing the element
                WebElement continueBtn = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(orderPageLocator.accContinue)
                ));
                continueBtn.click();
                break;  // Exit the loop if successful
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("Retrying due to stale element...");
                if (attempts == 2) {
                    throw e;  // Throw the exception if retry fails
                }
            }
        }
    }

    public void clickOrderHistory() throws InterruptedException {
        WebElement myAccountElement = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.myAccount)
        ));
        actions.moveToElement(myAccountElement).perform();

        WebElement myOrderElement = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(orderPageLocator.orders)
        ));
        Thread.sleep(1000); // optional small pause
        myOrderElement.click();
        Thread.sleep(1000); // optional
    }

    public boolean eyeDisplayed() {
        WebElement eyeIcon = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.viewOrderButton)
        ));
        return eyeIcon.isDisplayed();
    }

    public void clickViewButton() {
        WebElement viewBtn = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(orderPageLocator.viewOrderButton)
        ));
        viewBtn.click();
    }

    public void clickReorderButton() {
        WebElement reorderBtn = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(orderPageLocator.reorderButton)
        ));
        reorderBtn.click();
    }

    public boolean isReorderMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.reorderSuccessMessage)
        ));
        return message.isDisplayed();
    }

    public String getTextOrder() {
        WebElement heading = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.orderhistory)
        ));
        return heading.getText();
    }

    // Optional: Uncomment if you want to print the order table
    /*
    public boolean printOrderHistoryTable() throws InterruptedException {
        WebDriverWait tableWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement tbody = tableWait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='table-responsive']//table//tbody")
            )
        ));
        Thread.sleep(4000);
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println();
        }
        return true;
    }
    */
}
