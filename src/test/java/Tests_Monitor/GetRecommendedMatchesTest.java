package Tests_Monitor;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.matches.GetRecommendedMatchesResponse;

public class GetRecommendedMatchesTest {
    MatchesService matchesService;
    @BeforeClass
    public void beforeClass()
    {
        matchesService=new MatchesService();

    }
    @Test
    public void shouldGetRecommendedMatches()
    {
      GetRecommendedMatchesResponse getRecommendedMatchesResponse= matchesService.getRecommendedMatches();

        getRecommendedMatchesResponse.assertRecommendedMatches();

    }


}
