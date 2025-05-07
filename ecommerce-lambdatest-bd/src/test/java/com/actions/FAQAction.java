package com.actions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
        faqlocator.changeshippingaddress.click();
       
    }

    public String faqmessageList() {
        return faqlocator.changeshippingaddressmsg.getText();
    }
}
