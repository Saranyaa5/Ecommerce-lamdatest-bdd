package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

    features = {
    		 "src/test/resources/com/features/ForgotPassword.feature",
    	      "src/test/resources/com/features/Search.feature",
    	      "src/test/resources/com/features/AddToCart.feature",
    	      "src/test/resources/com/features/UserAccountManagement.feature",
    	      "src/test/resources/com/features/ProductCompare.feature",
    	      "src/test/resources/com/features/ProductCheckOut.feature",
    	      "src/test/resources/com/features/Blog.feature",
    	      "src/test/resources/com/features/AffiliateAccount.feature",
    	      "src/test/resources/com/features/ProductReview.feature",
    	      "src/test/resources/com/features/MyOrder.feature",
    	      "src/test/resources/com/features/Home.feature",
    	      "src/test/resources/com/features/EstimateShippingStatus.feature",
    	      "src/test/resources/com/features/FAQ.feature",
    	      "src/test/resources/com/features/SpecialOffer.feature",
    	      "src/test/resources/com/features/UserLogin.feature",
    	      "src/test/resources/com/features/UserRegistration.feature",
    	      "src/test/resources/com/features/Verify_product_url.feature",
    	      "src/test/resources/com/features/AddOns.feature",
              "src/test/resources/com/features/ShoppingCartTableVerification.feature"

    },
    glue = {"com.definitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "rerun:target/failed-scenarios.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    },
    monochrome = true,
    dryRun = false
)
public class RunnerTestNg extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
