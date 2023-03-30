package Tests_football;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plain_json_response.GetHighlightFootballResponse;

public class GetMatchHighlights_Football_Test {
    GetHighlightFootballResponse getHighlightFootballResponse;
    @BeforeClass
    public void beforeClass()
    {
getHighlightFootballResponse=new GetHighlightFootballResponse();
    }
    @Test
    public void shouldGetFootballMatchHighlight()
    {
getHighlightFootballResponse.assertGetHighlightFootball();
    }
}
