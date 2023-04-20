package Tests_Update;

import modules.service.TeamsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Team.GetTeamPlayerAccordingToGameTypeResponse;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;

public class GetTeamPlayerAccordingToGameTypeTest {
    TeamsService teamsService;
    @BeforeClass
    public void beforeClass()
    {
        teamsService=new TeamsService();
    }
    @Test

    public void shouldGetTeamPlayerAccordingToGameType()
    {

        GetTeamPlayerAccordingToGameTypeResponse getTeamPlayerAccordingToGameTypeResponse = teamsService.GetTeamPlayerAccordingToGameTypeService();
getTeamPlayerAccordingToGameTypeResponse.assertGetTeamPlayerAccordingToGameTypeResponse();
    }
}
