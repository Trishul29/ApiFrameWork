package Tests_Monitor;
import modules.service.LeaderBoardService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;

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

      getAllPlayerLeaderBoardResponse.assertLeaderBoardResponse();
    }

}
