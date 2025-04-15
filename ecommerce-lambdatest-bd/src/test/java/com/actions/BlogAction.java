package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AffiliateAccountLocator;
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
	
	public void clickBlog() {
		blog.blogbutton.click();
	}
	public void clickArticle() {
		blog.article.click();
	}
	public void enterName(String name) {
	    blog.yourName.clear();
	    blog.yourName.sendKeys(name);
	}

	public void enterEmail(String email) {
	    blog.email.clear();
	    blog.email.sendKeys(email);
	}

	public void enterComment(String comment) {
	    blog.comment.clear();
	    blog.comment.sendKeys(comment);
	}

	public void clickPostComment() {
	    blog.postComment.click();
	}

	public String getSuccessMessage() {
	    return blog.validMessage.getText();
	}
	
	public String getWarning1() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(blog.Warning1));
	    return blog.Warning1.getText();
	}

	public String getWarning2() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(blog.Warning2));
	    return blog.Warning2.getText();
	}

}
