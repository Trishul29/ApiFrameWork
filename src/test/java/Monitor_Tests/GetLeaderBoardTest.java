package Monitor_Tests;

import Users.service.LeaderBoardService;
import Users.service.MatchOfficialsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import util.FileUtility;

import java.util.Properties;

import static org.testng.Assert.*;

public class GetLeaderBoardTest {
    private LeaderBoardService leaderBoardService;
    private  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";


    @BeforeClass
    public void beforeClass()
    {

        leaderBoardService=new LeaderBoardService();

    }
    @Test
    public void shouldGetLeaderBoardTest()
    {
      GetAllPlayerLeaderBoardResponse getAllPlayerLeaderBoardResponse = leaderBoardService.getLeaderBoard();
      assertEquals(getAllPlayerLeaderBoardResponse.getSuccess(),"true","Not able to Fetch Response");
      assertEquals(getAllPlayerLeaderBoardResponse.getStatusCode(),200,"Request Unsuccessfull");
       assertTrue(getAllPlayerLeaderBoardResponse.getResponseTime()<2);
        assertNotNull(getAllPlayerLeaderBoardResponse.getData().getDocs()[0].getUser().getFirstName());
        assertNotNull(getAllPlayerLeaderBoardResponse.getData().getDocs()[0].getMatches());
        assertNotNull(getAllPlayerLeaderBoardResponse.getData().getDocs()[0].getRuns());
        assertNotNull(getAllPlayerLeaderBoardResponse.getData().getDocs()[0].getStrikeRate());
        for(int i=0; i< getAllPlayerLeaderBoardResponse.getData().getDocs().length;i++)
        {
        assertNotNull(getAllPlayerLeaderBoardResponse.getData().getDocs()[i].getUser().get_id());
        }

    }

}
