package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.equalTo;

public class CreateAnAccountSteps {

    //Initialize all pre-requisite

    private final String BASE_URI="http://poctest.mocklab.io";
    private final String RESOURCE="/bankaccounts/";
    private final String cookieValue="Cookie=999999999A";
    private final String requestBody="{\n" +
            "      \"account_name\":\"Corporate Account\",\n" +
            "      \"account_type\":\"bank\",\n" +
            "      \"account_number\":\"80000009823\",\n" +
            "      \"currency_id\":460000000000097,\n" +
            "      \"description\":\"Salary details.\",\n" +
            "      \"bank_name\":\"Xavier Bank\",\n" +
            "      \"routing_number\":\"123456789\",\n" +
            "      \"is_primary_account\":false,\n" +
            "      \"is_paypal_account\":true,\n" +
            "      \"paypal_email_address\":\"johnsmith@zilliuminc.com\"\n" +
            "    }";



    private Response res;

    @Step("Request account details by providing account id ")
    public void sendPostRequestCreatingAccount(){


        res=  SerenityRest
                .given()
                .cookie(cookieValue)
                .when()
                .body(requestBody)
                .post(BASE_URI+RESOURCE);

    }

    @Step("Verify the request is successful")
    public void verifySuccessStatus(){

        res
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .assertThat()
                .body("message",equalTo("The account has been created"));


    }

    @Step("the new account is created")
    public void recordNewAccountDetails(){



    }
}
