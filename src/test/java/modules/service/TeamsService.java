package modules.service;
import io.qameta.allure.Allure;
import modules.client.TeamsClient;
import pojo.create.team.CreateTeamRequestBody;
import pojo.create.team.CreateTeamResponse;
import pojo.get.Team.GetTeamResponse;
import pojo.getAll.Teams.GetAllTeamResponse;
import io.restassured.response.Response;
import java.util.concurrent.TimeUnit;

import static org.testng.Reporter.log;

public class TeamsService {


    public GetTeamResponse getTeamById(String id) {
        Response response = new TeamsClient().getTeam(id);
        int statusCode = response.statusCode();
        GetTeamResponse getTeamResponse= response.as(GetTeamResponse.class);
        getTeamResponse.setStatusCode(statusCode);
        return getTeamResponse;
    }
    public GetAllTeamResponse getAllTeam() {
        Response response = new TeamsClient().getTeams();
        int statusCode = response.statusCode();
        long responseTime= response.timeIn(TimeUnit.SECONDS);
        GetAllTeamResponse getAllTeamResponse= response.as(GetAllTeamResponse.class);
        getAllTeamResponse.setStatusCode(statusCode);
        getAllTeamResponse.setResponseTime(responseTime);
        return getAllTeamResponse;
    }

public CreateTeamResponse createTeam(CreateTeamRequestBody createTeamRequestBody)
{

    Response response=new TeamsClient().CreateTeamClient(createTeamRequestBody);
    int statusCode=response.getStatusCode();
    long responseTime= response.timeIn(TimeUnit.SECONDS);
    CreateTeamResponse createTeamResponse=response.as(CreateTeamResponse.class);
    createTeamResponse.setStatusCode(statusCode);
    createTeamResponse.setResponseTime(responseTime);
    return createTeamResponse;
}


}

