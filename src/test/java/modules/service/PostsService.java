package modules.service;

import io.qameta.allure.Allure;
import modules.client.PostsClient;
import pojo.create.post.*;
import pojo.getAll.posts.GetAllPostResponse;
import io.restassured.response.Response;
import pojo.getAll.posts.GetShowListResponse;
import util.AllureUtility;
import util.FileUtility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class PostsService {

    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    Properties properties= FileUtility.loadProperties(propertyPath);

    public  GetAllPostResponse getAllPost(String filter) {

        Response response = new PostsClient().getAll(properties.getProperty("base_uri")+properties.getProperty("basepath_get_all_post"),filter);
        int statusCode = response.statusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetAllPostResponse getAllPostResponse = response.as(GetAllPostResponse.class);
        getAllPostResponse.setResponseTime(responseTime);
        getAllPostResponse.setStatusCode(statusCode);
        new AllureUtility().getResponseTime(responseTime);
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
        new AllureUtility().getResponseTime(responseTime);
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
        new AllureUtility().getResponseTime(responseTime);
        return createReplyPostResponse;
    }

    public GiveLikeResponse giveLikeToPost()
    {
        Response response=new PostsClient().likePost();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GiveLikeResponse  giveLikeResponse=response.as(GiveLikeResponse.class);
        giveLikeResponse.setStatusCode(statusCode);
        giveLikeResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return  giveLikeResponse;
    }

    public GetShowListResponse getShowList()
    {
        Response response=new PostsClient().getShow();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetShowListResponse getShowListResponse=response.as(GetShowListResponse.class);
        getShowListResponse.setStatusCode(statusCode);
        getShowListResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return  getShowListResponse;
    }




}
