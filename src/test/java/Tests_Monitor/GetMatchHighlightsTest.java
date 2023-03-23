package Tests_Monitor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plain_json_response.GetHighlightResponse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class GetMatchHighlightsTest {

   GetHighlightResponse getHighlightResponse;

    @BeforeClass
    public void beforeClass() {

        getHighlightResponse=new GetHighlightResponse();
    }

    @Test
    public void shouldGetMatchHighLight() {

getHighlightResponse.assertGetHighlight();

    }


}
