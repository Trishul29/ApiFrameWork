package modules.service;
import io.restassured.response.Response;
import modules.client.CommentaryClient;
import pojo.get.Match.GetMatchCommentaryResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class CommentaryService {

    public GetMatchCommentaryResponse getMatchCommentary()
    {
        Response response= new CommentaryClient().getCommentary();
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        GetMatchCommentaryResponse getMatchCommentaryResponse = response.as(GetMatchCommentaryResponse.class);
        getMatchCommentaryResponse.setStatusCode(statusCode);
        getMatchCommentaryResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getMatchCommentaryResponse;
    }

}
