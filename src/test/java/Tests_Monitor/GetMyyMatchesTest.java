package Tests_Monitor;

import modules.service.MatchesService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.getAll.matches.GetMyyMatchesResponse;

public class GetMyyMatchesTest {
    MatchesService matchesService;
    @BeforeClass
    public void beforeClass()
    {
matchesService=new MatchesService();

    }
    @DataProvider(name = "roleAndType")
    public Object[][] getType() {
        return new Object[][]{
                {"scorer","live"},
                {"scorer","end"},
                {"scorer","upcoming"},
                {"streamer","live"},
                {"streamer","end"},
                {"streamer","upcoming"},

        };
    }

    @Test(dataProvider = "roleAndType")
    public void shouldGetMyyMatchesUsingRole(String role,String type)
    {
     GetMyyMatchesResponse getMyyMatchesResponse= matchesService.getMyyMatchesUsingRole(role,type);
     getMyyMatchesResponse.assertMyyMatches();
    }
}
