package Tests_Monitor;

import com.github.javafaker.Faker;
import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetTournamentLeaderBoardResponse;

public class GetTournamentLeaderBoardTest {
    TournamentsService tournamentsService;

    String[] filterTypes = {"batting", "bowling","fielding"};
    String subFilter;
    String filter = filterTypes[Faker.instance().random().nextInt(filterTypes.length)];


    @BeforeClass
    public void beforeClass()
    {
tournamentsService=new TournamentsService();
        if (filter.equals("bowling")) {
            String[] bowlingSubFilterTypes = {"bowlingAvg","mostWickets"};
            subFilter = bowlingSubFilterTypes[Faker.instance().random().nextInt(bowlingSubFilterTypes.length)];
        } else {
            String[] battingSubFilterTypes = {"battingAvg", "mostRuns", "strikeRate"};
            subFilter = battingSubFilterTypes[Faker.instance().random().nextInt(battingSubFilterTypes.length)];
        }


    }
    @Test
    public void shouldGetTournamentLeaderBoard()
    {



        GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse = tournamentsService.getTournamentLeaderBoardResponseService(filter, subFilter);

        getTournamentLeaderBoardResponse.assertGetTournamentLeaderBoardResponse();



    }
}
