package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
    private static HelperClass helperClass;
    private static WebDriver driver;
    private static WebDriverWait wait;
    public final static int TIMEOUT = 10;

    public static final String ConfigPath = "C:\\Users\\kirub\\git\\Ecommerce-lamdatest-bdd\\ecommerce-lambdatest-bd\\src\\test\\resources\\Cofiguration.properties";

    private HelperClass() {
        
        ConfigReader.loadProperties(ConfigPath);

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--incognito");
            driver = new EdgeDriver(options);
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--incognito");
            driver = new FirefoxDriver(options);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
    }

    public static void openPage() {
           String url = ConfigReader.getProperty("url");
        
    	driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (helperClass == null) {
            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        helperClass = null;
    }
}
