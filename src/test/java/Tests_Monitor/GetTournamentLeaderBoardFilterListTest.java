package Tests_Monitor;

import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetTournamentLeaderBoardFilterListResponse;

public class GetTournamentLeaderBoardFilterListTest {
    TournamentsService tournamentsService;
    @BeforeClass
    public void beforeClass()
    {
       tournamentsService=new TournamentsService();

    }
   // @Test
    public void shouldGetTournamentLeaderBoardFilterList()
    {

        GetTournamentLeaderBoardFilterListResponse getTournamentLeaderBoardFilterListResponse = tournamentsService.getTournamentLeaderBoardFilterListService();
getTournamentLeaderBoardFilterListResponse.assertTournamentLeaderBoardFilterListResponse();
    }
}
