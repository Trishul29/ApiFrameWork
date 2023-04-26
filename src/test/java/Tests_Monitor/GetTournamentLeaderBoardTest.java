package Tests_Monitor;

import com.github.javafaker.Faker;
import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetTournamentLeaderBoardResponse;

public class GetTournamentLeaderBoardTest {
    TournamentsService tournamentsService;

    String[] filterTypes = {"batting", "bowling", "fielding", "wicketKeeping", "mvp"};
    String subFilter;
    String filter = filterTypes[Faker.instance().random().nextInt(filterTypes.length)];


    @BeforeClass
    public void beforeClass() {
        tournamentsService = new TournamentsService();
        if (filter.equals("bowling")) {
            String[] bowlingSubFilterTypes = {"bowlingAvg", "mostWickets", "strikeRate"};
            subFilter = bowlingSubFilterTypes[Faker.instance().random().nextInt(bowlingSubFilterTypes.length)];
        } else if (filter.equals("batting")) {
            String[] battingSubFilterTypes = {"battingAvg", "mostRuns", "strikeRate"};
            subFilter = battingSubFilterTypes[Faker.instance().random().nextInt(battingSubFilterTypes.length)];
        } else if (filter.equals("fielding")) {
            String[] fieldingSubFilters = {"catches", "runOuts"};
            subFilter = fieldingSubFilters[Faker.instance().random().nextInt(fieldingSubFilters.length)];
        } else if (filter.equals("wicketKeeping")) {
            String[] wicketKeepingSubFilterTypes = {"stumping", "caughtBehind", "catches"};
            subFilter = wicketKeepingSubFilterTypes[Faker.instance().random().nextInt(wicketKeepingSubFilterTypes.length)];
        } else if (filter.equals("mvp")) {
            subFilter = "";

        }


    }

    @Test
    public void shouldGetTournamentLeaderBoard() {


        GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse = tournamentsService.getTournamentLeaderBoardResponseService(filter, subFilter);

        getTournamentLeaderBoardResponse.assertGetTournamentLeaderBoardResponse();


    }
}
