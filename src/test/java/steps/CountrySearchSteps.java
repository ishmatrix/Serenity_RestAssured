package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.Matchers.equalTo;


public class CountrySearchSteps {

    private final String BASE_URI = "http://services.groupkt.com";
    private final String RESOURCE = "/country/get/iso2code/";

     private Response response;

    @Step
    public void searchCountryByCode(String code){
        response = SerenityRest
                .when()
                .get(BASE_URI + code);
    }

    @Step
    public void searchIsExecutedSuccessfully(){
        response
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step
    public void iShouldFindCountry(String country){
        response
                .then()
                .assertThat()
                .body("RestResponse.result.name", equalTo(country));
    }
}
