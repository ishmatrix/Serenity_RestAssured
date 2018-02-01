package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.GMapsTextSearchSteps;

public class GMapsTextSearchStepDefinitions {

    @Steps
    GMapsTextSearchSteps gmaps;

    @Given("given condition")
    public void doNothingHere(){

    }
    @When("search text")
    public void trySearching(){

        gmaps.searchText("Restaurants in London");
    }

    @Then("sget size of the result")
    public void getSize(){

        gmaps.searchRequestSuccessful();
        gmaps.getListOfResultFromResponse();
    }


}
