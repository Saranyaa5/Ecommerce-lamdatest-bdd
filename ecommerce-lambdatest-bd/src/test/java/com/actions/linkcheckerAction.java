package com.actions;

import com.pages.linkcheckerLocator;
import com.utilities.HelperClass;
import com.utilities.ConfigReader;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class linkcheckerAction {

    private final linkcheckerLocator locator;
    private List<WebElement> allLinks;

    public linkcheckerAction() {
        this.locator = new linkcheckerLocator();
    }

    public void collectAllLinks() {
        allLinks = locator.getAllAnchorTags();
    }

    public void printTotalLinks() {
        System.out.println("Total number of links found on the page: " + allLinks.size());
    }

    public void verifyAllLinks() {
        System.out.println("🔍 Verifying all collected links...");
        for (WebElement link : allLinks) {
            try {
                String href = link.getAttribute("href");

                if (href == null || href.trim().isEmpty()) {
                    System.out.println("Empty or null href found. Skipping...");
                    continue;
                }

                HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println("Broken Link: " + href + " [HTTP " + responseCode + "]");
                } else {
                    System.out.println("Valid Link: " + href + " [HTTP " + responseCode + "]");
                }

            } catch (Exception e) {
                System.out.println("Exception for link: " + link.getAttribute("href"));
                System.out.println("   → " + e.getMessage());
            }
        }
    }
}
