package modules.service;

import io.restassured.response.Response;
import modules.client.GooglePlaceClient;
import modules.client.LeaderBoardClient;
import pojo.getAll.googleplace.GetGooglePlaceDetailsResponse;
import pojo.getAll.googleplace.GetGooglePlaceListResponse;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class GoolePlaceService {

    public GetGooglePlaceListResponse getPlaceList()
    {

        Response response=  new GooglePlaceClient().getList();
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        GetGooglePlaceListResponse getGooglePlaceListResponse = response.as(GetGooglePlaceListResponse.class);
        getGooglePlaceListResponse.setStatusCode(statusCode);
        getGooglePlaceListResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getGooglePlaceListResponse;


    }
    public GetGooglePlaceDetailsResponse getPlaceDetails()
    {

        Response response=  new GooglePlaceClient().getDetails();
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        GetGooglePlaceDetailsResponse getGooglePlaceDetailsResponse = response.as(GetGooglePlaceDetailsResponse.class);
        getGooglePlaceDetailsResponse.setStatusCode(statusCode);
        getGooglePlaceDetailsResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getGooglePlaceDetailsResponse;


    }
}
