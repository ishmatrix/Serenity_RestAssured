package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.SearchAccountDetailsSteps;
import steps.SearchActiveAccountsSteps;

public class SearchAccountsStepDef {

    @Steps
    SearchActiveAccountsSteps searchActiveAcc;   ;

    @Given("an authenticated user with an active session")
    public void authenticated_User(){
       // search.sendGetRequestForAllActiveAccounts();

    }
    @When("searches for all active accounts")
    public void user_Gets_Request(){
        searchActiveAcc.sendGetRequestForAllActiveAccounts();
    }
    @Then("a list of all the bank and credit card accounts is returned")
    public void record_account_details(){

        searchActiveAcc.verifySuccessStatus();
        searchActiveAcc.recordActiveAccountDetails();

    }



}
