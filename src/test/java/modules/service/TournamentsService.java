package modules.service;
import io.qameta.allure.Allure;
import modules.client.TournamentsClient;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.create.tournament.CreateTournamentResponse;
import pojo.get.Tournaments.GetPointsOfTournamentResponse;
import pojo.getAll.tournaments.GetAllTournamentsResponse;

import java.util.concurrent.TimeUnit;

public class TournamentsService {
    public GetAllTournamentsResponse getAllTournaments()
    {
        Response response= new TournamentsClient().getAllTournaments();
        int statusCode=response.statusCode();
      long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);

      String response_in_mili_seconds=Long.toString(responseTime);

      Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");


        GetAllTournamentsResponse getAllTournamentsResponse = response.as(GetAllTournamentsResponse.class);
        getAllTournamentsResponse.setStatusCode(statusCode);
        getAllTournamentsResponse.setResponseTime(responseTime);

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
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");
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
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");
        return getPointsOfTournamentResponse;
    }

}
