package plain_json_response;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import modules.client.MatchHighlightsClient;
import util.AllureUtility;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Getter
public class GetHighlightFootballResponse {
    Response response = new MatchHighlightsClient().getHighlightsFootball();

    int statusCode=response.getStatusCode();

    long responseTime = response.timeIn(TimeUnit.SECONDS);
    JsonPath jsonPath = response.body().jsonPath();

    boolean success = jsonPath.getBoolean("success");
    String data = jsonPath.getString("data");
    String error = jsonPath.getString("error");
  List Docs = jsonPath.getJsonObject("data.docs");


    String highlight_id = jsonPath.getString("data.docs[0].hightlight.id");



    public void assertGetHighlightFootball() {
        new AllureUtility().getResponseTime(responseTime);
        assertTrue(this.getResponseTime() < 3000, "Taking too Much Time to Process the Request ");
       assertEquals(this.getStatusCode(),200,"Request Failure");
       assertTrue(this.success,"Success Failure");

    }
}
