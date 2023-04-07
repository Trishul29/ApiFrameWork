package Tests_Monitor;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plain_json_response.GetMatchesResponse;

public class GetMatchesTest {
   GetMatchesResponse getMatchesResponse;

    @BeforeClass
    public void beforeClass() {

      getMatchesResponse =new GetMatchesResponse();
    }
@Test
@Step("{0}")
public  void shouldGetMatches()
    {
        getMatchesResponse.assertGetMatches();

    }


}
