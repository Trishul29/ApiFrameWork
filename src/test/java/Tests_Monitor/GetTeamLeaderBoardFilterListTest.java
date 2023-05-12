package Tests_Monitor;

import com.github.javafaker.Faker;
import modules.service.TeamsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Team.GetTeamLeaderBoardFilterResponse;

public class GetTeamLeaderBoardFilterListTest {
    TeamsService teamsService;


    @BeforeClass
    public void beforeClass() {

        teamsService = new TeamsService();


    }

    @Test
    public void shouldGetTeamLeaderBoardFilterTest() {

        GetTeamLeaderBoardFilterResponse getTeamLeaderBoardFilterResponse = teamsService.getTeamLeaderBoardFilterResponseService();
        getTeamLeaderBoardFilterResponse.assertGetTeamLeaderBoardFilterResponse();
    }

}
