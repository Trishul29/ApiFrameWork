package Tests_football;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Match.GetOneMatchStatFootballResponse;
import pojo.get.Match.GetOneMatch_FootballResponse;

public class GetOneMatch_stat_Football_Test {
    MatchesService matchesService;
    @BeforeClass
    public void beforeClass()
    {
        matchesService=new MatchesService();
    }
    @Test
    public void shouldGetOneMatchStats_Football()
    {

        GetOneMatchStatFootballResponse getOneMatchStatFootballResponse= matchesService.getOneMatchStat_Football();
        getOneMatchStatFootballResponse.assertGetOneMatchStatFootball();
    }

}
