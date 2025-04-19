package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AddToCartLocator;
import com.pages.CheckOutPageLocator;
import com.pages.SearchLocator;
import com.utilities.HelperClass;

public class CheckOutAction {
    CheckOutPageLocator checkOutPageLocator = null;
    SearchLocator searchLocator;
    AddToCartLocator cartLocator;
    WebDriverWait wait;
    private final Actions actions;

    public CheckOutAction() {
        this.searchLocator = new SearchLocator();
        checkOutPageLocator = new CheckOutPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), checkOutPageLocator);
        this.actions = new Actions(HelperClass.getDriver());
    }

    private WebElement getSearchBox() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.searchbox));
    }

    private WebElement getSearchButton() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.searchbutton));
    }

    public void searchProdut(String string) {
        WebElement searchBox = getSearchBox();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.BACK_SPACE);
        searchBox.sendKeys(string);
        getSearchButton().click();
    }

    private WebElement getProductImage() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.productImage));
    }

    public void selectSearchProduct() {
        getProductImage().click();
    }

    private WebElement getCheckoutFromCartButton() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.CheckoutFromCart));
    }

    public void productCheckOut() {
        getCheckoutFromCartButton().click();
    }

    private WebElement getGuestUserButton() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.guestUser));
    }

    private WebElement getRegisterUserButton() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.registerUser));
    }

    public void selectGuestUser() {
        getGuestUserButton().click();
    }

    public void selectRegUser() {
        getRegisterUserButton().click();
    }

    private WebElement getRemoveProductButton() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.removeProduct));
    }

    public void reomveProduct() {
        getRemoveProductButton().click();
    }

    public void fillGuestCheckoutForm(String firstName, String lastName, String email,
                                       String telephone, String address, String city,
                                       String postcode, String country, String region) {
        // Fill basic form fields
        checkOutPageLocator.paymentFname.sendKeys(firstName);
        checkOutPageLocator.paymentLname.sendKeys(lastName);
        checkOutPageLocator.paymentEmail.sendKeys(email);
        checkOutPageLocator.paymentTelephone.sendKeys(telephone);
        checkOutPageLocator.paymentAddress.sendKeys(address);
        checkOutPageLocator.paymentCity.sendKeys(city);
        checkOutPageLocator.paymentPostcode.sendKeys(postcode);

        // Handle country dropdown
        selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, "India");

        // Wait for region dropdown to load (may need AJAX wait)
        try {
            Thread.sleep(1000); // Simple wait - replace with proper wait in real implementation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        selectDropdownByVisibleText(checkOutPageLocator.regionDropdown, "Assam");
    }

    private void selectDropdownByVisibleText(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    public void acceptGuestTermsCondition() {
        try {
            WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

            WebElement termsCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[@id='form-checkout']/div/div[2]/div/div[5]/label")));

            ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
                    "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});",
                    termsCheckbox);

            wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
            ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
                    "arguments[0].click();", termsCheckbox);

        } catch (Exception e) {
            System.out.println("Exception while accepting terms: " + e.getMessage());
            throw e;
        }
    }

    public void clickPrivacyPolicy() {
        checkOutPageLocator.PrivacyCheckbox.click();
    }

    public void clickContinueCheckout() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.continueButton));

        actions.moveToElement(checkOutPageLocator.continueButton)
                .click()
                .perform();
    }

    private WebElement getConfirmOrderButton() {
        return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(checkOutPageLocator.confirmOrder));
    }

    public void confirmOrder() {
        getConfirmOrderButton().click();
    }

    public boolean OrderSuccessMsg() {
        return checkOutPageLocator.orderSuccessMessage.isDisplayed();
    }

    public String EmptyCartMessage() {
        return checkOutPageLocator.emptyCartMessage.getText();
    }

    public void fillPaymentCheckoutForm(String firstName, String lastName,
                                         String address, String city,
                                         String postcode) {

        checkOutPageLocator.paymentFname.sendKeys(firstName);
        checkOutPageLocator.paymentLname.sendKeys(lastName);
        checkOutPageLocator.paymentAddress.sendKeys(address);
        checkOutPageLocator.paymentCity.sendKeys(city);
        checkOutPageLocator.paymentPostcode.sendKeys(postcode);

        selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, "India");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        selectDropdownByVisibleText(checkOutPageLocator.regionDropdown, "Assam");
    }

    public void clickExistingAddButton() {
        checkOutPageLocator.ExistingAdd.click();
    }

    public void clickNewAddressButton() {
        checkOutPageLocator.newAdd.click();
    }

    public void fillRegisterCheckoutForm(String firstName, String lastName, String email,
                                          String telephone, String password, String confirm_pass, String address, String city,
                                          String postcode, String country) {

        checkOutPageLocator.paymentFname.sendKeys(firstName);
        checkOutPageLocator.paymentLname.sendKeys(lastName);
        checkOutPageLocator.paymentEmail.sendKeys(email);
        checkOutPageLocator.paymentTelephone.sendKeys(telephone);
        checkOutPageLocator.pass.sendKeys(password);
        checkOutPageLocator.confirmpass.sendKeys(confirm_pass);
        checkOutPageLocator.paymentAddress.sendKeys(address);
        checkOutPageLocator.paymentCity.sendKeys(city);
        checkOutPageLocator.paymentPostcode.sendKeys(postcode);

        selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, "India");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        selectDropdownByVisibleText(checkOutPageLocator.regionDropdown, "Assam");
    }

    public String getDuplicateEmailError() {
        return checkOutPageLocator.duplicateEmail.getText();
    }
}
