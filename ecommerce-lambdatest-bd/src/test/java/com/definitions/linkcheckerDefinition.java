package com.definitions;

import com.actions.linkcheckerAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class linkcheckerDefinition {

    linkcheckerAction linkcheckeraction = new linkcheckerAction();

    @When("user collect all the links on the page")
    public void user_collect_all_the_links_on_the_page() {
        linkcheckeraction.collectAllLinks();
    }

    @Then("user should print the total number of links")
    public void user_should_print_the_total_number_of_links() {
        linkcheckeraction.printTotalLinks();
    }

    @Then("user should validate each link is not broken")
    public void user_should_validate_each_link_is_not_broken() {
        linkcheckeraction.verifyAllLinks();
    }
}
