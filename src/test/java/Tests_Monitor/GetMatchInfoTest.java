package Tests_Monitor;

import modules.service.MatchesService;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.Match.GetMatchInfoResponse;

public class GetMatchInfoTest {
  MatchesService matchesService;

    @BeforeClass
    public void beforeClass()
    {
        matchesService=new MatchesService();
    }
    @Test
    @Step
    public void shouldGetMatchInfo()
    {
       GetMatchInfoResponse getMatchInfoResponse= matchesService.getMatchInfo();
     getMatchInfoResponse.assertMatchInfo();
    }
}
