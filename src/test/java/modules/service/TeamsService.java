package modules.service;

import io.qameta.allure.Allure;
import modules.client.TeamsClient;
import modules.client.TournamentsClient;
import pojo.create.team.CreateTeamRequestBody;
import pojo.create.team.CreateTeamResponse;
import pojo.get.Team.GetTeamLeaderBoardFilterResponse;
import pojo.get.Team.GetTeamLeaderBoardResponse;
import pojo.get.Team.GetTeamPlayerAccordingToGameTypeResponse;
import pojo.get.Team.GetTeamResponse;
import pojo.get.Tournaments.GetTournamentLeaderBoardFilterListResponse;
import pojo.getAll.Teams.GetAllTeamResponse;
import io.restassured.response.Response;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

import static org.testng.Reporter.log;

public class TeamsService {


    public GetTeamResponse getTeamById(String id) {
        Response response = new TeamsClient().getTeam(id);
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        int statusCode = response.statusCode();
        GetTeamResponse getTeamResponse = response.as(GetTeamResponse.class);
        getTeamResponse.setStatusCode(statusCode);
        new AllureUtility().getResponseTime(responseTime);
        return getTeamResponse;
    }

    public GetAllTeamResponse getAllTeam() {
        Response response = new TeamsClient().getTeams();
        int statusCode = response.statusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        GetAllTeamResponse getAllTeamResponse = response.as(GetAllTeamResponse.class);
        getAllTeamResponse.setStatusCode(statusCode);
        getAllTeamResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getAllTeamResponse;
    }

    public CreateTeamResponse createTeam(CreateTeamRequestBody createTeamRequestBody) {

        Response response = new TeamsClient().CreateTeamClient(createTeamRequestBody);
        int statusCode = response.getStatusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        CreateTeamResponse createTeamResponse = response.as(CreateTeamResponse.class);
        createTeamResponse.setStatusCode(statusCode);
        createTeamResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return createTeamResponse;
    }

    public GetTeamPlayerAccordingToGameTypeResponse GetTeamPlayerAccordingToGameTypeService() {
        Response response = new TeamsClient().GetTeamPlayerAccordingToGameTypeClient();
        GetTeamPlayerAccordingToGameTypeResponse getTeamPlayerAccordingToGameTypeResponse = response.as(GetTeamPlayerAccordingToGameTypeResponse.class);
        int statusCode = response.getStatusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        getTeamPlayerAccordingToGameTypeResponse.setStatusCode(statusCode);
        getTeamPlayerAccordingToGameTypeResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTeamPlayerAccordingToGameTypeResponse;
    }

    public GetTeamLeaderBoardFilterResponse getTeamLeaderBoardFilterResponseService()
    {
        Response response= new TeamsClient().getTeamLeaderBoardFilterList();
        GetTeamLeaderBoardFilterResponse getTeamLeaderBoardFilterResponse=response.as(GetTeamLeaderBoardFilterResponse.class);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        getTeamLeaderBoardFilterResponse.setStatusCode(statusCode);
        getTeamLeaderBoardFilterResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTeamLeaderBoardFilterResponse;
    }

    public GetTeamLeaderBoardResponse getTeamLeaderBoardService(String filter,String subFilter)
    {
        Response response= new TeamsClient().getTeamLeaderBoard(filter,subFilter);
        GetTeamLeaderBoardResponse getTeamLeaderBoardResponse=response.as(GetTeamLeaderBoardResponse.class);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        getTeamLeaderBoardResponse.setStatusCode(statusCode);
        getTeamLeaderBoardResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getTeamLeaderBoardResponse;



    }


}

