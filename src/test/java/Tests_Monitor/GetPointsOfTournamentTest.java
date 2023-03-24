package Tests_Monitor;

import io.qameta.allure.Step;
import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetPointsOfTournamentResponse;

public class GetPointsOfTournamentTest {

    TournamentsService tournamentsService;
    @BeforeClass
    public void beforeClass()
    {
        tournamentsService=new TournamentsService() ;
    }

    @Test
    @Step
    public void shouldGetPointOfTournament()
    {
       GetPointsOfTournamentResponse getPointsOfTournamentResponse= tournamentsService.getTournamentPoints();
        getPointsOfTournamentResponse.assertGetPointsOfTournament();

    }
}
