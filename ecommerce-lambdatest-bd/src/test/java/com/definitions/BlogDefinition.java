package com.definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import com.actions.BlogAction;

import java.util.List;
import java.util.Map;

public class BlogDefinition {

    BlogAction blogAction = new BlogAction();

    @When("the user clicks on the Blog button")
    public void the_user_clicks_on_the_blog_button() {
        blogAction.clickBlog();
    }

    @Then("the user selects any article from the blog")
    public void the_user_selects_any_article_from_the_blog() {
        blogAction.clickArticle();
    }

    @Then("the user is navigated to the selected blog page")
    public void the_user_is_navigated_to_the_selected_blog_page() {
      
    }

    @When("the user enters the following comment details:")
    public void the_user_enters_the_following_comment_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        blogAction.enterName(data.get(0).get("name"));
        blogAction.enterEmail(data.get(0).get("email"));
        blogAction.enterComment(data.get(0).get("comment"));
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedMessage) {
        String actualMessage = blogAction.getSuccessMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user enters the name {string}")
    public void the_user_enters_the_name(String name) {
        blogAction.enterName(name);
    }

    @When("enters the email {string}")
    public void enters_the_email(String email) {
        blogAction.enterEmail(email);
    }

    @When("adds the comment {string}")
    public void adds_the_comment(String comment) {
        blogAction.enterComment(comment);
    }

    @When("clicks on the Post Comment button")
    public void clicks_on_the_post_comment_button() {
        blogAction.clickPostComment();
    }
    @Then("the user should see the warning message {string} and {string}")
    public void the_user_should_see_the_warning_message_and(String expectedWarning, String check) {
    	 String actualWarning = "";

         switch (check) {
             case "check1":
                 actualWarning = blogAction.getWarning2(); 
                 break;
             case "check2":
                 actualWarning = blogAction.getWarning1();
                 break;
             case "check3":
                 actualWarning = blogAction.getWarning2(); 
                 break;
             case "check4":
                 actualWarning = blogAction.getWarning2(); 
                 break;  
                 
             default:
                 Assert.fail("Invalid check value provided");
         }

         Assert.assertEquals(expectedWarning, actualWarning);
    }
    
    @When("the user selects category")
    public void the_user_selects_category() {
      blogAction.clickBusiness();
    }

    @Then("the user should see article page")
    public void the_user_should_see_article_page() {
    	  String heading = blogAction.getArticleHeading();
          Assert.assertTrue("Article heading not found!", heading != null && !heading.isEmpty());
      }
    
    @When("clicks on the product image")
    public void clicks_on_the_product_image() {
    	blogAction.clickImage();
       
    }

    @Then("the product shopping page is displayed")
    public void the_product_shopping_page_is_displayed() {
        Assert.assertTrue("Product name is not displayed on the shopping page", blogAction.isProductNameDisplayed());
    }
}