package modules.service;

import io.qameta.allure.Allure;
import modules.client.PostsClient;
import pojo.create.post.CreatePostRequestBody;
import pojo.create.post.CreatePostResponse;
import pojo.create.post.CreateReplyPostRequestBody;
import pojo.create.post.CreateReplyPostResponse;
import pojo.getAll.posts.GetAllPostResponse;
import io.restassured.response.Response;
import java.util.concurrent.TimeUnit;


public class PostsService {



    public  GetAllPostResponse getAllPost() {

        Response response = new PostsClient().getAll("https://dev-scoring.platform.myysports.com/api/v3.0/post");
        int statusCode = response.statusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetAllPostResponse getAllPostResponse = response.as(GetAllPostResponse.class);
        getAllPostResponse.setResponseTime(responseTime);
        getAllPostResponse.setStatusCode(statusCode);
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");
return getAllPostResponse;
    }

    public CreatePostResponse createPost(CreatePostRequestBody createPostRequestBody)
    {

        Response response=new PostsClient().createPost(createPostRequestBody);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        CreatePostResponse  createPostResponse=response.as(CreatePostResponse.class);
        createPostResponse.setStatusCode(statusCode);
        createPostResponse.setResponseTime(responseTime);
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");
        return createPostResponse;
    }

    public CreateReplyPostResponse createReplyPost(CreateReplyPostRequestBody createReplyPostRequestBody)
    {
        Response response=new PostsClient().createReplyPost(createReplyPostRequestBody);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        CreateReplyPostResponse  createReplyPostResponse=response.as(CreateReplyPostResponse.class);
        createReplyPostResponse.setStatusCode(statusCode);
        createReplyPostResponse.setResponseTime(responseTime);
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");
        return createReplyPostResponse;
    }




}
