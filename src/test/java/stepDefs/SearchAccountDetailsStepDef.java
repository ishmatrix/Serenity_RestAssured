package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SearchAccountDetailsSteps;

public class SearchAccountDetailsStepDef {

    @Steps
    SearchAccountDetailsSteps search;

    @Given("an account id")
    public void doNothing(){
        //stub
    }

    @When("bank info of that account are fetched")
    public void bankInfoOfAnAccountID(){
        search.sendGetRequestForAccountDetails();


    }

    @Then("return all the details for the specified bank account")
    public void recordAccountDetails(){
        search.verifySuccessStatus();
        search.recordAccountDetails();
    }

}
