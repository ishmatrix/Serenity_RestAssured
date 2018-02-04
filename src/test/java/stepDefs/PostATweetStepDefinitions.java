package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.PostATweetSteps;

import java.util.Random;


public class PostATweetStepDefinitions {

    Random ran=new Random();

    private int randomNum= ran.nextInt(1000);
    private String myTweet="Post my "+randomNum+ " tweet using SerenityRest";
    private String twitterHandle="qaTest_99";

    @Steps
    PostATweetSteps postTweet;

    @Given("the authentication tokens for a twitter account")
    public void doNothingHere() {

    }

    @When("the user posts")
    public void tryTweet() {

        postTweet.tryPostingATweet(myTweet);
        postTweet.tweetIsPostedSuccessfully();

    }

    @Then("the tweet is posted successfully")
    public void verify_Assert_Whatever() {

        postTweet.verifyResponseTweet(myTweet);
        postTweet.verifyTwitterHandle(twitterHandle);

    }
}
