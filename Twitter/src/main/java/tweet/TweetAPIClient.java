package tweet;

import base.RestAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class TweetAPIClient extends RestAPI {

    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-home_timeline
    //GET statuses/home_timeline
    public final String GET_USER_TWEET_ENDPOINT = "/statuses/home_timeline.json";
    private final String GET_USER_ID_ENDPOINT = "/statuses/user_timeline.json";

    //https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-mentions_timeline
    private final String GET_USER_MENTION_ENDPOINT = "/statuses/mentions_timeline.json";

    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-destroy-id
    // DELETE / Destroy : Delete or Post
    public final String DELETE_TWEET_ENDPOINT = "/statuses/destroy.json";

    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-update
    // Create: POST
    private final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";

    private final String GET_STATUS_ID_ENDPOINT ="/statuses/show.json";

    private final String GET_STATUSES_LOOKUP_ENDPOINT ="/statuses/lookup.json";

    private final String POST_STATUSES_RETWEET_ID_ENDPOINT ="/statuses/retweet.json";
    //                                                      /statuses/retweet/:id.json
    private final String POST_STATUSES_UNRETWEET_ID_ENDPOINT ="/statuses/unretweet.json";

    public final String GET_STATUSES_RETWEET_ID_ENDPOINT ="/statuses/retweets.json";

    public final String GET_statuses_retweets_of_me ="/statuses/retweets_of_me.json";


    public final String GET_STATUSES_RETWEET_IDS_ENDPOINT="/statuses/retweeters/ids.json" ;

    //                                                   /statuses/retweeters/ids.json
    public final String POST_STATUSES_FAVORITIES_DESTROY_ENDPOINT="/favorites/destroy.json" ;




    // GET STATUS ID ENDPOINT
    public  ValidatableResponse getUserStatusId(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl+this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }
    public  ValidatableResponse getUserStatusIdHeader(Long tweetId,String endPoint) {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl + this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }

    public  ValidatableResponse getUserStatusIdTime(Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl+this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////

    public ValidatableResponse getStatusesLookup(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",tweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_LOOKUP_ENDPOINT).then().statusCode(200);

    }


    public  ValidatableResponse getUserStatusesLookupHeader(Long tweetId,String endPoint) {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl + this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }

    public  ValidatableResponse getUserStatusesLookupTime(Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl+this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////



    // GET All Tweet Information
    public ValidatableResponse getUserTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then().statusCode(200);
    }


    public ValidatableResponse getUserTimeLineHeaderTweet(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse checkUserTimeLineTweet(String endPoint){    //
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then();

    }



    public ValidatableResponse  getUserIdTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_ID_ENDPOINT).then().statusCode(200);
    }


    public ValidatableResponse  getUserIdTimeLineTweetHeader(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_ID_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse  getUserIdTimeLineTweetTime(String endPoint){
//        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+endPoint).then().extract().headers());
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_ID_ENDPOINT).then().statusCode(200);

    }


    public ValidatableResponse  getUserMentionTimeLine(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_MENTION_ENDPOINT).then();
    }

    public ValidatableResponse  getUserMentionTimeLineHeader(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_MENTION_ENDPOINT).then();
    }

    public ValidatableResponse  getUserMentionTimeLinerTime(String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_MENTION_ENDPOINT).then();
    }


    // Delete a tweet from user twitter
    public ValidatableResponse deleteTweet (Long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }
    public ValidatableResponse deleteTweetHeader (Long tweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }

    public ValidatableResponse deleteTweetTime (Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }





    //////////////////////////////////////////////////////////////////////////////////////


    // Create a Tweet from user twitter
    public ValidatableResponse createTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT).then();

    }
    public ValidatableResponse createTweetHeader(String tweet) {
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+tweet).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT).then();

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ValidatableResponse getRetweetId(Long reTweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().post(this.baseUrl+this.POST_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
    }
    public ValidatableResponse getRetweetIdHeader(Long reTweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().post(this.baseUrl+this.POST_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
    }
    public ValidatableResponse getRetweetIdTimer(Long reTweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().post(this.baseUrl+this.POST_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
    }

   //====================================================================================================

    public ValidatableResponse getUnRetweetId(Long reTweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().post(this.baseUrl+this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then().statusCode(200);
    }
    public ValidatableResponse getUnRetweetIdHeader(Long reTweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().post(this.baseUrl+this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then().statusCode(200);
    }
    public ValidatableResponse getUnRetweetIdTimer(Long reTweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().post(this.baseUrl+this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then().statusCode(200);
    }
//===========================================================================================================
       public ValidatableResponse getRetweetId1(Long reTweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
       }
    public ValidatableResponse getRetweetId1Header(Long reTweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
    }
    public ValidatableResponse getRetweetId1Timer(Long reTweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
    }
//========================================================================================================

    public ValidatableResponse getRetweetForMe(Long reTweetName){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("Name",reTweetName)
                .when().get(this.baseUrl+this.GET_statuses_retweets_of_me).then().statusCode(200);
    }
    public ValidatableResponse getRetweetForMeHeader(Long reTweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("Name",reTweetId)
                .when().get(this.baseUrl+this.GET_statuses_retweets_of_me).then().statusCode(200);
    }
    public ValidatableResponse getRetweetForMeTimer(Long reTweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("Name",reTweetId)
                .when().get(this.baseUrl+this.GET_statuses_retweets_of_me).then().statusCode(200);
    }
    //================================================================================================


    public ValidatableResponse getStatusRetweetIdsEndPoint(Long reTweetIds){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetIds)
                //.queryParam("count",reTweetIds)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_IDS_ENDPOINT).then().statusCode(200);

    }
    public ValidatableResponse getStatusRetweetIdsEndPointHeader(Long reTweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_IDS_ENDPOINT).then().statusCode(200);
    }
    public ValidatableResponse getStatusRetweetIdsEndPointTimer(Long reTweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",reTweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_IDS_ENDPOINT).then().statusCode(200);
    }
    //====================================================================================================
    public ValidatableResponse postStatusFavourityDestroy(Long TweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",TweetId)
                //.queryParam("count",reTweetIds)
                .when().post(this.baseUrl+this.POST_STATUSES_FAVORITIES_DESTROY_ENDPOINT).then().statusCode(200);

    }

//    public ValidatableResponse getUnRetweetId(Long reTweetId){
//        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .queryParam("id",reTweetId)
//                .when().post(this.baseUrl+this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then().statusCode(200);
//    }









    //Header Value
    public void headerValue(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
    }
    // Response Time Check
    public ValidatableResponse responseTimeCheck(String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then();
    }



























//=====================================================================================================

//    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-home_timeline
//    //GET statuses/home_timeline
//    public final String GET_USER_TWEET_ENDPOINT = "/statuses/home_timeline.json";
//
//    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-destroy-id
//    // DELETE / Destroy : Delete or Post
//    private final String DELETE_TWEET_ENDPOINT = "/statuses/destroy.json";
//
//    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-update
//    // Create: POST
//    public final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";
//
//    //https://developer.twitter.com/en/docs/twitter-api/v1/tweets/search/api-reference/get-search-tweets
//    //search API
//    public final String search_Tweet_Endpoint="/search/tweets.json";
//
//
//
//    // GET All Tweet Information
//    public ValidatableResponse getUserTimeLineTweet(){
//        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then().statusCode(200);
//    }
//
//    // Create a Tweet from user twitter
//    public ValidatableResponse createTweet(String tweet){
//        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .param("status",tweet)
//                .when().post(this.baseUrl+this.CREATE_TWEET_ENDPOINT).then();
//    }
//
////    public ValidatableResponse junaidTweet(String tweet){
////        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
////                .param("status",tweet)
////                .when().post(this.baseUrl+this.CREATE_TWEET_ENDPOINT).then();
////
////
////    }
//public ValidatableResponse deleteTweet(Long tweetId){
//    return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//            .queryParam("id",tweetId)
//            .when().post(this.baseUrl+this.DELETE_TWEET_ENDPOINT).then();
//}
//
//    // Response Time Check
//    public ValidatableResponse responseTimeCheck(String endPoint){
//        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
//        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+endPoint).then();
//    }
//
//    //Header Value
//    public void headerValue(String endPoint){
//        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+endPoint).then().extract().headers());
//    }
//
//    // Check Property
//    public void checkProperty(String endPoint, String prop){
//        Response response = given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+endPoint);
//        JsonPath pathEvaluator= response.jsonPath();
//        String property= pathEvaluator.get(prop);
//        System.out.println("Property value : "+property);
//    }


}
