package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.equalTo;

public class PostATweetSteps {

    private final String BASE_URI="https://api.twitter.com";
    private final String RESOURCE="/1.1/statuses/update.json";
    private final String consumerKey="aPBoAo1iegytyBV5KfbfqRWL3";
    private final String consumerSecret="1sITXWJXiUGtai6D8SPegU3nYo3nSYGsedjLvsrDXZxkdzEuKx";
    private final String accessToken="958364508195454977-cSFzqdmJDCk6FnCAHKHIMrj2sX1t8nR";
    private final String tokenSecret="Xec7eqc4glS3jUZG4L2AqIG5gFwwhWrDJBEFdfGXAwA7J";

    private Response resp;


    @Step("Try to post a tweet- \"{0}\" ")
    public void tryPostingATweet(String myTweet){
        resp= SerenityRest
                .given()
                .auth()
                .oauth(consumerKey,consumerSecret,accessToken,tokenSecret)
                .and()
                .param("status",myTweet)
                .when()
                .post(BASE_URI+RESOURCE);

    }

    @Step("Check if the tweet is posted successfully")
    public void tweetIsPostedSuccessfully(){
        resp
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Step("Verify if the \"{0}\" was the tweet returned in the response ")
    public void verifyResponseTweet(String myTweet){
        resp
                .then()
                .assertThat()
                .body("text",equalTo(myTweet));
    }

    @Step("Verify if the {0} is the twitter handle in the response ")
    public void verifyTwitterHandle(String screenName){
        resp
                .then()
                .assertThat()
                .body("user.screen_name",equalTo(screenName));
    }

}
