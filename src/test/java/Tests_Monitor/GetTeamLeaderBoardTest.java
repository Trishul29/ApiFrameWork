//package Tests_Monitor;
//
//import com.github.javafaker.Faker;
//import modules.service.TeamsService;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pojo.get.Team.GetTeamLeaderBoardResponse;
//
//public class GetTeamLeaderBoardTest {
//    TeamsService teamsService;
//    FilterUtility filterUtility;
//    String filter;
//    String subFilter;
//
//    @BeforeClass
//    public void beforeClass() {
//        teamsService = new TeamsService();
//        filterUtility=new FilterUtility();
//
//        filter = filterUtility.filterTypes[Faker.instance().random().nextInt(filterUtility.filterTypes.length)];
//        if (filter.equals("bowling")) {
//
//
//            subFilter = filterUtility.bowlingSubFilterTypes[Faker.instance().random().nextInt(filterUtility.bowlingSubFilterTypes.length)];
//        } else if (filter.equals("batting")) {
//
//            subFilter = filterUtility.battingSubFilterTypes[Faker.instance().random().nextInt(filterUtility.battingSubFilterTypes.length)];
//        } else if (filter.equals("fielding")) {
//
//            subFilter = filterUtility.fieldingSubFilters[Faker.instance().random().nextInt(filterUtility.fieldingSubFilters.length)];
//        } else if (filter.equals("wicketKeeping")) {
//
//            subFilter = filterUtility.wicketKeepingSubFilterTypes[Faker.instance().random().nextInt(filterUtility.wicketKeepingSubFilterTypes.length)];
//        } else if (filter.equals("mvp")) {
//            subFilter = "";
//
//        }
//
//    }
//    @Test
//    public void shouldGetTeamLeaderBoard()
//    {
//// first value After subfilter matchType->0,1,2,3,4 ,second value time filter ->0,1,2,3,4
//
//    GetTeamLeaderBoardResponse getTeamLeaderBoardResponse    =teamsService.getTeamLeaderBoardService(filter,subFilter+",2,0");
//    getTeamLeaderBoardResponse.assertGetTeamLeaderBoardResponse();
//
//    }
//}
package Tests_Monitor;

import Tests_Monitor.Test_Utility.FilterUtility;
import modules.service.TeamsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.get.Team.GetTeamLeaderBoardResponse;

public class GetTeamLeaderBoardTest {
    TeamsService teamsService;
    FilterUtility filterUtility;


    @BeforeClass
    public void beforeClass() {
        teamsService = new TeamsService();
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
    public void shouldGetTeamLeaderBoard(String filter, String subFilter) {

        if(filter.equals("batting"))
        {

            GetTeamLeaderBoardResponse getTeamLeaderBoardResponse = teamsService.getTeamLeaderBoardService(filter, subFilter+",2,0");
            getTeamLeaderBoardResponse.assertGetTeamLeaderBoardResponse();
            getTeamLeaderBoardResponse.assertRankingForBattingStrikeRateAndAverage();
        }

else if(filter.equals("bowling") && (!subFilter.equals("mostWickets"))) {
        // first value After subfilter matchType->0,1,2,3,4 ,second value time filter ->0,1,2,3,4
            //
        GetTeamLeaderBoardResponse getTeamLeaderBoardResponse = teamsService.getTeamLeaderBoardService(filter, subFilter + ",2,0");
        getTeamLeaderBoardResponse.assertGetTeamLeaderBoardResponse();
          getTeamLeaderBoardResponse.assertRankMovement();
        getTeamLeaderBoardResponse.assertRankingForBowling();
    } else if (filter.equals("mvp")) {
            GetTeamLeaderBoardResponse getTeamLeaderBoardResponse = teamsService.getTeamLeaderBoardService(filter, subFilter + "2,0");
            getTeamLeaderBoardResponse.assertRankMovement();
            getTeamLeaderBoardResponse.assertGetTeamLeaderBoardResponse();

        }
else {
            GetTeamLeaderBoardResponse getTeamLeaderBoardResponse = teamsService.getTeamLeaderBoardService(filter, subFilter + ",2,0");
           getTeamLeaderBoardResponse.assertRankMovement();
            getTeamLeaderBoardResponse.assertGetTeamLeaderBoardResponse();

        }
    }
}




