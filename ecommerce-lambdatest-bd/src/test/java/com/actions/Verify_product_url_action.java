package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.HelperClass;

public class Verify_product_url_action {


    WebDriver driver = HelperClass.getDriver();
  
    WebDriverWait wait;

    public Verify_product_url_action() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

	
	
	public String getProductUrl() {
		
		return driver.getCurrentUrl();
	}

}
