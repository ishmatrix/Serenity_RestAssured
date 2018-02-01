package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.CountrySearchSteps;

public class CountrySearchStepDefinition {

    @Steps
    CountrySearchSteps countrySearch;

    @Given("The CODE of the country")
    public  void doNothing(){

    }
    @When("Search country code by")
    public void trySearchingCountry(){

        countrySearch.searchCountryByCode("IN");
    }

    @Then("Verify the request was successful and country")
    public void validateSomething(){

        countrySearch.searchIsExecutedSuccessfully();
        countrySearch.iShouldFindCountry("INDIA");
    }

}
