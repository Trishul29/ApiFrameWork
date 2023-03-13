package positivetests;

import Users.service.TeamsService;
import pojo.get.GetTeamResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.FileUtility;

import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class GetTeamByIdTest {
    private TeamsService teamsService;
    private  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
   private Properties properties;

    @BeforeClass
    public void beforeClass()
    {
        teamsService=new TeamsService();
        properties = FileUtility.loadProperties(propertyPath);
    }
    @Test
    public void shouldGetTeamById()
    {
        String teamId=properties.getProperty("teamid");
        GetTeamResponse getTeamResponse=teamsService.getTeamById(teamId);
        assertEquals(getTeamResponse.getStatusCode(),200,"");
        assertEquals(getTeamResponse.getSuccess(),true);


    }
}
