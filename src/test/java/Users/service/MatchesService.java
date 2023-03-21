package Users.service;

import Users.client.MatchesClient;
import io.restassured.response.Response;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import pojo.get.GetMatchInfoResponse;

import java.util.concurrent.TimeUnit;

public class MatchesService {
    public CreateMatchResponse createMatch(CreateMatchRequestBody createMatchRequestBody)
    {

        Response response=new MatchesClient().CreateMatchClient(createMatchRequestBody);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.SECONDS);
        CreateMatchResponse createMatchResponse=response.as(CreateMatchResponse.class);
        createMatchResponse.setStatusCode(statusCode);
        createMatchResponse.setResponseTime(responseTime);

       return createMatchResponse;
    }

    public GetMatchInfoResponse getMatchInfo()

    {
        Response response=new MatchesClient().getMatchInfo();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.SECONDS);
        GetMatchInfoResponse getMatchInfoResponse=response.as(GetMatchInfoResponse.class);
        getMatchInfoResponse.setStatusCode(statusCode);
        getMatchInfoResponse.setResponseTime(responseTime);

        return getMatchInfoResponse;
    }


}
