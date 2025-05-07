package com.definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.HomePageAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageDefinition {
	HomePageAction homePageAction=new HomePageAction();
	private static final Logger logger = LogManager.getLogger(HomePageDefinition.class);

	@When("the user clicks the shop now in first block")
	public void the_user_clicks_the_shop_now_in_first_block() {
		homePageAction.block1click();
	}

	@Then("the user needs to redirect to the top of home page")
	public void the_user_needs_to_redirect_to_the_top_of_home_page() {
	    String expectedUrl="https://ecommerce-playground.lambdatest.io/#";
	    String actual=homePageAction.block1homepageUrl();
	   try {
		   
		   Assert.assertEquals(expectedUrl,actual);
		   logger.info("asserting the home page block 1 element is successfull");
	   }
	   catch(Exception e) {
		   System.out.println(e.getMessage());
		   logger.error("asserting the home page block 1 element is not successfull");
	   }
	   
		
	}
	
	@When("the user clicks shop now in second block")
	public void the_user_clicks_shop_now_in_second_block() {
		homePageAction.clickMpowBanner();
	}

	@Then("the user should see the {string} page")
	public void the_user_should_see_the_page(String string) {
		try {
            String actualTitle = homePageAction.getProductTitle();
            String expectedTitle = string;
            
            Assert.assertEquals(actualTitle, expectedTitle);
            logger.info("Successfully verified MPOW product page");
        } catch(Exception e) {
            logger.error("Failed to verify MPOW product page: {}",e.getMessage());
            throw e;
        }
	}
	
	@When("the user clicks hp25 Headphones poster")
	public void the_user_clicks_hp25_headphones_poster() {
		homePageAction.clickHeadphonesBanner();
	}

	@Then("the user should see the {string} product page")
	public void the_user_should_see_the_product_page(String string) {
		try {
            String actualTitle = homePageAction.getProductTitle();
            String expectedTitle = string;
            
            Assert.assertEquals(actualTitle, expectedTitle);
            logger.info("Successfully verified MPOW product page");
        } catch(Exception e) {
            logger.error("Failed to verify MPOW product page: {}",e.getMessage());
            throw e;
        }
	}
	@When("the user clicks the left control arrow on the banner")
	public void the_user_clicks_the_left_control_arrow_on_the_banner(){
		homePageAction.clickNextButton();
	}

	@Then("the {string} banner should be displayed")
	public void the_banner_should_be_displayed(String string){
		try {
			String actualBannerAltText =homePageAction.getActiveBannerAltText();
			System.out.println(actualBannerAltText);
	        Assert.assertEquals(string, actualBannerAltText);
            logger.info("Successfully is successfull");
        } catch(Exception e) {
            logger.error("Failed to verify {}",e.getMessage());
            throw e;
        }
		
    }
	
	
	@When("the user clicks the product in the trending product category")
	public void the_user_clicks_the_product_in_the_trending_product_category() {
	    homePageAction.clickTrendingProduct();
	}
	@Then("the user should redirect to the product page")
	public void the_user_should_redirect_to_the_product_page() {	
		try {
			String url="https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=18";
			Assert.assertEquals(homePageAction.getTrendingProductParagraphText(),url);
            logger.info("Successfully is successfull");
        } catch(Exception e) {
            logger.error("Failed to verify {}",e.getMessage());
            throw e;
        }
	}
	
	@When("the user retrieves all the links on the homepage")
	public void the_user_retrieves_all_the_links_on_the_homepage() throws InterruptedException {
	    homePageAction.retrieveLinks();
	}

	@Then("each link should redirect to its corresponding page successfully")
	public void each_link_should_redirect_to_its_corresponding_page_successfully() {
		try {
			
            logger.info("no of links in the homepage is not working working in homepage: {}",homePageAction.ValidatedLinks());
        }
		catch(Exception e) {
        	
            logger.error("home page does not contains broken link");
            throw e;
        }
	}
	

}
