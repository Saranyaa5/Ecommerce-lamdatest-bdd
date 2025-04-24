package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

    features = {
        "src/test/resources/com/features/Login.feature",
        "src/test/resources/com/features/Search.feature",
         "src/test/resources/com/features/Blog.feature",
    	 "src/test/resources/com/features/AffiliateAccount.feature"  
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
