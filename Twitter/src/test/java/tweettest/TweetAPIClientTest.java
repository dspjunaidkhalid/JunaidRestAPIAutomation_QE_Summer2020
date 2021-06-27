package tweettest;

import base.RestAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tweet.TweetAPIClient;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class TweetAPIClientTest extends RestAPI {
    private TweetAPIClient tweetAPIClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClient();
    }


    @Test @Ignore
    public void testUserCanTweetSuccessfully() {
        // User sent a tweet
        String tweet = "Pakistan is great Country in World";
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(200);

    }
    @Test @Ignore
    public void testUserCanTweetSuccessfullyHeader() {
        this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
        String tweet = "Pakistan is great Country in World";
        ValidatableResponse response = this.tweetAPIClient.getUserTimeLineHeaderTweet(tweet);
        response.statusCode(200);

    }
    @Test  @Ignore
    public void testUserTimeLineTweet() {
        this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
        String tweet = "Pakistan is great Country in World";
        ValidatableResponse response = this.tweetAPIClient.checkUserTimeLineTweet(tweet);
        response.statusCode(200);

    }

    @Test @Ignore
    public void testGetUserIdTimeLineTweet(){
        this.tweetAPIClient.getUserIdTimeLineTweet();
        ValidatableResponse response=this.tweetAPIClient.getUserIdTimeLineTweet();
        response.statusCode(200).log().all();
        String expectedResult = "1407083284488667138";
        String actualResult = response.extract().body().path("[0].id_str");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

    } @Test @Ignore
    public void testGetUserIdTimeLineTweetHeader(){
        this.tweetAPIClient.getUserIdTimeLineTweet();
        ValidatableResponse response=this.tweetAPIClient.getUserIdTimeLineTweetHeader("[0].id_str");
        response.statusCode(200).log().all();
        String expectedResult = "1407789991737106432";
        String actualResult = response.extract().body().path("[0].id_str");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

    } @Test  @Ignore
    public void testGetUserIdTimeLineTweetTime(){
        this.tweetAPIClient.getUserIdTimeLineTweet();
        ValidatableResponse response=this.tweetAPIClient.getUserIdTimeLineTweetTime("[0].id_str");
        response.statusCode(200).log().all();
        String expectedResult = "1407789991737106432";
        String actualResult = response.extract().body().path("[0].id_str");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

    }

////


    //Create: POST
    @Test  @Ignore
    public void testGetUserTimeLineTweet() {
        // Status code should be 200
        this.tweetAPIClient.getUserTimeLineTweet();
        ValidatableResponse response = this.tweetAPIClient.getUserTimeLineTweet();
        // Log All to get Response Details with Response body
        response.statusCode(200).log().all();
        //response.log().all();
        // verify Status code
        response.statusCode(200);
        // To Print response body as Pretty format
        //System.out.println(response.extract().body().asPrettyString());
        // String expectedResult = "We are learning AUTOMATION in nyc";
        String expectedResult = "C0DEED";
        // String expectedResult = "Last week jun 12-18, more than 23 lakh vaccinations were done at a rate of 332,877 per day. This is the highest so… https://t.co/gZQMdt7Upo";
        // String actualResult = response.extract().body().path("[2].id_str");
        String actualResult = response.extract().body().path("[0].user.profile_background_color");
        // String actualResult = response.extract().body().path("[0].user.name");
        //String actualResult = response.extract().body().path("[0].text");
        //boolean actualResult= response.extract().body().asPrettyString().contains("text");
        //Assert.assertEquals(true,actualResult);
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

        // HasItems to check multiple value
        // https://blog.darjan-dzamto.com/working-with-rest-assured-matchers/
        //response.body("[3].text",hasItems("We are learning Rest API Automation and Junaid is the team Lead1"));
        //response.body("[3].text",hasItems("We are learning Rest API Automation and Junaid is the team Lead1","ddd","eee"));
        //response.body("[3].user",hasItem("name"));

    }

    @Test @Ignore
    public void testGetUserMentionTimeLine(){
        this.tweetAPIClient.getUserMentionTimeLine();
        ValidatableResponse response=this.tweetAPIClient.getUserMentionTimeLine();
        response.statusCode(200).log().all();
        // String expectedResult ="";
//        String actualResult=response.extract().body().path();
//        System.out.println(actualResult);
//        Assert.assertEquals(actualResult,expectedResult,"Text value not match");

    }
    @Test @Ignore
    public void testGetUserMentionTimeLineHeader() {
        this.tweetAPIClient.getUserMentionTimeLine();
        ValidatableResponse response = this.tweetAPIClient.getUserMentionTimeLineHeader("endPoint");
        response.statusCode(200).log().all();

    }
    @Test @Ignore
    public void testGetUserMentionTimeLineTime() {
        this.tweetAPIClient.getUserMentionTimeLine();
        ValidatableResponse response = this.tweetAPIClient.getUserMentionTimeLinerTime("endPoint");
        response.statusCode(200).log().all();

    }



    // Delete a tweet from user twitter
//       @Test
//       public void testDeleteTweet() {
//           String tweet = "We are learning AUTOMATION in nyc";
//        ValidatableResponse response=this.tweetAPIClient.deleteTweet(1406285511350796290l);
//        response.log().all();
//        response.log().all();
//           System.out.println(response.extract().body().asPrettyString());
//           // Verify that the tweet is not successful
//           response.statusCode(200);
//           String actualTweet=response.extract().body().path("text");
//           Assert.assertNotEquals(actualTweet,tweet,"Tweet is not match");

    @Test @Ignore
    public void testDeleteTweet() {
        // User sent a tweet
        String tweet = "We are learning Rest API Automation and Junaid is the team Lead1";
        ValidatableResponse response = this.tweetAPIClient.deleteTweet(1406023535156465670l);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
    }
    @Test @Ignore
    public void testDeleteTweetHeader() {
        // User sent a tweet
        String tweet = "Manhattan is good place to make money";
        ValidatableResponse response = this.tweetAPIClient.deleteTweetHeader(   1406023535156465670l,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
    }
    @Test @Ignore
    public void testDeleteTweetTime() {
        // User sent a tweet
        String tweet = "Manhattan is good place to make money";
        ValidatableResponse response = this.tweetAPIClient.deleteTweetTime(1406023535156465670l,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
    }

    // GET STATUS ID ENDPOINT
    @Test @Ignore
    public void testGetUserStatusId(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusId(1407789991737106432L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    @Test @Ignore
    public void testGetUserStatusIdHeader(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusIdHeader(1407789991737106432L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    @Test @Ignore
    public void testGetUserStatusIdTime(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusIdTime(1407789991737106432L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test  @Ignore
    public void testGetUserStatusesLookup() {
        ValidatableResponse response = this.tweetAPIClient.getUserStatusId(1407856547053674496L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    @Test @Ignore
    public void testGetUserStatusesLookupHeader() {
        ValidatableResponse response = this.tweetAPIClient.getUserStatusesLookupHeader(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    @Test @Ignore
    public void testGetUserStatusesLookupTime(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusesLookupTime(1407856547053674496L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }

    @Test  @Ignore
    public void testResponseTime(){
        ValidatableResponse response= this.tweetAPIClient.responseTimeCheck(tweetAPIClient.DELETE_TWEET_ENDPOINT);
    }

    @Test @Ignore
    public void testHeaderValue(){
        this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
    }

    @Test @Ignore
    public void testGetRetweetId() {

        ValidatableResponse response = this.tweetAPIClient.getRetweetId(1408114859003289613L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testGetRetweetIdHeader() {
        ValidatableResponse response = this.tweetAPIClient.getRetweetIdHeader(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    @Test @Ignore
    public void testGetRetweetIdTime(){
        ValidatableResponse response =  this.tweetAPIClient.getRetweetIdTimer(1407856547053674496L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
     //   response.statusCode(200);

    }
//===================================================================================================

    @Test @Ignore
    public void testGetUnRetweetId() {

        ValidatableResponse response = this.tweetAPIClient.getUnRetweetId(1406392715596767234L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());

    }

 @Test @Ignore
    public void testGetUnRetweetIdHeader() {

        ValidatableResponse response = this.tweetAPIClient.getUnRetweetIdHeader(1407856547053674496l,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
    }

 @Test @Ignore
    public void testGetUnRetweetIdTime() {

        ValidatableResponse response = this.tweetAPIClient.getUnRetweetIdTimer(1407856547053674496L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
    }

//================================================================================================
     @Test @Ignore
    public void testGetUnRetweetId1() {

        ValidatableResponse response = this.tweetAPIClient.getRetweetId1(1406346028576608257L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
         response.statusCode(200);

         Response response1 = given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                 .when().get(this.baseUrl+tweetAPIClient.GET_STATUSES_RETWEET_ID_ENDPOINT);
         // Response response2=  response;
         JsonPath pathEvaluator= response1.jsonPath();
         String property= pathEvaluator.get("[0].text");
         System.out.println("Property value : "+property);
    }
    @Test @Ignore
    public void testGetUnRetweetId1Header() {

        ValidatableResponse response = this.tweetAPIClient.getRetweetId1Header(1406346028576608257L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    @Test @Ignore
    public void testGetUnRetweetId1Time() {

        ValidatableResponse response = this.tweetAPIClient.getRetweetId1Timer(1406346028576608257L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
//============================================================================================================
@Test @Ignore
    public void testGetRetweetForMe() {

    ValidatableResponse response = this.tweetAPIClient.getRetweetForMe(1406022917348016136L);
    response.log().all();
    System.out.println(response.extract().body().asPrettyString());
    response.statusCode(200);
}
    @Test @Ignore
    public void testGetRetweetForMeHeader() {

        ValidatableResponse response = this.tweetAPIClient.getRetweetForMeHeader(1406346028576608257L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    @Test @Ignore
    public void testGetRetweetForMeTime() {

        ValidatableResponse response = this.tweetAPIClient.getRetweetForMeTimer(1406346028576608257L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    //===========================================================================================
   @Test @Ignore
    public void testStatusRetweetIdsEndPoint(){

        ValidatableResponse response = this.tweetAPIClient.getStatusRetweetIdsEndPoint(1408506551044804613L);
        response.log().all();
    System.out.println(response.extract().body().asPrettyString());
    response.statusCode(200);

}
    @Test @Ignore
    public void testStatusRetweetIdsEndPointHeader() {

        ValidatableResponse response = this.tweetAPIClient.getStatusRetweetIdsEndPointHeader(1408506551044804613L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    @Test @Ignore
    public void testStatusRetweetIdsEndPointTime() {

        ValidatableResponse response = this.tweetAPIClient.getStatusRetweetIdsEndPointTimer(1408506551044804613L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
//==========================================================================================================

    @Test
    public void testpostStatusFavourityDestroy(){
        // User sent a tweet
        String Name = "Hettaa Birthday completed Nicely";
        ValidatableResponse response = this.tweetAPIClient.postStatusFavourityDestroy(1406346028576608257l);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,Name,"Tweet is not match");

    }







//    @Test @Ignore
//    public void testGetRetweetForMe() {
//
//        ValidatableResponse response = this.tweetAPIClient.getRetweetForMe(1406022917348016136L);
//        response.log().all();
//        System.out.println(response.extract().body().asPrettyString());
//        response.statusCode(200);
//    }


















//==============================================================================================================




















//    @Test @Ignore
//    public void testGetUserTimeLineTweet() {
//        // Status code should be 200
//        this.tweetAPIClient.getUserTimeLineTweet();
//        ValidatableResponse response = this.tweetAPIClient.getUserTimeLineTweet();
//        // Log All to get Response Details with Response body
//        response.statusCode(200).log().all();
//        // verify Status code
//        response.statusCode(200);
//        // To Print response body as Pretty format
//        //System.out.println(response.extract().body().asPrettyString());
//       // String expectedResult= "We are learning Rest API Automation and Junaid is the team Lead1";
//       // String expectedResult= "We are studying Hashem,Junaid,Akbar";
//        String expectedResult="1406022917348016136";
//        String actualResult= response.extract().body().path("[2].id_str");
//        //boolean actualResult= response.extract().body().asPrettyString().contains("text");
//        //Assert.assertEquals(true,actualResult);
//        System.out.println(actualResult);
//        Assert.assertEquals(actualResult,expectedResult,"Text value not match");
//
//        // HasItems to check multiple value
//        //response.body("[3].text",hasItems("We are learning Rest API Automation and Junaid is the team Lead1"));
//
//
//    }
//
//    @Test @Ignore
//    public void testUserCanTweetSuccessfully() {
//        // User sent a tweet
//       // String tweet = "We are learning Rest API Automation and Junaid is the team Lead1";
//        String tweet = "Hettaa Birthday completed Nicely";
//        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
//        response.statusCode(200);
//    }
//    @Test @Ignore
//    public void testDeleteTweet() {
//        // User sent a tweet
//        String tweet = "Junaid offering Kaccha Bryanai do every body";
//        ValidatableResponse response = this.tweetAPIClient.deleteTweet(1406023535156465670l);
//        response.log().all();
//        System.out.println(response.extract().body().asPrettyString());
//        // Verify that the tweet is not successful
//        response.statusCode(200);
//        String actualTweet= response.extract().body().path("text");
//        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
//
//    }
//
//
//    @Test @Ignore
//    public void testResponseTime(){
//        ValidatableResponse response= this.tweetAPIClient.responseTimeCheck(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
//    }
//
//    @Test @Ignore
//    public void testHeaderValue(){
//
//        this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
//    }
//    @Test
//    public void testPropertyFromResponse(){
//        // User sent a tweet
//        String tweet = "We are learning Rest API Automation and Hashem is the team Lead" + UUID.randomUUID().toString();
//        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
//        System.out.println(response.extract().body().asPrettyString());
//        System.out.println(response.extract().body().asPrettyString().contains("id"));
//        // Verify that the tweet is successful
//        response.statusCode(200);
//
//        // this.tweetAPIClient.checkProperty(tweetAPIClient.CREATE_TWEET_ENDPOINT,"text");
//
//        Response response1 = given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+tweetAPIClient.CREATE_TWEET_ENDPOINT);
//        // Response response2=  response;
//        JsonPath pathEvaluator= response1.jsonPath();
//        String property= pathEvaluator.get("[0].text");
//        System.out.println("Property value : "+property);
//    }




}
