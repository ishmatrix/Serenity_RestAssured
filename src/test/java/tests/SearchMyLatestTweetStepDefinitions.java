package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SearchMyLatestTweetSteps;

@RunWith(SerenityRunner.class)
public class SearchMyLatestTweetStepDefinitions {

    @Steps
    SearchMyLatestTweetSteps searchTweet;

    @Given("the authentication tokens for a twitter account are available")
    public void doNothingHereForNow() {

    }
    @When("the  GET request for the latest tweet is sent")
    public void requestTheLatestTweet() {

        searchTweet.trySearchingLatestTweet();
    }
    @Then("the  latest tweet is retrieved successfully")
    public void verify_Assert_Whatever() {

        searchTweet.tweetSearchIsSuccessful();
        searchTweet.fetchLatestTweetAndItsID();

    }

}
