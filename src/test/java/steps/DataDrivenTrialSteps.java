package steps;


import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;


import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class DataDrivenTrialSteps {

    @Step
    public void doNothing() {
        System.out.println("Do thing");
    }

    @Step
    public void displaySomeArgs(String arg1, String arg2) {
        System.out.println("Argument " + arg1 + " " + "Argument " + arg2);
    }

    @Step
    public void displaySomeArgs(String arg1, String arg2, String arg3) {
        System.out.println("Argument " + arg1 + " " + "Argument " + arg2 + " " + "Argument " + arg3);
    }

    @Step
    public void getDataUsingListWithinDataTable(DataTable dT) {

        //We need to be sure which DataTable class we are invoking (Serenity or Cucumber)
        List<List<String>> data = dT.raw();
        System.out.println(data.get(0).get(0));
        System.out.println(data.get(0).get(1));
    }

    @Step
    public void getDataUsingListOfMaps(DataTable dT) {
        List<Map<String, String>> listOfDataMap = dT.asMaps(String.class, String.class);

        for (Map<String, String> dataMap : listOfDataMap) {

            System.out.println(dataMap.get("username"));
            System.out.println(dataMap.get("password"));
            System.out.println(dataMap.get("mobNum"));
            System.out.println(dataMap.get("id"));
        }
    }
}
