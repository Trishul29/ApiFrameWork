package positivetests;

import Users.client.MatchHighlightsClient;
import Users.service.TournamentsService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.get.GetHighlightResponse;
import util.FileUtility;

import static org.testng.Assert.assertNotNull;

public class GetMatchHighlightsTest {

   GetHighlightResponse getHighlightResponse;

    @BeforeClass
    public void beforeClass() {

        getHighlightResponse=new GetHighlightResponse();
    }

    @Test
    public void test_MatchHighLightResponse() {


        assertNotNull(getHighlightResponse.getId(),"Highlights not created");
        assertNotNull(getHighlightResponse.getTeamOneId(),"");
        assertNotNull(getHighlightResponse.getTeamTwoId(),"");assertNotNull(getHighlightResponse.getInning(),"");
        assertNotNull(getHighlightResponse.getTitle(),"");
        assertNotNull(getHighlightResponse.getScore(),"");
        assertNotNull(getHighlightResponse.getOvers(),"");
        assertNotNull(getHighlightResponse.getFinalScore(),"");

    }


}
