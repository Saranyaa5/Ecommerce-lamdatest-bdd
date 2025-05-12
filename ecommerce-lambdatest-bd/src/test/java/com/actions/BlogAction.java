package com.actions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BlogLocator;
import com.utilities.HelperClass;

public class BlogAction {
    WebDriver driver;
    BlogLocator blog;

    public BlogAction() {
        this.driver = HelperClass.getDriver();
        this.blog = new BlogLocator();
        PageFactory.initElements(driver, blog);
    }

    private void refreshElements() {
        blog = new BlogLocator();
        PageFactory.initElements(driver, blog);
    }

    public void clickBlog() {
        try {
            BaseAction.clickElement(blog.blogbutton);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            BaseAction.clickElement(blog.blogbutton);
        }
    }

    public void clickArticle() {
        try {
            BaseAction.clickElement(blog.article);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            BaseAction.clickElement(blog.article);
        }
    }

    public void enterName(String name) {
        try {
            BaseAction.sendKeysElement(blog.yourName, name);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            BaseAction.sendKeysElement(blog.yourName, name);
        }
    }

    public void enterEmail(String email) {
        try {
            BaseAction.sendKeysElement(blog.email, email);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            BaseAction.sendKeysElement(blog.email, email);
        }
    }

    public void enterComment(String comment) {
        try {
            BaseAction.sendKeysElement(blog.comment, comment);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            BaseAction.sendKeysElement(blog.comment, comment);
        }
    }

    public void clickPostComment() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(blog.postComment));
            wait.until(ExpectedConditions.elementToBeClickable(blog.postComment));

            BaseAction.clickElement(blog.postComment);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            clickPostComment(); // retry
        }
    }

    public String getSuccessMessage() {
        try {
            if (blog.validMessage.isDisplayed()) {
                return blog.validMessage.getText();
            } else {
                return "Success message not visible";
            }
        } catch (StaleElementReferenceException e) {
            refreshElements();
            if (blog.validMessage.isDisplayed()) {
                return blog.validMessage.getText();
            } else {
                return "Success message not visible";
            }
        } catch (NoSuchElementException e) {
            return "Success message element not found";
        }
    }

    public String getWarning1() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(blog.warningName));
            return blog.warningName.getText();
        } catch (StaleElementReferenceException e) {
            refreshElements();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(blog.warningName));
            return blog.warningName.getText();
        }
    }

    public String getWarning2() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(blog.warningComment));
            return blog.warningComment.getText();
        } catch (StaleElementReferenceException e) {
            refreshElements();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(blog.warningComment));
            return blog.warningComment.getText();
        }
    }

    public void clickBusiness() {
        try {
            BaseAction.clickElement(blog.business);
        } catch (StaleElementReferenceException e) {
            refreshElements();
            BaseAction.clickElement(blog.business);
        }
    }

    public String getArticleHeading() {
        try {
            return blog.businessHeading.getText();
        } catch (StaleElementReferenceException e) {
            refreshElements();
            return blog.businessHeading.getText();
        }
    }

    public void clickImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(blog.img));
        BaseAction.clickElement(blog.img);
    }

    public boolean isProductNameDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(blog.productName));
            return blog.productName.isDisplayed();
        } catch (StaleElementReferenceException e) {
            refreshElements();
            return blog.productName.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
