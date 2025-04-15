//package com.utilities;
//
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class HelperClass {
//    private static HelperClass helperClass;
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
//    public final static int TIMEOUT = 10;
//
//
//    public static final String ConfigPath ="C:\\Users\\saran\\git\\SeleniumFinalCucumber\\ecommerce-lambdatest-bd\\src\\test\\resources\\Cofiguration.properties";
//
//
//    private HelperClass() {
//        ConfigReader.loadProperties(ConfigPath);
//
//        String browser = ConfigReader.getProperty("browser");
//        WebDriver localDriver = null;
//
//        if (browser.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-features=PasswordLeakDetection");
//            options.addArguments("--incognito");
//            options.addArguments("--headless");
//            localDriver = new ChromeDriver(options);
//        } else if (browser.equalsIgnoreCase("edge")) {
//            EdgeOptions options = new EdgeOptions();
//            options.addArguments("--disable-features=PasswordLeakDetection");
//            options.addArguments("--incognito");
//            localDriver = new EdgeDriver(options);
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            FirefoxOptions options = new FirefoxOptions();
//            options.addArguments("--disable-features=PasswordLeakDetection");
//            options.addArguments("--incognito");
//            localDriver = new FirefoxDriver(options);
//        }
//
//        driver.set(localDriver);
//        wait.set(new WebDriverWait(localDriver, Duration.ofSeconds(TIMEOUT)));
//        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
//        localDriver.manage().window().maximize();
//    }
//
//    public static void openPage() {
//        String url = ConfigReader.getProperty("url");
//        getDriver().get(url);
//    }
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static WebDriverWait getWait() {
//        return wait.get();
//    }
//
//    public static void setUpDriver() {
//        if (helperClass == null) {
//            helperClass = new HelperClass();
//        }
//    }
//
//    public static void tearDown() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//            wait.remove();
//        }
//        helperClass = null;
//    }
//}

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
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public final static int TIMEOUT = 10;

    // Relative path from the classpath root (src/test/resources)
    public static final String ConfigPath = "Configuration.properties";

    private HelperClass() {
        ConfigReader.loadProperties(ConfigPath);

        String browser = ConfigReader.getProperty("browser");
        WebDriver localDriver = null;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--incognito");

//            options.addArguments("--headless");
            localDriver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--incognito");
            localDriver = new EdgeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--incognito");
            localDriver = new FirefoxDriver(options);
        }

        driver.set(localDriver);
        wait.set(new WebDriverWait(localDriver, Duration.ofSeconds(TIMEOUT)));
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        localDriver.manage().window().maximize();
    }

    public static void openPage() {
        String url = ConfigReader.getProperty("url");
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void setUpDriver() {
        if (helperClass == null) {
            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
        helperClass = null;
    }
}