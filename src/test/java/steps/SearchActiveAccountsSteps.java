package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class SearchActiveAccountsSteps {

    //Initialize all prerequsite

    private final String BASE_URI="http://poctest.mocklab.io";
    private final String RESOURCE="/bankaccounts";
    private final String cookieValue="9999999999A";
    private final String paramKey_filter_by="filter_by";
    private final String paramValue_filter_by="Status.All";

    private Response res;

    @Step("Given the user has an active session send a get request ")
    public void sendGetRequestForAllActiveAccounts(){

        res=  SerenityRest
                .given()
                .cookie(cookieValue)
                .param(paramKey_filter_by,paramValue_filter_by)
                .when()
                .post(BASE_URI+RESOURCE);

    }


}
