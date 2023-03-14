package Monitor_Tests;

import Users.service.MatchOfficialsService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.getAll.recommendedusers.GetRecommendedUsersResponse;
import util.FileUtility;

import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class GetRecommendedUsersTest {
    private MatchOfficialsService matchOfficialsService;
    private  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    private Properties properties;

    @BeforeClass
    public void beforeClass()
    {
        matchOfficialsService=new MatchOfficialsService();
        properties = FileUtility.loadProperties(propertyPath);
    }
    @Test
    public void shouldGetRecommendedUsers()
    {
      //  String =properties.getProperty("teamid");
       GetRecommendedUsersResponse getRecommendedUsersResponse=matchOfficialsService.getRecommendedUsers();
        assertEquals(getRecommendedUsersResponse.getStatusCode(),200,"Not able to get Recommended Users");
        assertEquals(getRecommendedUsersResponse.getSuccess(),"true","Success Return False ");


    }
}
