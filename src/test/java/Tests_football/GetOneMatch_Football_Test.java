package Tests_football;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Match.GetOneMatch_FootballResponse;

public class GetOneMatch_Football_Test {

    MatchesService matchesService;
    @BeforeClass
    public void beforeClass()
    {
        matchesService=new MatchesService();
    }
    @Test
    public void shouldGetOneMatch_Football()
    {

      GetOneMatch_FootballResponse getOneMatch_footballResponse= matchesService.getOneMatchFootball();
        getOneMatch_footballResponse.assertOneMatchFootBall();
    }
}
