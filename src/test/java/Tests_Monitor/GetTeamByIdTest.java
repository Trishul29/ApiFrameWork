package Tests_Monitor;

import modules.service.TeamsService;
import pojo.get.Team.GetTeamResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.FileUtility;

import java.util.Properties;

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
       getTeamResponse.assertGetTeamResponse();

    }
}
