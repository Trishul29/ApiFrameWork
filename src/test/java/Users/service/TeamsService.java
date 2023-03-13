package Users.service;
import Users.client.TeamsClient;
import pojo.get.GetTeamResponse;
import pojo.getAll.GetAllTeamResponse;
import io.restassured.response.Response;
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
        GetAllTeamResponse getAllTeamResponse= response.as(GetAllTeamResponse.class);
        getAllTeamResponse.setStatusCode(statusCode);
        return getAllTeamResponse;
    }


}

