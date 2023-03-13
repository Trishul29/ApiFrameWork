package Users.service;

import Users.client.PostsClient;
import pojo.getAll.GetAllPostResponse;
import io.restassured.response.Response;


public class PostsService {



    public  GetAllPostResponse getAllPost() {


        Response response = new PostsClient().getAll("https://dev-scoring.platform.myysports.com/api/v3.0/post");

        int statusCode = response.statusCode();

        GetAllPostResponse getAllPostResponse = response.as(GetAllPostResponse.class);
getAllPostResponse.setStatusCode(statusCode);
        return getAllPostResponse;
    }


}
