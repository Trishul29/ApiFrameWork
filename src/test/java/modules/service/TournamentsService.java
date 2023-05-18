package modules.service;
import modules.client.TournamentsClient;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.create.tournament.CreateTournamentResponse;
import pojo.get.Tournaments.GetPointsOfTournamentResponse;
import pojo.get.Tournaments.GetTournamentAggregatedStatResponse;
import pojo.get.Tournaments.GetTournamentLeaderBoardFilterListResponse;
import pojo.get.Tournaments.GetTournamentLeaderBoardResponse;
import pojo.getAll.tournaments.GetTournamentsResponse;
import pojo.update.tournament.EditTournamentRequestBody;
import pojo.update.tournament.EditTournamentResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class TournamentsService {
    public GetTournamentsResponse getTournaments(String filter)
    {
        Response response= new TournamentsClient().getAllTournaments(filter);
        int statusCode=response.statusCode();
      long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
      GetTournamentsResponse getTournamentsResponse = response.as(GetTournamentsResponse.class);
        getTournamentsResponse.setStatusCode(statusCode);
        getTournamentsResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTournamentsResponse;
    }

    public CreateTournamentResponse createTournament(CreateTournamentRequestBody createTournamentRequestBody)
    {

        Response response=new TournamentsClient().createTournament(createTournamentRequestBody);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        CreateTournamentResponse createTournamentResponse=response.as(CreateTournamentResponse.class);
        createTournamentResponse.setStatusCode(statusCode);
        createTournamentResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return createTournamentResponse;
    }

    public GetPointsOfTournamentResponse getTournamentPoints()
    {
        Response response=new TournamentsClient().getPoints();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetPointsOfTournamentResponse getPointsOfTournamentResponse  = response.as(GetPointsOfTournamentResponse.class);
        getPointsOfTournamentResponse.setStatusCode(statusCode);
        getPointsOfTournamentResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getPointsOfTournamentResponse;
    }

    public GetPointsOfTournamentResponse getTournamentRunQuotient()
    {
        Response response=new TournamentsClient().getRunQuotient();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetPointsOfTournamentResponse getPointsOfTournamentResponse  = response.as(GetPointsOfTournamentResponse.class);
        getPointsOfTournamentResponse.setStatusCode(statusCode);
        getPointsOfTournamentResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getPointsOfTournamentResponse;
    }

    public EditTournamentResponse editTournament(EditTournamentRequestBody editTournamentRequestBody)
    {

        Response response = new TournamentsClient().editTournament(editTournamentRequestBody );
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        EditTournamentResponse editTournamentResponse=response.as(EditTournamentResponse.class);
        editTournamentResponse.setStatusCode(statusCode);
        editTournamentResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return  editTournamentResponse;
    }

    public GetTournamentAggregatedStatResponse getAggregateStats()
    {
   Response response= new TournamentsClient().getStats();
   GetTournamentAggregatedStatResponse getTournamentAggregatedStatResponse=response.as(GetTournamentAggregatedStatResponse.class);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        getTournamentAggregatedStatResponse.setStatusCode(statusCode);
        getTournamentAggregatedStatResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTournamentAggregatedStatResponse;

    }
    public GetTournamentLeaderBoardFilterListResponse getTournamentLeaderBoardFilterListService()
    {
        Response response= new TournamentsClient().getTournamentFilterList();
        GetTournamentLeaderBoardFilterListResponse getTournamentLeaderBoardFilterListResponse=response.as(GetTournamentLeaderBoardFilterListResponse.class);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        getTournamentLeaderBoardFilterListResponse.setStatusCode(statusCode);
        getTournamentLeaderBoardFilterListResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTournamentLeaderBoardFilterListResponse;
    }

    public GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponseService(String filter, String subFilter)
    {
        Response response= new TournamentsClient().getTournamentLeaderBoard(filter,subFilter);
        GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse=response.as(GetTournamentLeaderBoardResponse.class);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        getTournamentLeaderBoardResponse.setStatusCode(statusCode);
        getTournamentLeaderBoardResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTournamentLeaderBoardResponse;
    }

}
