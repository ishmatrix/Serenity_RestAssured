package stepDefs;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import static org.hamcrest.Matchers.equalTo;

public class TestIt {

    private final String BASE_URI="http://poctest.mocklab.io";
    private final String RESOURCE="/createbankaccounts/";
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
    @Test
    public void testHere(){


        JSONObject requestParams = new JSONObject();
        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://poctest.mocklab.io/createbankaccounts")
        .then().assertThat().statusCode(201);
                ;

    }
}
