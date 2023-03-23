package modules.service;
import modules.client.TournamentsClient;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.create.tournament.CreateTournamentResponse;
import pojo.getAll.tournaments.GetAllTournamentsResponse;

import java.util.concurrent.TimeUnit;

public class TournamentsService {
    public GetAllTournamentsResponse getAllTournaments()
    {
        Response response= new TournamentsClient().getAllTournaments();
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.SECONDS);
        GetAllTournamentsResponse getAllTournamentsResponse = response.as(GetAllTournamentsResponse.class);
        getAllTournamentsResponse.setStatusCode(statusCode);
        getAllTournamentsResponse.setResponseTime(responseTime);

        return getAllTournamentsResponse;
    }

    public CreateTournamentResponse createTournament(CreateTournamentRequestBody createTournamentRequestBody)
    {

        Response response=new TournamentsClient().createTournament(createTournamentRequestBody);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.SECONDS);
        CreateTournamentResponse createTournamentResponse=response.as(CreateTournamentResponse.class);
        createTournamentResponse.setStatusCode(statusCode);
        createTournamentResponse.setResponseTime(responseTime);
        return createTournamentResponse;
    }

}
