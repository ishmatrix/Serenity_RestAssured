package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.CreateAnAccountSteps;
import steps.SearchAccountDetailsSteps;

public class CreateAnAccountStepDefs {

    @Steps
    CreateAnAccountSteps createAccnt;

    @Given("an a set if bank detail")
    public void doNothing(){
        //stub
    }

    @When("the new account details posted")
    public void bankInfoOfAnAccountID(){
        createAccnt.sendPostRequestCreatingAccount();


    }

    @Then("the account gets created")
    public void recordAccountDetails(){
        createAccnt.verifySuccessStatus();
        createAccnt.recordNewAccountDetails();
    }

}
