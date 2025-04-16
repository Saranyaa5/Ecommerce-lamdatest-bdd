package com.actions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.ProductReviewLocator;
import com.utilities.HelperClass;

public class ProductReviewAction {

    WebDriver driver = HelperClass.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    ProductReviewLocator reviewPage = new ProductReviewLocator();

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOf(reviewPage.nameInput)).clear();
        reviewPage.nameInput.sendKeys(name);
    }

    public void enterReview(String review) {
        wait.until(ExpectedConditions.visibilityOf(reviewPage.reviewTextarea)).clear();
        reviewPage.reviewTextarea.sendKeys(review);
    }

    public void selectRating(int stars) {
        WebElement ratingElement = null;

        switch (stars) {
            case 1:
                ratingElement = reviewPage.rating1;
                break;
            case 2:
                ratingElement = reviewPage.rating2;
                break;
            case 3:
                ratingElement = reviewPage.rating3;
                break;
            case 4:
                ratingElement = reviewPage.rating4;
                break;
            case 5:
                ratingElement = reviewPage.rating5;
                break;
        }

        if (ratingElement != null) {
            wait.until(ExpectedConditions.elementToBeClickable(ratingElement)).click();
        }
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewPage.continueButton)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(reviewPage.successMessage)).getText();
    }

    public String ErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(reviewPage.ErrorMessage)).getText();
    }

	public String ErrorMessage1() {
		return wait.until(ExpectedConditions.visibilityOf(reviewPage.ErrorMessage1)).getText();
	}

    
}