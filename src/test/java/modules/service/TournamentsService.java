package modules.service;
import Tests_Monitor.GetTournamentAggregatedStatTest;
import modules.client.TournamentsClient;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.create.tournament.CreateTournamentResponse;
import pojo.get.Tournaments.GetPointsOfTournamentResponse;
import pojo.get.Tournaments.GetTournamentAggregatedStatResponse;
import pojo.getAll.tournaments.GetAllTournamentsResponse;
import pojo.update.tournament.EditTournamentRequestBody;
import pojo.update.tournament.EditTournamentResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class TournamentsService {
    public GetAllTournamentsResponse getAllTournaments()
    {
        Response response= new TournamentsClient().getAllTournaments();
        int statusCode=response.statusCode();
      long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
      GetAllTournamentsResponse getAllTournamentsResponse = response.as(GetAllTournamentsResponse.class);
        getAllTournamentsResponse.setStatusCode(statusCode);
        getAllTournamentsResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getAllTournamentsResponse;
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

}
