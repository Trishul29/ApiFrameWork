package Tests_Monitor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plain_json_response.GetHighlightResponse;
import static org.testng.Assert.assertNotNull;

public class GetMatchHighlightsTest {

   GetHighlightResponse getHighlightResponse;

    @BeforeClass
    public void beforeClass() {

        getHighlightResponse=new GetHighlightResponse();
    }

    @Test
    public void shouldGetMatchHighLight() {


        assertNotNull(getHighlightResponse.getId(),"Highlights not created");
        assertNotNull(getHighlightResponse.getTeamOneId(),"");
        assertNotNull(getHighlightResponse.getTeamTwoId(),"");
        assertNotNull(getHighlightResponse.getInning(),"");
        assertNotNull(getHighlightResponse.getTitle(),"");
        assertNotNull(getHighlightResponse.getScore(),"");
        assertNotNull(getHighlightResponse.getOvers(),"");
        assertNotNull(getHighlightResponse.getFinalScore(),"");

    }


}
