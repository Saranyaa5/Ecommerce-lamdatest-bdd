package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogLocator {
@FindBy(xpath="(//span[@class='title'][normalize-space()='Blog'])[2]")
public WebElement blogbutton;

@FindBy(xpath="(//a[@class='text-ellipsis-2'][contains(text(),'amet volutpat consequat mauris nunc congue nisi vi')])[1]")
public WebElement article;

@FindBy(xpath="(//input[@id='input-name'])[1]")
public WebElement yourName;

@FindBy(xpath="(//input[@id='input-email'])[1]")
public WebElement email;

@FindBy(xpath="(//textarea[@id='input-comment'])[1]")
public WebElement comment;

@FindBy(xpath="(//button[normalize-space()='Post comment'])[1]")
public WebElement postComment;


@FindBy(css="#form-comment .alert-success")
public WebElement validMessage;

@FindBy(xpath="//*[@id=\"form-comment\"]/div[3]/div")
public WebElement commentError;

@FindBy(xpath="//div[@class='invalid-feedback'][normalize-space()='Warning: Comment Name must be between 3 and 25 characters!']")
public WebElement Warning1;

@FindBy(xpath="//div[@class='invalid-feedback'][normalize-space()='Warning: Comment Text must be between 25 and 1000 characters!']")
public WebElement Warning2;

}
