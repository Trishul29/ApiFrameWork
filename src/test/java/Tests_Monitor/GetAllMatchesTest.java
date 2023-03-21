package Tests_Monitor;
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
    public  void shouldGetAllMatches()
    {
        getAllMatchesResponse.assertGetAllMatches();

    }


}
