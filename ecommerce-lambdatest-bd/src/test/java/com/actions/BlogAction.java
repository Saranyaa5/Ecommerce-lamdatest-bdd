package com.actions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
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
			blog.blogbutton.click();
		} catch (StaleElementReferenceException e) {
			refreshElements();
			blog.blogbutton.click();
		}
	}

	public void clickArticle() {
		try {
			blog.article.click();
		} catch (StaleElementReferenceException e) {
			refreshElements();
			blog.article.click();
		}
	}

	public void enterName(String name) {
		try {
			blog.yourName.clear();
			blog.yourName.sendKeys(name);
		} catch (StaleElementReferenceException e) {
			refreshElements();
			blog.yourName.clear();
			blog.yourName.sendKeys(name);
		}
	}

	public void enterEmail(String email) {
		try {
			blog.email.clear();
			blog.email.sendKeys(email);
		} catch (StaleElementReferenceException e) {
			refreshElements();
			blog.email.clear();
			blog.email.sendKeys(email);
		}
	}

	public void enterComment(String comment) {
		try {
			blog.comment.clear();
			blog.comment.sendKeys(comment);
		} catch (StaleElementReferenceException e) {
			refreshElements();
			blog.comment.clear();
			blog.comment.sendKeys(comment);
		}
	}

	public void clickPostComment() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(blog.postComment));
			wait.until(ExpectedConditions.elementToBeClickable(blog.postComment));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", blog.postComment);
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
			wait.until(ExpectedConditions.visibilityOf(blog.Warning1));
			return blog.Warning1.getText();
		} catch (StaleElementReferenceException e) {
			refreshElements();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(blog.Warning1));
			return blog.Warning1.getText();
		}
	}

	public String getWarning2() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(blog.Warning2));
			return blog.Warning2.getText();
		} catch (StaleElementReferenceException e) {
			refreshElements();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(blog.Warning2));
			return blog.Warning2.getText();
		}
	}

	public void clickBusiness() {
		try {
			blog.business.click();
		} catch (StaleElementReferenceException e) {
			refreshElements();
			blog.business.click();
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
        blog.img.click();
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
