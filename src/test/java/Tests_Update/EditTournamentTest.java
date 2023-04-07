package Tests_Update;

import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.update.tournament.EditTournamentRequestBody;
import pojo.update.tournament.EditTournamentResponse;

public class EditTournamentTest {
TournamentsService tournamentsService;


    @BeforeClass
    public void beforeClass()
    {
tournamentsService=new TournamentsService();

    }
   // @Test
    public void shouldEditTournament()
    {
        EditTournamentRequestBody editTournamentRequestBody=new EditTournamentRequestBody.Builder().setTournamentStatus("pending").build();
EditTournamentResponse editTournamentResponse=tournamentsService.editTournament(editTournamentRequestBody);
editTournamentResponse.assertEditTournament(editTournamentRequestBody);
    }
}
