package steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.rest.stubs.ResponseStub;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.equalTo;

public class SearchAccountDetailsSteps {

    //Initialize all pre-requisite

    private final String BASE_URI="http://poctest.mocklab.io";
    private final String RESOURCE="/bankaccounts/";
    private final String paramKey_account_id="account_id";
    private final String paramValue_account_id="460000000048001";



    private Response res;

    @Step("Request account details by providing account id ")
    public void sendGetRequestForAccountDetails(){


        res=  SerenityRest
                .given()
                .queryParam(paramKey_account_id,paramValue_account_id)
                .when()
                .get(BASE_URI+RESOURCE);

    }

    @Step("Verify the request is successful")
    public void verifySuccessStatus(){

        res
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("message",equalTo("success"));


    }

    @Step("Record all the details mapped to that account id")
    public void recordAccountDetails(){



    }



}
