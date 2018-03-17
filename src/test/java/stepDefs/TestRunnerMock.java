package stepDefs;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/dataDrivenTrial.feature",
        glue = {"stepDefs"},
        dryRun = false)
public class TestRunnerMock {

}
