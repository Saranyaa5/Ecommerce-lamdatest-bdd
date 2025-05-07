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

    // Enters name into the input field
    public void enterName(String name) {
        try {
            wait.until(ExpectedConditions.visibilityOf(reviewPage.nameInput)).clear();
            reviewPage.nameInput.sendKeys(name);
        } catch (Exception e) {
            System.out.println("Error entering name: " + e.getMessage());
        }
    }

    // Enters review text
    public void enterReview(String review) {
        try {
            wait.until(ExpectedConditions.visibilityOf(reviewPage.reviewTextarea)).clear();
            reviewPage.reviewTextarea.sendKeys(review);
        } catch (Exception e) {
            System.out.println("Error entering review: " + e.getMessage());
        }
    }

    // Selects rating based on the number of stars
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
            default:
                throw new IllegalArgumentException("Invalid rating: " + stars);
        }

        try {
            if (ratingElement != null) {
                wait.until(ExpectedConditions.elementToBeClickable(ratingElement)).click();
            } else {
                System.out.println("Invalid star rating selected: " + stars);
            }
        } catch (Exception e) {
            System.out.println("Error selecting rating: " + e.getMessage());
        }
    }

    // Clicks the continue button to submit the review
    public void clickContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(reviewPage.continueButton)).click();
        } catch (Exception e) {
            System.out.println("Error clicking continue: " + e.getMessage());
        }
    }

    // Retrieves success message text
    public String getSuccessMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(reviewPage.successMessage)).getText();
        } catch (Exception e) {
            System.out.println("Error getting success message: " + e.getMessage());
            return "";
        }
    }

    // Retrieves first error message text
    public String ErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(reviewPage.errorMessage)).getText();
        } catch (Exception e) {
            System.out.println("Error getting error message: " + e.getMessage());
            return "";
        }
    }

    // Retrieves second error message text
    public String ErrorMessage1() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(reviewPage.reviewTextLengthError)).getText();
        } catch (Exception e) {
            System.out.println("Error getting error message 1: " + e.getMessage());
            return "";
        }
    }
}
