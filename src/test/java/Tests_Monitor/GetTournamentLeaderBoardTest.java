package Tests_Monitor;

import Tests_Monitor.Test_Utility.FilterUtility;
import modules.service.TournamentsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.get.Tournaments.GetTournamentLeaderBoardResponse;

public class GetTournamentLeaderBoardTest {
    TournamentsService tournamentsService;
    FilterUtility filterUtility;

//    String[] filterTypes = {"batting", "bowling", "fielding", "wicketKeeping", "mvp"};
//    String subFilter;
    //  String filter = filterTypes[Faker.instance().random().nextInt(filterTypes.length)];


    @BeforeClass
    public void beforeClass() {
        tournamentsService = new TournamentsService();
        filterUtility = new FilterUtility();

    }

    @DataProvider(name = "filterSubFilterProvider")
    public Object[][] getFilterSubFilter() {
        return new Object[][]{
                {"bowling", filterUtility.bowlingSubFilterTypes[0]},
                {"bowling", filterUtility.bowlingSubFilterTypes[1]},
                {"bowling", filterUtility.bowlingSubFilterTypes[2]},
                {"batting", filterUtility.battingSubFilterTypes[0]},
                {"batting", filterUtility.battingSubFilterTypes[1]},
                {"batting", filterUtility.battingSubFilterTypes[2]},
                {"fielding", filterUtility.fieldingSubFilters[0]},
                {"fielding", filterUtility.fieldingSubFilters[1]},
                {"wicketKeeping", filterUtility.wicketKeepingSubFilterTypes[0]},
                {"wicketKeeping", filterUtility.wicketKeepingSubFilterTypes[1]},
                {"wicketKeeping", filterUtility.wicketKeepingSubFilterTypes[2]},

                {"mvp", ""}
        };
    }

    @Test(dataProvider = "filterSubFilterProvider")
    public void shouldGetTournamentLeaderBoard(String filter, String subFilter) {

        if (filter.equals("bowling") && (!subFilter.equals("mostWickets"))) {
            GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse = tournamentsService.getTournamentLeaderBoardResponseService(filter, subFilter + ",2");

            getTournamentLeaderBoardResponse.assertGetTournamentLeaderBoardResponse();
            getTournamentLeaderBoardResponse.assertRankingForBowling();

        } else if (filter.equals("batting")) {
            GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse = tournamentsService.getTournamentLeaderBoardResponseService(filter, subFilter + ",2");

            getTournamentLeaderBoardResponse.assertGetTournamentLeaderBoardResponse();
            getTournamentLeaderBoardResponse.assertRankingForBattingStrikeRateAndAverage();

        } else if (filter.equals("mvp")) {
            GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse = tournamentsService.getTournamentLeaderBoardResponseService(filter, subFilter + "2");

            getTournamentLeaderBoardResponse.assertGetTournamentLeaderBoardResponse();

        } else {
            GetTournamentLeaderBoardResponse getTournamentLeaderBoardResponse = tournamentsService.getTournamentLeaderBoardResponseService(filter, subFilter + ",2");

            getTournamentLeaderBoardResponse.assertGetTournamentLeaderBoardResponse();

        }


    }
}
