package Monitor_Tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plain_json_response.GetAllMatchesResponse;


import static org.testng.Assert.*;

public class GetAllMatchesTest {
   GetAllMatchesResponse getAllMatchesResponse;

    @BeforeClass
    public void beforeClass() {

      getAllMatchesResponse=new GetAllMatchesResponse();
    }
@Test
    public  void shouldGetAllMatches()
    {
assertTrue(getAllMatchesResponse.getResponseTime()<3,"Taking too much time to process request");
assertTrue(getAllMatchesResponse.getSuccess(),"Success failure");
assertEquals(getAllMatchesResponse.getStatusCode(),200,"Not able to get All matches");
assertNotNull(getAllMatchesResponse.getId(),"Match id not present");
assertNotNull(getAllMatchesResponse.getMatchType(),"MatchType not present");
assertNotNull(getAllMatchesResponse.getBallType(),"Ball Type not present");
assertNotNull(getAllMatchesResponse.getName(),"Team 1 name not present");
assertNotNull(getAllMatchesResponse.getLogo(),"Team 1 logo not presenet");
assertNotNull(getAllMatchesResponse.getTeamTwoId(),"Team one Id not Present");
assertNotNull(getAllMatchesResponse.getTeamTwoName(),"Team 2 name not present");
assertNotNull(getAllMatchesResponse.getTeamTwoLogo(),"Team 2 logo not presenet");
assertNotNull(getAllMatchesResponse.getTeamTwoId(),"Team 2 Id not Present");
assertNotNull(getAllMatchesResponse.getCity(),"City not present");
assertNotNull(getAllMatchesResponse.getCountry(),"Country not present");
assertNotNull(getAllMatchesResponse.getGroundName(),"Ground name not present");
assertNotNull(getAllMatchesResponse.getReason(),"Reason not present");

    }

}
