package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.DataDrivenTrialSteps;

public class DataDrivenTrialStepDefs {

    @Steps
    DataDrivenTrialSteps dSteps;


    @Given("^some pre-requisite information$")
    public void somePreRequisiteInformation() {
        dSteps.doNothing();
    }

    @When("^I pass param \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPassParamAnd(String arg0, String arg1) {
        dSteps.displaySomeArgs(arg0, arg1);

    }

    @Then("^display both of these$")
    public void displayBothOfThese() {
        dSteps.doNothing();

    }


    @When("^we pass \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
    public void wePassAndWith(String arg0, String arg1, String arg2) {

        dSteps.displaySomeArgs(arg0, arg1, arg2);
    }


    @When("^user enters username and password$")
    public void userEntersUsernameAndPassword(DataTable dT) {

        dSteps.getDataUsingListWithinDataTable(dT);
    }

    @Then("^we will pass a set of data$")
    public void weWillPassASetOfData(DataTable dT) throws Throwable {

        dSteps.getDataUsingListOfMaps(dT);
    }
}
