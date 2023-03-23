package Tests_Monitor;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plain_json_response.GetAllMatchesResponse;

public class GetAllMatchesTest {
   GetAllMatchesResponse getAllMatchesResponse;

    @BeforeClass
    public void beforeClass() {

      getAllMatchesResponse=new GetAllMatchesResponse();
    }
@Test
@Step("{0}")
public  void shouldGetAllMatches()
    {
        getAllMatchesResponse.assertGetAllMatch();

    }


}
