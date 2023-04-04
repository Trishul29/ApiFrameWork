package Test_create;
import modules.service.TeamsService;
import org.testng.annotations.Test;
import pojo.create.team.CreateTeamRequestBody;
import pojo.create.team.CreateTeamResponse;


public class CreateTeamTest {
@Test
    public void shouldCreateTeam()

    {
        CreateTeamRequestBody createTeamRequestBody = new CreateTeamRequestBody.Builder().setLocation("53456517", 23.98476, 24.8764572, "MalviyaNagar").build();
        CreateTeamResponse createTeamResponse = new TeamsService().createTeam(createTeamRequestBody);
        createTeamResponse.assertTeamDetails(createTeamRequestBody);
    }
}
