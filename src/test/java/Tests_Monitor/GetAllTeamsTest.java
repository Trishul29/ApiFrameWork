package Tests_Monitor;

import Users.service.TeamsService;
import pojo.getAll.Teams.GetAllTeamResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetAllTeamsTest {
    private TeamsService teamsService;

    @BeforeClass
    public void beforeClass()
    {

       teamsService=new TeamsService();

    }

    @Test
    public void shouldGetAllTeams()
    {
        GetAllTeamResponse getAllTeamResponse = teamsService.getAllTeam();
        assertEquals(getAllTeamResponse.getStatusCode(),200);
        assertEquals(getAllTeamResponse.getSuccess(),"true");
    }
}
