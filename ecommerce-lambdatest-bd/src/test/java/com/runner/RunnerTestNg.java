package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

    features = {
     "src/test/resources/com/features/ForgotPassword.feature",
      "src/test/resources/com/features/AddToCart.feature",
      "src/test/resources/com/features/UserAccountManagement.feature",
      "src/test/resources/com/features/ProductReview.feature",
      "src/test/resources/com/features/EstimateShippingStatus.feature",
      "src/test/resources/com/features/FAQ.feature",
      "src/test/resources/com/features/ShoppingCartTableVerification.feature",
      "src/test/resources/com/features/Verify_product_url.feature",
      

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
