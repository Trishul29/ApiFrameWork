package plain_json_response;

import io.qameta.allure.Allure;
import modules.client.MatchHighlightsClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@Getter
public class GetHighlightResponse {
    @Setter
    int statusCode;
    MatchHighlightsClient matchHighlightsClient=new MatchHighlightsClient();
    Response response = matchHighlightsClient.getHighlights();
    long responseTime =response.timeIn(TimeUnit.SECONDS);
    String response_in_mili_seconds=Long.toString(responseTime);
    JsonPath jsonPath = response.body().jsonPath();
    String id = jsonPath.get("data.docs[0].hightlight.id");
    String teamOneId=jsonPath.get("data.docs[0].hightlight.matchId.teamOne.teamId.id");
    String teamTwoId=jsonPath.get("data.docs[0].hightlight.matchId.teamTwo.teamId.id");
    String inning=jsonPath.get("data.docs[0].hightlight.metaData.inning");
    String title=jsonPath.get("data.docs[0].hightlight.metaData.title");
    String score=jsonPath.get("data.docs[0].hightlight.metaData.score");
    float overs=jsonPath.get("data.docs[0].hightlight.metaData.overs");
    int finalScore=jsonPath.get("data.docs[0].hightlight.metaData.totalScore.score");


    public void assertGetHighlight()
    {

        assertTrue(this.getResponseTime()<3000,"Taking too Much Time to Process the Request ");
        assertNotNull(this.getId(),"Highlights not created");
        assertNotNull(this.getTeamOneId(),"Team one id not present");
        assertNotNull(this.getTeamTwoId(),"Team two id not present");
        assertNotNull(this.getInning(),"Inning not present");
        assertNotNull(this.getTitle(),"title not present");
        assertNotNull(this.getScore(),"Score not present");
        assertNotNull(this.getOvers(),"overs not present");
        assertNotNull(this.getFinalScore(),"Final score not present");
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");}
}
