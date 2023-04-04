package Tests_Update;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Match.GetEditMatchDetailsResponse;

public class GetEditMatchDetailsTest {

    MatchesService matchesService;
    @BeforeClass
    public void beforeClass()
    {
        matchesService=new MatchesService();

    }
    @Test
    public void shouldFetchEditMatchDetails()
    {

    GetEditMatchDetailsResponse getEditMatchDetailsResponse  = matchesService.getEditMatchDetails();
        getEditMatchDetailsResponse.assertFetchEditMatch();
    }
}

