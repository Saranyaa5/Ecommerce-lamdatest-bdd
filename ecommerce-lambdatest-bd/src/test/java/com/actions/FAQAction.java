package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.FAQLocator;
import com.utilities.HelperClass;

public class FAQAction {
    FAQLocator faqlocator;
    WebDriver driver = HelperClass.getDriver();
    WebDriverWait wait;

    public FAQAction() {
        faqlocator = new FAQLocator();
        PageFactory.initElements(driver, faqlocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validateFAQButtons() {
//        try {
//            Thread.sleep(1000); // Wait 1 second before clicking FAQ
//        } catch (InterruptedException e) {
//            System.out.println("Thread interrupted: " + e.getMessage());
//        }
        wait.until(ExpectedConditions.elementToBeClickable(faqlocator.changeshippingaddress)).click();
    }

    public String faqmessageList() {
        wait.until(ExpectedConditions.visibilityOf(faqlocator.changeshippingaddressmsg));
        String msg = faqlocator.changeshippingaddressmsg.getText().trim().replaceAll("\\s+", " ");
        return msg;
    }
}
