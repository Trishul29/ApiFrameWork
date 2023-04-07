package Test_create;
import com.github.javafaker.Faker;
import modules.service.TeamsService;
import org.testng.annotations.Test;
import pojo.create.team.CreateTeamRequestBody;
import pojo.create.team.CreateTeamResponse;

import java.util.Locale;


public class CreateTeamTest {
@Test
    public void shouldCreateTeam()

    {
        CreateTeamRequestBody createTeamRequestBody = new CreateTeamRequestBody.Builder().setLocation("53456517", 23.98476, 24.8764572,  Faker.instance(new Locale("en_IND")).address().streetAddress()).build();
        CreateTeamResponse createTeamResponse = new TeamsService().createTeam(createTeamRequestBody);
        createTeamResponse.assertTeamDetails(createTeamRequestBody);
    }
}
