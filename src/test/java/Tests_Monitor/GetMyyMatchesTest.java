package Tests_Monitor;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.matches.GetMyyMatchesResponse;

public class GetMyyMatchesTest {
    MatchesService matchesService;
    @BeforeClass
    public void beforeClass()
    {
matchesService=new MatchesService();

    }
    @Test
    public void shouldGetMyyMatchesUsingRole()
    {
     GetMyyMatchesResponse getMyyMatchesResponse= matchesService.getMyyMatchesUsingRole();
     getMyyMatchesResponse.assertMyyMatches();
    }
}
