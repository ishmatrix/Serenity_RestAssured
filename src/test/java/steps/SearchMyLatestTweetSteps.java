package steps;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.mockito.exceptions.Reporter;

import static org.hamcrest.Matchers.equalTo;

public class SearchMyLatestTweetSteps {

    private final String BASE_URI = "https://api.twitter.com";
    private final String RESOURCE = "/1.1/statuses/home_timeline.json";
    private final String consumerKey = "aPBoAo1iegytyBV5KfbfqRWL3";
    private final String consumerSecret = "1sITXWJXiUGtai6D8SPegU3nYo3nSYGsedjLvsrDXZxkdzEuKx";
    private final String accessToken = "958364508195454977-cSFzqdmJDCk6FnCAHKHIMrj2sX1t8nR";
    private final String tokenSecret = "Xec7eqc4glS3jUZG4L2AqIG5gFwwhWrDJBEFdfGXAwA7J";
    private String latestTweet;
    private String idLatestTweet;

    private Response resp;

    @Step("Search all my tweets")
    public void trySearchingLatestTweet() {
        resp = SerenityRest
                .given()
                .auth()
                .oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                .and()
                .queryParam("count", "1")
                .when()
                .get(BASE_URI + RESOURCE);

    }

    @Step("Check if the search for latest tweet was successful")
    public void tweetSearchIsSuccessful() {
        resp
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step("Display the latest tweet ")
    public void fetchLatestTweetAndItsID() {

        //here I am converting the complete json response in String format so I can play with it later
        String jsonResponse = resp.then().extract().response().asString();

        JsonPath jP = new JsonPath(jsonResponse);

        latestTweet = jP.get("text").toString();
        idLatestTweet = jP.get("id").toString();

        System.out.println(latestTweet);
        System.out.println(idLatestTweet);



    }

    @Step("Latest Tweet: \"{0}\"")
    public void logTweet(String info){

    }

}
