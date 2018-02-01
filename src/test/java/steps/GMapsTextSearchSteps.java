package steps;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.jruby.ast.CallOneArgBlockNode;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

/**
 * @author NTT Data-Offshore
 *
 * https://developers.google.com/places/web-service/search
 *
 * The Google Places API Text Search Service is a web service that returns information about a set of places
 * based on a string — for example "pizza in New York" or "shoe stores near Ottawa" or "123 Main Street".
 * The service responds with a list of places matching the text string and any location bias that has been set.
 *
 *
 */

public class GMapsTextSearchSteps {

    private final String BASE_URI = "https://maps.googleapis.com";
    private final String RESOURCE = "/place/textsearch";
    private final String KEY = "AIzaSyA3y0nBusSzR-lSKD39UHyC0SoYB-wtFn";

   // private final String textSearchParameter="Restaurants in London";



    private Response resp;

    @Step("Search \"{0}\" using Google Maps API")
    public void searchText(String textSearchParameter){


        resp=SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .queryParam("query",textSearchParameter)
                .and()
                .param("key",KEY)
                .when()
                .get(BASE_URI+RESOURCE);
    }

    @Step("The request was successful")
    public void searchRequestSuccessful(){
        resp
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step("Obtain the list of all the results")
    public void getListOfResultFromResponse(){

        String jsonResponse = resp.then().extract().response().asString();

        JsonPath jP = new JsonPath(jsonResponse);

        //List<String> len= jP.getList("results");
        int resultSize=jP.getList("results").size();

        System.out.println("********************"+resultSize);
    }


}
