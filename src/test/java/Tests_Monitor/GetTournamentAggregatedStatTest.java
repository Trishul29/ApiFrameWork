package Tests_Monitor;

import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetTournamentAggregatedStatResponse;

public class GetTournamentAggregatedStatTest {
    TournamentsService tournamentsService;
    @BeforeClass
    public void beforeClass()
    {
        tournamentsService=new TournamentsService();

    }
    @Test
    public void shouldGetAggregatedStat()
    {

       GetTournamentAggregatedStatResponse getTournamentAggregatedStatResponse= tournamentsService.getAggregateStats();
       getTournamentAggregatedStatResponse.assertAggregatedTournamentStats();
    }
}
