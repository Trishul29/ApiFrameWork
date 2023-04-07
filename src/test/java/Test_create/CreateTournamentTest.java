package Test_create;
import modules.service.TournamentsService;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.create.tournament.CreateTournamentResponse;
public class CreateTournamentTest {
   @Test
    @Step("perform createTournament test")
    public void shouldCreateTournament()

    {
        CreateTournamentRequestBody createTournamentRequestBody = new CreateTournamentRequestBody.Builder().build();
        CreateTournamentResponse createTournamentResponse = new TournamentsService().createTournament(createTournamentRequestBody);
        createTournamentResponse.assertCreateTournamentDetails(createTournamentRequestBody);
    }
}
