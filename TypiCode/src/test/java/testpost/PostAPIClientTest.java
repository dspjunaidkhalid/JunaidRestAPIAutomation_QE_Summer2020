package testpost;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import typecode.PostPojo;
import typecode.PostsAPIClient;

public class PostAPIClientTest {


    private PostsAPIClient postsAPIClient;

    @BeforeClass
    public void setUpPostsAPI(){
        this.postsAPIClient=new PostsAPIClient();
    }

    @Test
    public void testGetAllPosts(){
        ValidatableResponse response=this.postsAPIClient.getAllPosts();
        response.statusCode(HttpStatus.SC_OK);
        response.statusCode(200);
    }

    // write a test that creates a post
    @Test
    public void testUserCanCreateAPostUsingPojoSuccessfully() {
        PostPojo obj = new PostPojo(11, 101, "test title", "test body");

        ValidatableResponse response = this.postsAPIClient.createPost(obj);
        response.statusCode(HttpStatus.SC_CREATED);
        response.statusCode(201);
    }

    @Test
    public void testUserCanCreateAPostSuccessfully() {
        int userId = 11;
        String title = "test title";
        String body = "test body";
        String stName = "Junaid";

        JSONObject json = new JSONObject();
        json.put("userId", userId);
        json.put("id", 101);
        json.put("title", title);
        json.put("body", body);
        json.put("stName",stName);

        ValidatableResponse response = this.postsAPIClient.createPost(json);
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(HttpStatus.SC_CREATED);
        // Verify property
        int actualUserId = response.extract().body().path("userId");
        String actualTitle = response.extract().body().path("title");
        String actualBody = response.extract().body().path("body");
        Assert.assertEquals(actualUserId, userId);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualBody, body);
    }






















}
