package Tests_Monitor;
import io.qameta.allure.Step;
import modules.service.TeamsService;
import pojo.getAll.Teams.GetAllTeamResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetAllTeamsTest {
    private TeamsService teamsService;

    @BeforeClass
    public void beforeClass()
    {

       teamsService=new TeamsService();

    }

    @Test
    @Step("{0}")
    public void shouldGetAllTeams()
    {
        GetAllTeamResponse getAllTeamResponse = teamsService.getAllTeam();
       getAllTeamResponse.assertGetAllTeamResponse();
    }
}
