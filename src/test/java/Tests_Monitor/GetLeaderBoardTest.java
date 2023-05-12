package Tests_Monitor;

import Tests_Monitor.Test_Utility.FilterUtility;
import modules.service.LeaderBoardService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import util.FileUtility;

import java.util.Properties;

public class GetLeaderBoardTest {
    private LeaderBoardService leaderBoardService;
    private FilterUtility filterUtility;
    private String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
 //   String leaderBoardType;


    @BeforeClass
    public void beforeClass() {
        Properties properties = FileUtility.loadProperties(propertyPath);
        leaderBoardService = new LeaderBoardService();
        filterUtility=new FilterUtility();

    }
    @DataProvider(name = "leaderboardTypes")
    public Object[][] leaderboardTypesProvider() {
        return new Object[][]{
                {filterUtility.leaderBoardType[0], filterUtility.matchType[0], filterUtility.dateType[0]},
                {filterUtility.leaderBoardType[0], filterUtility.matchType[0], filterUtility.dateType[1]},
                {filterUtility.leaderBoardType[0], filterUtility.matchType[0], filterUtility.dateType[2]},
                {filterUtility.leaderBoardType[0], filterUtility.matchType[1], filterUtility.dateType[0]},
                {filterUtility.leaderBoardType[0], filterUtility.matchType[1], filterUtility.dateType[1]},
                {filterUtility.leaderBoardType[0], filterUtility.matchType[1], filterUtility.dateType[2]},

                {filterUtility.leaderBoardType[1], filterUtility.matchType[0], filterUtility.dateType[0]},
                {filterUtility.leaderBoardType[1], filterUtility.matchType[0], filterUtility.dateType[1]},
                {filterUtility.leaderBoardType[1], filterUtility.matchType[0], filterUtility.dateType[2]},
                {filterUtility.leaderBoardType[1], filterUtility.matchType[1], filterUtility.dateType[0]},
                {filterUtility.leaderBoardType[1], filterUtility.matchType[1], filterUtility.dateType[1]},
                {filterUtility.leaderBoardType[1], filterUtility.matchType[1], filterUtility.dateType[2]},

        };

    }

    @Test(dataProvider ="leaderboardTypes" )
    public void shouldGetLeaderBoardTest(String leaderBoardType,String matchType,String dateType) {

        System.out.println("type"+leaderBoardType);
    if(leaderBoardType.equals("batting")) {

        GetAllPlayerLeaderBoardResponse getAllPlayerLeaderBoardResponse = leaderBoardService.getLeaderBoard(leaderBoardType, matchType, dateType);
        getAllPlayerLeaderBoardResponse.assertLeaderBoardResponseForBatting();
    } else if (leaderBoardType.equals("bowling")) {
        GetAllPlayerLeaderBoardResponse getAllPlayerLeaderBoardResponse = leaderBoardService.getLeaderBoard(leaderBoardType, matchType, dateType);
        getAllPlayerLeaderBoardResponse.assertLeaderBoardResponseForBowling();


    }

    }

}
